package adapter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;

import exception.AutoException;
import exception.AutoException.ErrNo;
import model.Automobile;
import model.SocketMessage;
import util.FileIO;

public abstract class ProxyAutomobile {
	/*
	 * main class function as bridge from inner part to outer part; Using
	 * linkedHashMap as well;
	 */
	private static LinkedHashMap<String, Automobile> automobiles = new LinkedHashMap<>();
	private AutoException autoException = new AutoException();
	// added in Unit 3
	private boolean available = false;

	FileIO readFile = new FileIO();

	public void buildAuto(Object fileName, String fileType) throws Exception {
		// BuildAuto Accroding to the object type
		Automobile newModel = new Automobile();
		try {
			if (fileType.equals("Properties")) {
				newModel = readFile.readProperties((Properties) fileName);
			} else if (fileType.equals("TextFile")) {
				newModel = readFile.buildAutoObject((String) fileName);
			}
			automobiles.put(newModel.getModel(), newModel);
		} catch (AutoException e) {
			if (e.getErrorNumber() == AutoException.ErrNo.FILEWRONG) {
				fileName = e.fix(e.getErrorNumber());
				Automobile a = readFile.buildAutoObject((String) fileName);
				automobiles.put(a.getModel(), a);
			} else {
				e.fix(e.getErrorNumber());
			}
		} catch (IOException e) {
			System.out.println("error in reading or writing file");
			e.printStackTrace();
		}
	}

	public void buildCarModelOptions() throws Exception {
		ServerSocket serverSocket = null;
		System.out.println("server start");
		try {
			serverSocket = new ServerSocket(4444);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 4444.");
			e.printStackTrace();
		}

		Socket clientSocket = null;
		while (true) {
			clientSocket = serverSocket.accept();
			ObjectInputStream in = new ObjectInputStream(
					clientSocket.getInputStream());
			Object receivedObject = null;

			try {
				receivedObject = in.readObject();

			} catch (IOException | ClassNotFoundException e) {
				System.err.println("Accept failed.");
				e.printStackTrace();
				break;
			}

			if (receivedObject instanceof Properties) {
				Properties pro = (Properties) receivedObject;
				BuildAuto auto = new BuildAuto();
				auto.buildAuto(pro, "Properties");
				PrintWriter out = new PrintWriter(
						clientSocket.getOutputStream(), true);
				// response
				out.println(" build automotive successfully");
				System.out.println(
						"Successfully receive properties and build Automotive in server");
				in.close();
				out.close();
			} else {
				SocketMessage msg = (SocketMessage) receivedObject;
				ObjectOutputStream out = new ObjectOutputStream(
						clientSocket.getOutputStream());
				String content = msg.getMessage();
				if (content.equals("getAllModels")) {
					String autoList = getAutoList();
					SocketMessage list = new SocketMessage();
					list.setMessage(autoList);
					out.writeObject(list);
					System.out.println("Send all autolist.");
				}
				in.close();
				out.close();
			}
		}
		clientSocket.close();
		serverSocket.close();
	}

	public void fix(ErrNo errNo) {
		autoException.fix(errNo);
	}

	public String getAutoList() {
		StringBuilder autoList = new StringBuilder();
		Iterator<String> iter = automobiles.keySet().iterator();
		autoList.append("<Here are all available models for you to choose>");
		while (iter.hasNext()) {
			autoList.append("\t\t");
			autoList.append(automobiles.get(iter.next()).getModel());
			autoList.append("\t\t");
		}
		autoList.append("***Please select your choice");

		return autoList.toString();
	}

	public Automobile getAutoMobile(String modelName) {
		return automobiles.get(modelName);
	}

	public synchronized String getAutoOptionChoice(String modelName,
			String setName) {
		// Synchronized get method;
		while (available == false) {
			try {
				System.out.println("waiting in getAutoOptionChoice");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Automobile Auto = getAutoMobile(modelName);
		String choice = Auto.getOptionChoice(setName);
		available = false;
		notifyAll();
		return choice;
	}

	public void printAuto(String modelName) {
		if (automobiles.containsKey(modelName)) {
			Automobile a = automobiles.get(modelName);
			a.print();
		} else {
			System.out.println("no such model!");
		}
	}

	public synchronized void setAutoOptionChoice(String modelName,
			String setName, String optionName) {
		// Synchronized set method;
		while (available == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		Automobile Auto = getAutoMobile(modelName);
		Auto.setOptionChoice(setName, optionName);
		available = true;
		notifyAll();
	}

	public void setOptionChoice(String modelName, String optionSetName,
			String optionName) {
		// call set Option choice method
		if (automobiles.containsKey(modelName)) {
			Automobile a = automobiles.get(modelName);
			a.setOptionChoice(optionSetName, optionName);
		} else {
			System.out.println("no such model to be updated");
		}
	}

	// Unit4 added

	public void updateOptionPrice(String modelName, String optionSetName,
			String optionName, float newPrice) {
		// Update Option price method
		if (automobiles.containsKey(modelName)) {
			Automobile a = automobiles.get(modelName);
			a.updateOption(optionSetName, optionName, optionName, newPrice);
		} else {
			System.out.println("no such model!");
		}
	}

	public void updateOptionSetName(String modelName, String optionSetname,
			String newName) {
		if (automobiles.containsKey(modelName)) {
			Automobile a = automobiles.get(modelName);
			a.updateOptionSet(optionSetname, newName);
		} else {
			System.out.println("no such model to be updated");
		}
	}

}

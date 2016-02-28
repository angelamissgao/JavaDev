package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import model.Automobile;
import model.SocketMessage;

public class SelectCarOption {
	/*
	 * SelectCarOption Class for client to select their Options
	 */
	private Automobile auto;

	public void getAllModels()
			throws UnknownHostException, IOException, ClassNotFoundException {
		// Get All Models
		Socket socket = new Socket(InetAddress.getLocalHost(), 4444);
		ObjectOutputStream out = new ObjectOutputStream(
				socket.getOutputStream());

		SocketMessage msg = new SocketMessage();
		msg.setMessage("getAllModels");
		out.writeObject(msg);

		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		Object receivedObject = in.readObject();

		SocketMessage socketCommunication = (SocketMessage) receivedObject;
		System.out.println(socketCommunication.getMessage());

		in.close();
		out.close();
		socket.close();
	}

	public void getModelOption() throws IOException, ClassNotFoundException {
		// Select Model
		Socket socket = new Socket(InetAddress.getLocalHost(), 4444);
		ObjectOutputStream out = new ObjectOutputStream(
				socket.getOutputStream());

		// scan user type in info
		System.out.println("***Please select your choice of model:");
		BufferedReader readFromConsole = new BufferedReader(
				new InputStreamReader(System.in));
		String modelName;
		modelName = readFromConsole.readLine();

		SocketMessage msg = new SocketMessage();
		msg.setAutoName(modelName);
		msg.setMessage("getModel");
		out.writeObject(msg);

		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		Object receivedObject = in.readObject();
		auto = (Automobile) receivedObject;
		auto.print();

		in.close();
		out.close();
		socket.close();

	}

	public void getOptions()
			throws UnknownHostException, IOException, ClassNotFoundException {
		// Select options from option sets
		Socket socket = new Socket(InetAddress.getLocalHost(), 4444);
		ObjectOutputStream out = new ObjectOutputStream(
				socket.getOutputStream());

		// scan user type in info
		BufferedReader readFromConsole = new BufferedReader(
				new InputStreamReader(System.in));
		String line1;
		String line2;
		String line3;
		System.out.println(
				"***Please type in the option name as selection for OptionSet1");
		line1 = readFromConsole.readLine();
		System.out.println(
				"***Please type in the option name as selection for OptionSet2");
		line2 = readFromConsole.readLine();
		System.out.println(
				"***Please type in the option name as selection for OptionSet3");
		line3 = readFromConsole.readLine();

		// set Options
		SocketMessage msg = new SocketMessage();
		msg.setAutoName(auto.getModel());
		msg.addOptions(line1);
		msg.addOptions(line2);
		msg.addOptions(line3);
		msg.setMessage("setOption");
		out.writeObject(msg);

		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		Object receivedObject = in.readObject();
		auto = (Automobile) receivedObject;
		auto.print();

		in.close();
		out.close();
		socket.close();
	}
}

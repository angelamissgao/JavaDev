package server;

import java.net.*;
import java.io.*;

public class DefaultSocketClient extends Thread {
	private boolean DEBUG = true;
	private int iPort;
	private BufferedReader reader;
	private Socket sock;
	private String strHost;
	private BufferedWriter writer;

	public DefaultSocketClient(String strHost, int iPort) {
		// constructor
		setPort(iPort);
		setHost(strHost);
	}

	public void closeSession() {
		try {
			writer = null;
			reader = null;
			sock.close();
		} catch (IOException e) {
			if (DEBUG)
				System.err.println("Error closing socket to " + strHost);
		}
	}

	public void handleSession() {
		String strInput = "";
		if (DEBUG)
			System.out
					.println("Handling session with " + strHost + ":" + iPort);
		try {
			while ((strInput = reader.readLine()) != null)
				System.out.println(strInput);
		} catch (IOException e) {
			if (DEBUG)
				System.out.println(
						"Handling session with " + strHost + ":" + iPort);
		}
	}

	public boolean openConnection() {
		try {
			sock = new Socket(strHost, iPort);
		} catch (IOException socketError) {
			if (DEBUG)
				System.err.println("Unable to connect with " + strHost);
			return false;
		}
		try {
			reader = new BufferedReader(
					new InputStreamReader(sock.getInputStream()));
			writer = new BufferedWriter(
					new OutputStreamWriter(sock.getOutputStream()));
		} catch (Exception e) {
			if (DEBUG)
				System.err
						.println("Unable to obtain stream to/from " + strHost);
			return false;
		}
		return true;
	}

	public void run() {
		if (openConnection()) {
			handleSession();
			closeSession();
		}
	}

	private void setHost(String strHost) {
		this.strHost = strHost;
	}

	private void setPort(int iPort) {
		this.iPort = iPort;
	}

}

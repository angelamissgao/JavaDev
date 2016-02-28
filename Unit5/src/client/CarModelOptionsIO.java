package client;

import java.io.*;
import java.net.*;
import java.util.*;

import adapter.BuildAuto;

public class CarModelOptionsIO {
	public void clientBuildAuto(Object file, String fileType) throws Exception {
		BuildAuto auto = new BuildAuto();
		auto.buildAuto(file, fileType);
	}

	public void uploadCar(String propertiesName) throws IOException {
		// Upload auto properties class
		Properties properties = new Properties();
		InputStream input = new FileInputStream(propertiesName);
		properties.load(input);

		Socket socket = new Socket(InetAddress.getLocalHost(), 4444);
		InputStream in = socket.getInputStream();
		ObjectOutputStream out = new ObjectOutputStream(
				socket.getOutputStream());
		out.writeObject(properties);

		BufferedReader message = new BufferedReader(new InputStreamReader(in));
		String response = null;

		while (in.available() == 0) { // wait for response from server
		}

		if ((response = message.readLine()) != null) {
			System.out.print("Got successful message from server: ");
			System.out.println(response);
		} else {
			System.out.println(
					"upload model fail, no message was received from client");
		}
		in.close();
		out.close();
		socket.close();
	}
}

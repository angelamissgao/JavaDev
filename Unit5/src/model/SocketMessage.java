package model;

import java.io.Serializable;
import java.util.ArrayList;

public class SocketMessage implements Serializable {
	/**
	 * Socket Message Model Class to define the socket object
	 */
	private static final long serialVersionUID = 1L;
	private String autoName;
	private String msg;
	private ArrayList<String> options = new ArrayList<>();

	public void addOptions(String option) {
		options.add(option);
	}

	public String getAutoName() {
		return this.autoName;
	}

	public String getMessage() {
		return msg;
	}

	public ArrayList<String> getOptions() {
		return options;
	}

	public void setAutoName(String autoName) {
		this.autoName = autoName;
	}

	public void setMessage(String inmsg) {
		this.msg = inmsg;
	}
}

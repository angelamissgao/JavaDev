package scale;

import adapter.*;

public class EditOptions extends Thread {
	/**
	 * EditOptions use synchronized methods in the Automobile class 
	 * to operate on Automobile LinkedHashMap instance in proxyAutomotive
	 */
	private BuildAuto buildAuto;
	private String modelName;
	private String optionName;
	private String optionSetName;
	
	
	public EditOptions(BuildAuto buildAuto, String modelName, String optionSetName, String optionName) {
		this.buildAuto = buildAuto;
		this.optionSetName = optionSetName;
		this.optionName = optionName;
		this.modelName = modelName;
		
	}

	public void run() {
		buildAuto.setAutoOptionChoice(this.modelName, this.optionSetName, this.optionName);
		System.out.println("Thread 2: Set option finished!");
	}
	
}

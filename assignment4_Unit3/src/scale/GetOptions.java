package scale;

import adapter.BuildAuto;

public class GetOptions extends Thread{
	/**
	 * GetOptions used as a Consumer Model, and extend Thread as well;
	 */
	private BuildAuto buildAuto;
	private String modelName;
	private String setName;
	
	public GetOptions (BuildAuto buildAuto, String modelName, String setName) {
		this.buildAuto = buildAuto;
		this.modelName = modelName;
		this.setName = setName;
	}
	
	@Override
	public void run() {
		String choice = buildAuto.getAutoOptionChoice(this.modelName, this.setName);
		System.out.println("Thread 1 : Successfully get the choice of: " + choice);
	}
}

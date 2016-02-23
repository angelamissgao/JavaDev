package adapter;

public interface EditAuto {
	/*
	 * Create an API to expose ProxyAutomotive class through BuildAuto
	 */
	public String getAutoOptionChoice(String modelName, String setName);

	public void setAutoOptionChoice(String modelName, String setName,
			String optionName);
}

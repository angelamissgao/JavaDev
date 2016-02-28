package adapter;

public interface UpdateAuto {
	// Update Auto Interface
	public void setOptionChoice(String modelName, String optionSetName,
			String optionName);

	public void updateOptionPrice(String modelName, String optionName,
			String option, float newPrice);

	public void updateOptionSetName(String modelName, String optionSetName,
			String newName);
}

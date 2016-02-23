package adapter;

public interface UpdateAuto {
	public void updateOptionPrice(String Modelname, String Optionname,
			String Option, float newprice);

	public void updateOptionSetName(String Modelname, String OptionSetname,
			String newName);
}

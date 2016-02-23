package model;

import java.io.Serializable;
import java.util.ArrayList;

import model.OptionSet.Option;

public class Automobile implements Serializable {
	/**
	 * public Automobile class
	 */
	private static final long serialVersionUID = 1L;
	private float basePrice;
	// PartB:
	private String make;
	private String model;
	private ArrayList<OptionSet> optionSet;

	private int optionSetSize;

	public Automobile() {
		// constructor method
		this.make = "";
		this.model = "";
		this.basePrice = 0;
		this.optionSetSize = 0;
		this.optionSet = new ArrayList<OptionSet>();
	}

	public Automobile(String make, String model, float basePrice,
			int optionSetSize) {
		// constructor method
		this.make = make;
		this.model = model;
		this.basePrice = basePrice;
		this.optionSetSize = optionSetSize;
		this.optionSet = new ArrayList<OptionSet>();
		for (int i = 0; i < optionSetSize; i++) {
			this.optionSet.add(new OptionSet());
		}

	}

	public void deleteOption(String optionSetName, String optionName) {
		// delete option from optionSet
		int index = findOptionSet(optionSetName);
		if (index < optionSetSize) {
			optionSet.get(index).deleteOption(optionName);
		} else
			System.out.println("no such option set to delete data.");
	}

	public void deleteOptionSet(String name) {
		// delete OptionSet
		int index = findOptionSet(name);
		if (index < optionSetSize) {
			optionSet.get(index).setName("");
			optionSet.get(index).deleteAll();
		} else
			System.out.println("no such option set to delete data.");
	}

	public int findOptionSet(String name) {
		// find the first OptionSet with the given name, if exists, return
		// index.
		int i = 0;
		for (; i < optionSetSize; i++) {
			if (optionSet.get(i).getName().equals(name)) {
				System.out.println("Successfully Find the option set:");
				break;
			}
		}
		if (i == optionSetSize) {
			System.out.println("No such option set");
		}
		return i;
	}

	public ArrayList<Option> getAllOptions(int optionSetIndex) {
		// getAllOptions from index
		if (optionSetIndex >= optionSetSize) {
			System.out
					.println("no such options. Option set number is too large");
			return null;
		}
		return optionSet.get(optionSetIndex).getAllOptions();
	}

	public ArrayList<OptionSet> getAllOptionSets() {
		// return optionSet
		return optionSet;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getOptionChoice(String setName) {
		int index = findOptionSet(setName);
		if (index < optionSet.size()) {
			return optionSet.get(index).getName();// Right? or getAllOptions()
		}
		return "No such Oprion Choice!";
	}

	public float getOptionChoicePrice(String setName) {
		int index = findOptionSet(setName);
		return this.optionSet.get(index).getOptionChoice().getPrice();
	}

	public OptionSet getOptionSet(int i) {
		// return OptionSet
		if (i >= optionSetSize) {
			System.out.println(
					"no such optionset. Option set number is too large");
			return null;
		}
		return optionSet.get(i);
	}

	public int getOptionSetsize() {
		// get OptionSetsize
		return optionSetSize;
	}

	public float getPrice() {
		// return base price
		return basePrice;
	}

	public float getTotalPrice() {
		//get total price;
		float sum = 0;
		for (int i = 0; i < optionSetSize; i++) {
			sum = sum + this.optionSet.get(i).getOptionChoice().getPrice();
		}
		return sum;
	}

	public void print() {
		System.out.println("Model Name: " + this.model);
		System.out.println("Make Name: " + this.make);
		System.out.println("Base Price: " + this.basePrice);
		System.out.println("OptionSet Size: " + this.optionSetSize);
		for (int i = 0; i < this.optionSetSize; i++) {
			System.out.println();
			System.out.println("OptionSet #" + (i + 1));
			this.optionSet.get(i).print();
			System.out.println("Choice: "
					+ this.optionSet.get(i).getOptionChoice().getName());
		}
	}

	public void setMake(String newMake) {
		this.make = newMake;
	}

	public void setModel(String newModel) {
		this.model = newModel;
	}

	public void setOption(int optSetIndex, int optIndex, String optionName,
			float price) {
		// set option
		if (optSetIndex < optionSetSize) {
			this.optionSet.get(optSetIndex).setOption(optIndex, optionName,
					price);
		} else
			System.out.println("no such option set to set data.");
	}

	public void setOptionChoice(String setName, String optionName) {
		// choosing a particular option in an option set
		int setindex = findOptionSet(setName);
		this.optionSet.get(setindex).setOptionChoice(optionName);
	}

	public void setOptionSet(int index, String optsetName, int optSize) {
		// set OptionSet
		if (index < optionSetSize) {
			this.optionSet.get(index).setName(optsetName);
			this.optionSet.get(index).setOptionSize(optSize);
		} else
			System.out.println("no such option set to set data.");
	}

	public void setOptionSetsize(int optionSetSize) {
		// set Option set size
		this.optionSetSize = optionSetSize;
		this.optionSet = new ArrayList<OptionSet>();
		for (int i = 0; i < optionSetSize; i++) {
			this.optionSet.add(new OptionSet());
		}
	}

	public void setPrice(float price) {
		this.basePrice = price;
	}

	public void updateOption(String optionSetName, String oldName,
			String newName, float newPrice) {
		// update an option by name and its related information;
		int index = findOptionSet(optionSetName);
		if (index < optionSetSize) {
			optionSet.get(index).updateOption(oldName, newName, newPrice);
		} else {
			System.out.println("Such option set does not exist when update!");
		}
	}

	public void updateOptionSet(String oldName, String newName) {
		// update an option set by name and its related information;
		int index = findOptionSet(oldName);
		if (index < optionSetSize) {
			optionSet.get(index).setName(newName);
			System.out.println("option set update completed!");
		} else {
			System.out.println("Such option set does not exist when update!");
		}
	}

}

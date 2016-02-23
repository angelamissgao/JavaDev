package model;

import java.io.Serializable;

public class OptionSet implements Serializable {
	// OptionSet Class hold properties;
	protected class Option implements Serializable {
		/**
		 * Inner class of OptionSet
		 */
		private static final long serialVersionUID = 1L;
		private String name;
		private float price;

		protected Option() {
			// constructor method
			name = "";
			price = 0;
		}

		protected Option(String name, float price) {
			// overload constructor method
			this.name = name;
			this.price = price;
		}

		protected String getName() {
			// return the name of the option
			return name;
		}

		protected float getPrice() {
			// return the price of the option
			return price;
		}

		protected void print() {
			System.out.println("Option: " + this.name + " / " + this.price);

		}

		protected void setName(String name) {
			// set the name of the option
			this.name = name;
		}

		protected void setPrice(float price) {
			// set the price of the option
			this.price = price;
		}

	}

	private static final long serialVersionUID = 1L;
	private String name;
	private Option opt[];
	private int optionSize;

	protected OptionSet() {
		// constructor
		this.name = "";
	}

	protected OptionSet(String name) {
		// constructor
		this.name = name;
	}

	protected OptionSet(String name, int optionSize) {
		// constructor
		this.name = name;
		this.optionSize = optionSize;
		this.opt = new Option[optionSize];
		for (int i = 0; i < optionSize; i++) {
			this.opt[i] = new Option();
		}
	}

	protected void deleteAll() {
		for (int i = 0; i < optionSize; i++) {
			opt[i].setName("");
			opt[i].setPrice(0);
		}
	}

	protected void deleteOption(String optName) {
		// delete option by optName
		int i = findOption(optName);
		if (i < optionSize) {
			opt[i].setName("");
			opt[i].setPrice(0);
			System.out.println("delete option completed.");
		} else
			System.out.println("no such option to delete data.");
	}

	protected int findOption(String name) {
		// find the first Option with the given name, if exists, return index.
		int i = 0;
		for (; i < optionSize; i++) {
			if (opt[i].getName().equals(name)) {
				System.out.println("Successfully Find the option:");
				break;
			}
		}
		if (i == optionSize) {
			System.out.println("No such option");
		}
		return i;
	}

	protected Option[] getAllOptions() {
		// return all options
		return opt;
	}

	protected String getName() {
		return name;
	}

	protected Option getOption(int i) {
		// return option by index
		if (i < optionSize) {
			return opt[i];
		} else {
			System.out.println("no such option. Option number is too large");
			return null;
		}
	}

	protected int getOptionSize() {
		// get OptionSize
		return optionSize;
	}

	protected void print() {
		System.out.println("OptionSet Name: " + this.name);
		for (int i = 0; i < this.optionSize; i++) {
			this.opt[i].print();
		}
	}

	protected void setName(String name) {
		// set optionset name
		this.name = name;
	}

	protected void setOption(int index, String name, float price) {
		// set option
		if (index < optionSize) {
			opt[index].setName(name);
			opt[index].setPrice(price);
		} else
			System.out.println("the index is too big to set an option!");
	}

	protected void setOptionSize(int optionSize) {
		// set option size
		this.optionSize = optionSize;
		this.opt = new Option[optionSize];
		for (int i = 0; i < optionSize; i++) {
			this.opt[i] = new Option();
		}
	}

	protected void updateOption(String oldName, String newName,
			float newPrice) {
		// update an option by option name
		int i = findOption(oldName);
		if (i < optionSize) {
			opt[i].setName(newName);
			opt[i].setPrice(newPrice);
			System.out.println("option update completed!");
		} else {
			System.out.println("Such option does not exist when update!");
		}
	}
}

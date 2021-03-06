package model;

import java.io.*;

import model.OptionSet.Option;

public class Automotive implements Serializable {
    /**
	 * public Automotive class
	 */
    private static final long serialVersionUID = 1L;
    private float basePrice;
    private String name;
    private int optionSetSize;
    private OptionSet optset[];

    public Automotive() {
    	//constructor method
        this.name = "";
        this.basePrice = 0;
        this.optionSetSize = 0;
    }

    public Automotive(String name, float basePrice, int optionSetSize) {
    	//constructor method
        this.name = name;
        this.basePrice = basePrice;
        this.optionSetSize = optionSetSize;
        for (int i = 0; i < optionSetSize; i++) {
            this.optset[i] = new OptionSet();
        }
    }

    public void deleteOption(String optionSetName, String optionName) {
    	//delete option from optionSet
        int index = findOptionSet(name);
        if (index < optionSetSize) {
            optset[index].deleteOption(optionName);
        } else
            System.out.println("no such option set to delete data.");
    }

    public void deleteOptionSet(String name) {
    	//delete OptionSet
        int index = findOptionSet(name);
        if (index < optionSetSize) {
            optset[index].setName("");
            optset[index].deleteAll();
        } else
            System.out.println("no such option set to delete data.");
    }

    public int findOptionSet(String name) {
        // find the first OptionSet with the given name, if exists, return
        // index.
        int i = 0;
        for (; i < optionSetSize; i++) {
            if (optset[i].getName() == name) {
                System.out.println("Successfully Find the option set:");
                System.out.println(optset[i].toString());
                break;
            }
        }
        if (i == optionSetSize) {
            System.out.println("No such option set");
        }
        return i;
    }

    public Option[] getAllOptions(int optionSetIndex) {
    	//getAllOptions from index
        if (optionSetIndex >= optionSetSize) {
            System.out
                    .println("no such optionset. Option set number is too large");
            return null;
        }
        return optset[optionSetIndex].getAllOptions();
    }

    public OptionSet[] getAllOptionSets() {
    	//return optionSet
        return optset;
    }

    public String getName() {
    	//return name of automotive
        return name;
    }

    public OptionSet getOptionSet(int i) {
    	//return OptionSet
        if (i >= optionSetSize) {
            System.out
                    .println("no such optionset. Option set number is too large");
            return null;
        }
        return optset[i];
    }

    public int getOptionSetsize() {
    	//get OptionSetsize
        return optionSetSize;
    }

    public float getPrice() {
    	//return base price
        return basePrice;
    }

    public void print() {
        System.out.println("Model Name: " + this.name);
        System.out.println("Base Price: " + this.basePrice);
        System.out.println("OptionSet Size: " + this.optionSetSize);
        for (int i = 0; i < this.optionSetSize; i++) {
            System.out.println();
            System.out.println("OptionSet #" + (i + 1));
            this.optset[i].print();
        }
    }

    public void setName(String name) {
    	//set automotive name 
        this.name = name;
    }

    public void setOption(int optSetIndex, int optIndex, String optionName,
            float price) {
    	//set option
        if (optSetIndex < optionSetSize) {
            this.optset[optSetIndex].setOption(optIndex, optionName, price);
        } else
            System.out.println("no such option set to set data.");
    }

    public void setOptionSet(int index, String optsetName, int optSize) {
    	//set OptionSet
        if (index < optionSetSize) {
            this.optset[index].setName(optsetName);
            this.optset[index].setOptionSize(optSize);
        } else
            System.out.println("no such option set to set data.");
    }

    public void setOptionSetsize(int optionSetSize) {
    	//set Option set size
        this.optionSetSize = optionSetSize;
        this.optset = new OptionSet[optionSetSize];
        for (int i = 0; i < optionSetSize; i++) {
            this.optset[i] = new OptionSet();
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
            optset[index].updateOption(oldName, newName, newPrice);
        } else {
            System.out.println("Such option set does not exist when update!");
        }
    }

    public void updateOptionSet(String oldName, String newName) {
        // update an option set by name and its related information;
        int index = findOptionSet(oldName);
        if (index < optionSetSize) {
            optset[index].setName(newName);
            System.out.println("option set update completed!");
        } else {
            System.out.println("Such option set does not exist when update!");
        }
    }
}

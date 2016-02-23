package adapter;

import java.util.LinkedHashMap;

import exception.AutoException;
import exception.AutoException.ErrNo;
import model.Automobile;
import util.FileIO;

public abstract class ProxyAutomobile {
	/*
	 * main class function as bridge from inner part to outer part;
	 * Using linkedHashMap as well;
	 */
	private static LinkedHashMap<String, Automobile> automobiles = new LinkedHashMap<>();
	private AutoException autoException = new AutoException();
	FileIO readFile = new FileIO();

	public void buildAuto(String fileName) throws Exception {
		try {
			Automobile a = readFile.buildAutoObject(fileName);
			automobiles.put(a.getModel(), a);
		} catch (AutoException e) {
			if (e.getErrorNumber() == AutoException.ErrNo.FILEWRONG) {
				fileName = e.fix(e.getErrorNumber());
				Automobile a = readFile.buildAutoObject(fileName);
				automobiles.put(a.getModel(), a);
			} else {
				e.fix(e.getErrorNumber());
			}
		}
	}

	public void fix(ErrNo errNo) {
		autoException.fix(errNo);
	}

	public void printAuto(String modelName) {
		if (automobiles.containsKey(modelName)) {
			Automobile a = automobiles.get(modelName);
			a.print();
		} else {
			System.out.println("no such model!");
		}
	}

	public void setOptionChoice(String modelName, String optionSetName,
			String optionName) {
		//call set Option choice method
		if (automobiles.containsKey(modelName)) {
			Automobile a = automobiles.get(modelName);
			a.setOptionChoice(optionSetName, optionName);
		} else {
			System.out.println("no such model to be updated");
		}
	}

	public void updateOptionPrice(String modelName, String optionSetName,
			String optionName, float newPrice) {
		//Update Option price method
		if (automobiles.containsKey(modelName)) {
			Automobile a = automobiles.get(modelName);
			a.updateOption(optionSetName, optionName, optionName, newPrice);
		} else {
			System.out.println("no such model!");
		}
	}

	public void updateOptionSetName(String modelName, String optionSetname,
			String newName) {
		if (automobiles.containsKey(modelName)) {
			Automobile a = automobiles.get(modelName);
			a.updateOptionSet(optionSetname, newName);
		} else {
			System.out.println("no such model to be updated");
		}
	}
}

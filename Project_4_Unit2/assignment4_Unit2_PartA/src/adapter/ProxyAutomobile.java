package adapter;

import exception.AutoException;
import exception.AutoException.ErrNo;
import model.Automobile;
import util.FileIO;

public abstract class ProxyAutomobile {
	private static Automobile a;
	private AutoException autoException = new AutoException();
	FileIO readFile = new FileIO();

	public void buildAuto(String fileName) throws Exception {
		try {
			a = readFile.buildAutoObject(fileName);
		} catch (AutoException e) {
			if (e.getErrorNumber() == AutoException.ErrNo.FILEWRONG) {
				fileName = e.fix(e.getErrorNumber());
				a = readFile.buildAutoObject(fileName);
			} else {
				e.fix(e.getErrorNumber());
			}
		}
	}

	public void fix(ErrNo errNo) {
		autoException.fix(errNo);
	}

	public void printAuto(String Modelname) {
		if (a.getName().equals(Modelname)) {
			a.print();
		} else {
			System.out.println("no such model!");
		}
	}

	public void updateOptionPrice(String modelName, String optionSetName,
			String optionName, float newPrice) {
		if (a.getName().equals(modelName)) {
			a.updateOption(optionSetName, optionName, optionName, newPrice);
		} else {
			System.out.println("no such model!");
		}
	}

	public void updateOptionSetName(String modelName, String optionSetname,
			String newName) {
		if (a.getName().equals(modelName)) {
			a.updateOptionSet(optionSetname, newName);
			;
		} else {
			System.out.println("no such model to be updated");
		}
	}
}

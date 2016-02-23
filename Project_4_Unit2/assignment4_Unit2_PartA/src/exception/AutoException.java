package exception;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class AutoException extends Exception {

	public enum ErrNo {
		AUTONAMENULL(
				2,
				"Exception: the name of automobile should not be null when update!"),
		FILEWRONG(1, "Exception: The name of input file is wrong!"),
		MISSINGOPTIONSETSIZE(5, "Exception: missing input optionset size"),
		MISSINGPRICEDATA(6, "Exception: missing price data of Option."),
		OPTIONNAMENULL(
				4,
				"Exception: the name of option should not be null when query!"),
		OPTIONSETNAMENULL(
				3,
				"Exception: the name of OptionSet should not be null when query!");

		private int index;
		private String message;

		private ErrNo(int index, String message) {
			this.index = index;
			this.message = message;
		}

		public int getIndex() {
			return index;
		}

		public String getMessage() {
			return message;
		}
	}

	private static final long serialVersionUID = 1L;

	private ErrNo errNo;

	public AutoException() {
	}

	public AutoException(ErrNo errNo) {
		this.errNo = errNo;
	}

	public String fix(ErrNo errNo) {
		try {
			this.logException(errNo.message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Fix1to100 fix = new Fix1to100();
		switch (errNo.getIndex()) {

		case 1: // file wrong
			return fix.fix1();
		}
		return null;
	}

	public ErrNo getErrorNumber() {
		return errNo;
	}

	public void logException(String s) throws Exception {
		// create a new file with specified file name
		FileWriter fw = new FileWriter("AutoException.log");
		// create the IO stream on that file
		BufferedWriter bw = new BufferedWriter(fw);
		// write a string into the IO stream
		bw.write(s);
		bw.append("\n");
		// don't forget to close the stream!
		System.out.println("Exception log file generated successfully!");
		bw.close();
	}
}

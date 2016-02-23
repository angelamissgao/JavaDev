package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import exception.AutoException;
import model.Automobile;

public class FileIO {
	/*
	 * File IO class: Read File as input stream
	 */
	public Automobile buildAutoObject(String filename) throws Exception {
		Automobile a = new Automobile();
		FileReader file;
		try {
			file = new FileReader(filename);
		} catch (FileNotFoundException e) {
			throw new AutoException(AutoException.ErrNo.FILEWRONG);
		}

		BufferedReader buff = new BufferedReader(file);
		try {
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine();
				if (line == null) {
					eof = true;
					break;
				}
				if (line.equals("Model Name:")) {
					String name = buff.readLine();
					if (name.isEmpty())
						throw new AutoException(
								AutoException.ErrNo.AUTONAMENULL);
					a.setModel(name);
				}
				if (line.equals("Make Name:")) {
					String name = buff.readLine();
					if (name.isEmpty())
						throw new AutoException(
								AutoException.ErrNo.AUTONAMENULL);
					a.setMake(name);
				}
				if (line.equals("Option set size:")) {
					int num = 0;
					try {
						num = Integer.parseInt(buff.readLine());
					} catch (NumberFormatException e) {
						throw new AutoException(
								AutoException.ErrNo.MISSINGOPTIONSETSIZE);
					}

					a.setOptionSetsize(num);
				}
				if (line.equals("Base price:")) {
					float price = 0;
					try {
						price = Float.parseFloat(buff.readLine());
					} catch (NullPointerException e) {
						throw new AutoException(
								AutoException.ErrNo.MISSINGPRICEDATA);
					}
					a.setPrice(price);
				}
				if (line.equals("Option sets:")) {
					for (int i = 0; i < a.getOptionSetsize(); i++) {
						line = buff.readLine();
						if (line.equals("Option set:")) {
							String optsetName = buff.readLine();
							if (optsetName.isEmpty())
								throw new AutoException(
										AutoException.ErrNo.OPTIONSETNAMENULL);

							int optSize = Integer.parseInt(buff.readLine());
							a.setOptionSet(i, optsetName, optSize);
							for (int j = 0; j < optSize; j++) {
								String optionName = buff.readLine();
								if (optionName.isEmpty())
									throw new AutoException(
											AutoException.ErrNo.OPTIONNAMENULL);
								float price = Float.parseFloat(buff.readLine());
								a.setOption(i, j, optionName, price);
							}
						}
					}
				}
			}
		} finally {
			buff.close();
		}
		// loading process completed
		System.out.println("Loading completed.");
		System.out.println();

		return a;
	}

	public Automobile deserializeAuto(String filename) {
		Automobile a = null;
		try {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(filename));
			a = (Automobile) in.readObject();
			in.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
			System.exit(1);
		}
		return a;
	}

	public void serializeAuto(Automobile a, String filename) {
		// Auto serialization
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(filename));
			out.writeObject(a);
			out.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
			System.exit(1);
		}
	}

}

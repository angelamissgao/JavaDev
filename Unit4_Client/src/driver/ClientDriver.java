package driver;

import client.CarModelOptionsIO;
import client.SelectCarOption;

public class ClientDriver {
	/**
	 * Author: Angela Gao (yongchag)
	 * 
	 */
	public static void main(String[] args) throws Exception {
		CarModelOptionsIO client = new CarModelOptionsIO();
		CarModelOptionsIO client2 = new CarModelOptionsIO();

		// two test case
		client.uploadCar("test1.properties");
		client2.uploadCar("test2.properties");

		SelectCarOption selection1 = new SelectCarOption();
		selection1.getAllModels();
		selection1.getModelOption();
		selection1.getOptions();
	}

}

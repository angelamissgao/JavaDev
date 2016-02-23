package driver;

import adapter.BuildAuto;

public class Driver {
	public static void main(String[] args) throws Exception {
		BuildAuto a1 = new BuildAuto();
		a1.buildAuto("FordZTW.txt");
		a1.printAuto("Focus Wagon ZTW");
		a1.updateOptionPrice("Focus Wagon ZTW", "Color",
				"Liquid Grey Clearcoat Metallic", 200);
		a1.updateOptionSetName("Focus Wagon ZTW", "Transmission", "New Transmission");
		a1.printAuto("Focus Wagon ZTW");

		a1.buildAuto("FordZT.txt"); // test for no file exception;

	}

}

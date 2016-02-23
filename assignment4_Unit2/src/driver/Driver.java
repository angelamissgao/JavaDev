package driver;

import adapter.BuildAuto;

public class Driver {
	public static void main(String[] args) throws Exception {
		BuildAuto a1 = new BuildAuto();
		a1.buildAuto("FordZTW.txt");
		a1.printAuto("Focus Wagon ZTW");

		// test for PartA
		a1.updateOptionPrice("Focus Wagon ZTW", "Color",
				"Liquid Grey Clearcoat Metallic", 200);
		a1.updateOptionSetName("Focus Wagon ZTW", "Transmission",
				"New Transmission");

		// test for PartB
		a1.setOptionChoice("Focus Wagon ZTW", "Color",
				"Fort Knox Gold Clearcoat Metallic");

		a1.printAuto("Focus Wagon ZTW");

		// Test for PartA exception
		a1.buildAuto("FordZT.txt"); // test for no file exception;

	}

}

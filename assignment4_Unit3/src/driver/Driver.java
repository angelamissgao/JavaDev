package driver;

import adapter.BuildAuto;
import scale.*;

public class Driver {
	/**
	 * Author: Angela Gao (yongchag)
	 * 
	 */
	public static void main(String[] args) throws Exception {
		//Same buildAuto model for two thread
		BuildAuto a1 = new BuildAuto();
		a1.buildAuto("FordZTW.txt");
		
		//Thread 1
		GetOptions g1 = new GetOptions(a1, "Focus Wagon ZTW", "Color");
		g1.start();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		
		//Thread 2
		EditOptions e1 = new EditOptions(a1, "Focus Wagon ZTW", "Color", "Liquid Grey Clearcoat Metallic");
		e1.start();
		
	}

}

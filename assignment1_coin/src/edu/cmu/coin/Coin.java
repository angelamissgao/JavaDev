package edu.cmu.coin;

public class Coin {
	private String sideUp; //sideUp variable has two options;

	public Coin() {
		toss(); // no-arg constructor;
	}

	public String getSideUp() { // return the string sideUp;
		return sideUp;
	}

	public void toss() { // randomly toss Coin method;
		double tossprob = Math.random();
		if (tossprob < 0.5) {
			sideUp = "heads";
		} else {
			sideUp = "tails";
		}
	}
}

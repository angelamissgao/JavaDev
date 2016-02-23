package edu.cmu.simulation;

import edu.cmu.coin.Coin;

public class Simulation {
	public static void main(String[] args) {
		Coin c = new Coin();
		System.out.println( //print the initialized facing up side; 
				"The side that is initially facing up is : " + c.getSideUp());

		int hfu = 0; //Count heads face up;
		int tfu = 0; //Count tails face up;
		String res;

		for (int i = 0; i < 20; i++) {// Toss coin simulator;
			c.toss();
			res = c.getSideUp();
			if (res == "heads") {
				hfu++;
			} else {
				tfu++;
			}
			System.out.println(
					"The " + (i + 1) + " toss: side facing up is : " + res);
		}

		System.out.println(String.format(
				"The side head is facing up is : %d. The side tails is facing up is: %d",
				hfu, tfu));

	}
}
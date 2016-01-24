package edu.cmu.parking;

public class ParkingMeter {
	private int purchasedTime;

	public ParkingMeter(int time) {
		this.purchasedTime = time;
	}

	public int getPurchasedTime() {//return purchased parking time 
		return purchasedTime;
	}
}
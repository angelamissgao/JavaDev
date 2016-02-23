package edu.cmu.parking;

public class ParkingTicket {
	private int badgeNumber; 
	private double fine;
	private String illegalCarColor;
	private String illegalCarMake;
	private String illegalCarModel;
	private int illegalCLNumber;
	private int parkingMinutes;
	private String policeName;
	private int purchasedTime;

	public ParkingTicket(String carMake, String carModel, String carColor,
			int carLicenseNumber, int parkingMinutes, int purchasedTime,
			String policeName, int badgeNumber) {
		// constructor
		this.illegalCarMake = carMake;
		this.illegalCarModel = carModel;
		this.illegalCarColor = carColor;
		this.illegalCLNumber = carLicenseNumber;
		this.parkingMinutes = parkingMinutes;
		this.purchasedTime = purchasedTime;
		this.policeName = policeName;
		this.badgeNumber = badgeNumber;

		this.fine = calculateFine();
	}

	public double calculateFine() { // calculate ticket fine
		if ((parkingMinutes - purchasedTime) <= 60) {
			fine = 25.00;
		} else {
			fine = 25 + (((parkingMinutes - purchasedTime) - 60 - 1) / 60 + 1)
					* 10;
		}
		return fine;
	}

	public void display() {//Print ticket information;
		System.out.printf("Fine: $%.2f", fine); // round to two decimal places
		System.out.println("");
		System.out.println("Illegal Car Make: " + illegalCarMake);
		System.out.println("Illegal Car Model: " + illegalCarModel);
		System.out.println("Illegal Car Color: " + illegalCarColor);
		System.out.println("License Number: " + illegalCLNumber);
		System.out.println("Police Officer Name: " + policeName);
		System.out.println("Police Badge Number: " + badgeNumber);
	}

	public int getBadgeNumber() { // get related ticket info;
		return badgeNumber;
	}

	public String getIllegalCarColor() {
		return illegalCarColor;
	}

	public String getIllegalCarMake() {
		return illegalCarMake;
	}

	public String getIllegalCarModel() {
		return illegalCarModel;
	}

	public int getIllegalCLNumber() {
		return illegalCLNumber;
	}

	public String getPoliceName() {
		return policeName;
	}
}

package edu.cmu.parking;

public class ParkedCar {
	private String color;
	private int licenseNumber;
	private String make;
	private String model;
	private int parkingMinutes;

	public ParkedCar(String carMake, String carModel, String carColor,
			int carLicenseNumber, int carParkingMinutes) {//ParkedCar Constructors;
		this.make = carMake;
		this.model = carModel;
		this.color = carColor;
		this.licenseNumber = carLicenseNumber;
		this.parkingMinutes = carParkingMinutes;
	}

	public String getColor() {//Get method to know the car's info;
		return color;
	}

	public int getLicenseNumber() {
		return licenseNumber;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getParkingMinutes() {
		return parkingMinutes;
	}

	public void setColor(String carColor) {
		color = carColor;
	}

	public void setLicenseNumber(int carLicenseNumber) {
		licenseNumber = carLicenseNumber;
	}

	public void setMake(String carMake) {
		make = carMake;
	}

	public void setModel(String carModel) {
		model = carModel;
	}

	public void setParkingMinutes(int carParkingMinutes) {
		parkingMinutes = carParkingMinutes;
	}
}

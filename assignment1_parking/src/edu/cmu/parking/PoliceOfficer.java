package edu.cmu.parking;

public class PoliceOfficer {
	private int badgeNumber;
	private String policeName;

	public PoliceOfficer(String name, int badgeNumber) {
		// constructor
		this.policeName = name;
		this.badgeNumber = badgeNumber;
	}

	//examine if the parked car is parking out of time
	public boolean examine(ParkedCar car, ParkingMeter meter) {
		if ((meter.getPurchasedTime() - car.getParkingMinutes()) < 0)
			return true;
		else
			return false;
	}

	// return a parking ticket according to examine result
	public ParkingTicket issue(ParkedCar car, ParkingMeter meter) {
		if (examine(car, meter)) {
			ParkingTicket ticket = new ParkingTicket(car.getMake(),
					car.getModel(), car.getColor(), car.getLicenseNumber(),
					car.getParkingMinutes(), meter.getPurchasedTime(),
					policeName, badgeNumber);
			return ticket;
		} else
			return null;

	}
}

package edu.cmu.simulation;

import edu.cmu.parking.ParkedCar;
import edu.cmu.parking.ParkingMeter;
import edu.cmu.parking.ParkingTicket;
import edu.cmu.parking.PoliceOfficer;

public class Simulation {
	public static void main(String[] args) {
		Simulation s = new Simulation();
		ParkedCar car = new ParkedCar("Chevron", "Cemaro", "Red", 1234, 30);
		ParkingMeter meter = new ParkingMeter(60);
		PoliceOfficer officer = new PoliceOfficer("AngelaGao", 1211);
		
		car.setParkingMinutes(30); //test car within purchased parking time;
		s.checkTicket(1, car, meter, officer);

		car.setParkingMinutes(90); //test car out of purchased parking time;
		s.checkTicket(2, car, meter, officer);

		car.setParkingMinutes(60); //test car just in purchased parking time;
		s.checkTicket(3, car, meter, officer);

		car.setParkingMinutes(100); //ticket under 1 hour;
		s.checkTicket(4, car, meter, officer);

		car.setParkingMinutes(150); // ticket more than 1 hour;
		s.checkTicket(5, car, meter, officer);
	}

	private void checkTicket(int testCase, ParkedCar car, ParkingMeter meter,
			PoliceOfficer officer) {
		System.out.println("Test Case " + testCase);
		if (officer.examine(car, meter)) {
			ParkingTicket ticket;
			ticket = officer.issue(car, meter);
			ticket.display();
		} else {
			System.out.println("no illegal parking states issued.");
		}
		System.out.println();
	}

}

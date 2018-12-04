package myUber.test;

import myUber.MyUber;
import myUberOthers.GPS;
import myUberPeople.Customer;
import myUberRide.Ride;

public class MainTest {
	
	public static void main(String[] args) {
		
		// creation of the myUber univers
		
		MyUber univers = new MyUber();
		System.out.println(univers);
		
		univers.initiation();
		
		//ATTENTION SENSIBLE A LA CASSE
		
		Customer clientTest1 = new Customer();
		univers.addCustomer(clientTest1);
		clientTest1.requestRide(2, new GPS(), univers);
		
		Customer clientTest2 = new Customer();
		univers.addCustomer(clientTest2);
		clientTest2.requestRide(2, new GPS(), univers);
		
		System.out.println(univers.requestedRides.size());
		System.out.println(univers.driverList);
		
		int counter = 1;
		for (Ride ride: univers.requestedRides) {
			ride.setRideID(counter);
			ride.start();
			counter++;
			System.out.println(univers.driverList);
		}
		
		System.out.println(univers.bookOfRides);
	}

}

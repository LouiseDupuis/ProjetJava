package myUber.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUber.MyUber;
import myUberOthers.GPS;
import myUberPeople.Customer;
import myUberRide.Ride;
import myUberStatistics.Statistics;

class StatisticsTest {

	@Test
	void test() {
		MyUber univers = new MyUber(10,10);
		System.out.println(univers);
		
		univers.initiation();

		
		Customer clientTest1 = new Customer();
		univers.addCustomer(clientTest1);
		clientTest1.requestRide(2, new GPS(), univers);
		
		int counter = 1;
		for (Ride ride: univers.requestedRides) {
			ride.setRideID(counter);
			ride.start();
			counter++;
			System.out.println(univers.driverList);
		}
	
		//univers.requestedRides.get(0).join(); 
		//Statistics stat = new Statistics(univers); 
		//System.out.println(stat.NbTotalRides());
		//System.out.println(stat.TotalCashed());
		
	}

}

package myUber.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberOthers.GPS;
import myUberRide.Ride;

// This class tests the constructor of the class Ride 

class RideTest {

	@Test
	final void testRide() {
		Ride ride = new Ride(new GPS(4.49,2.22), new GPS(4.48,2.44), 4);
		Ride ride2 = new Ride(new GPS(4.49,2.22), new GPS(4.48,2.44), 0);

	}
	
	@Test
	public void TestToString() {
		Ride ride = new Ride(new GPS(4.49,2.22), new GPS(4.48,2.44), 4);
		System.out.println(ride);
	}

}

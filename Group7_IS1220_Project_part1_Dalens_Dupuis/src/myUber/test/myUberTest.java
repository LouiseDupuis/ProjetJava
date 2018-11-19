package myUber.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberOthers.myUber;

class myUberTest {

	@Test
	final void testMyUberIntInt() {
		myUber univers = new myUber(4,4);
		assertTrue(univers.nbcars == univers.nbdrivers );
		assertTrue(univers.nbcars == univers.nbcustomers );
		assertTrue(univers.nbdrivers == 4 );
	}

	@Test
	final void testMyUber() {
		myUber univers = new myUber();
		
	}

	@Test
	final void testInitiation() {
		myUber univers = new myUber();
		
		univers.initiation();
	}
	
	@Test
	final void testRequestRide() {
		myUber univers = new myUber();
		System.out.println(univers);
		univers.requestRide();
		System.out.println(univers.requestedRides);
		
	}

}

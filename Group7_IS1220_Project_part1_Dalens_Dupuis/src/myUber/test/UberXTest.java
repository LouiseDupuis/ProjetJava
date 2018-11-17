package myUber.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberOthers.GPS;
import myUberRide.Ride;
import myUberRide.UberX;

class UberXTest {

	@Test
	final void testUberX() {
		Ride uberx1 = new UberX( new GPS(2.33, 48.85), new GPS(2.27,48.90), 4 );
	}

}

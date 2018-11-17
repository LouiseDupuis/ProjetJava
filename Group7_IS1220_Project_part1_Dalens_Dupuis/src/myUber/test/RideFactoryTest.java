package myUber.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberOthers.GPS;
import myUberRide.Ride;
import myUberRide.RideFactory;

class RideFactoryTest {

	@Test
	final void testCreateRide() {
		RideFactory factory = new RideFactory();
		
		// normal case
		Ride uberx1 =  factory.createRide( "uberx" , new GPS(2.33, 48.85), new GPS(2.27,48.90), 4 );
		Ride uberblack1 =  factory.createRide( "uberblack" , new GPS(2.33, 48.85), new GPS(2.27,48.90), 4 );
		Ride uberpool1 =  factory.createRide( "uberpool" , new GPS(2.33, 48.85), new GPS(2.27,48.90), 4 );
		Ride ubervan1 =  factory.createRide( "ubervan" , new GPS(2.33, 48.85), new GPS(2.27,48.90), 4 );
		
		// too many passengers
		Ride uberx2 =  factory.createRide( "uberx" , new GPS(2.33, 48.85), new GPS(2.27,48.90), 7 );
		
		//ridetype invalid 
		Ride uberpool2 =  factory.createRide( "blablabla" , new GPS(2.33, 48.85), new GPS(2.27,48.90), 4 );
		
		// 
		
		System.out.println(uberx1);
		System.out.println(uberx2);
		
		
	}

}

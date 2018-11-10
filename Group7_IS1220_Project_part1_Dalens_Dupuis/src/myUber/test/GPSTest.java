package myUber.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberOthers.GPS;

class GPSTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		//Max Length
		GPS gps1 = new GPS(4.49,2.22); 
		GPS gps2 = new GPS(4.48,2.44);
		System.out.println(gps1.length(gps2));
		
		//Random Length
		GPS gps3 = new GPS(); 
		GPS gps4 = new GPS();
		System.out.println(gps3.length(gps4));
	}

}

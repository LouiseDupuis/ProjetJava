package myUber.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUber.MyUber;
import myUberOthers.GPS;
import myUberPeople.Customer;

class CustomerTest {

	
	@Test
	final void testRequestRide() {
		Customer customer = new Customer();
		MyUber univers = new MyUber();
		univers.initiation(5,5,5);
		customer.requestRide(2,new GPS(), univers);
		System.out.println(univers.requestedRides);
		assertEquals(1, univers.requestedRides.size());
		
	}

}

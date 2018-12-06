package myUber.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import myUber.MyUber;
import myUberOthers.GPS;
import myUberPeople.Customer;

class CustomerTest {

	
	@Test
	final void testRequestRide() {
		Customer customer = new Customer();
		MyUber univers = new MyUber(15,15);
		univers.initiation(5,5,5);
		Map<String,Double> priceList = customer.requestRide(2,new GPS(), univers,3);
		System.out.println(priceList);
		
	}

}

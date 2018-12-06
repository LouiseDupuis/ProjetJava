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
		MyUber univers = new MyUber(30,30);
		univers.initiation(10,10,10);
		Map<String,Double> priceList = customer.requestRide(2,new GPS(2, 48 ), univers,-1);
		System.out.println(priceList);
		
	}

}

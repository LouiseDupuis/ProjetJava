package myUber.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberOthers.myUber;

class myUberTest {

	@Test
	final void testMyUberIntInt() {
		myUber univers = new myUber(4,4);
		System.out.println(univers);
	}

	@Test
	final void testMyUber() {
		myUber univers = new myUber();
		System.out.println(univers);
		
	}

	@Test
	final void testInitiation() {
		myUber univers = new myUber();
		System.out.println(univers);
		System.out.println(univers.customerList);
		
		univers.initiation();
		System.out.println(univers.carList);
	}

}

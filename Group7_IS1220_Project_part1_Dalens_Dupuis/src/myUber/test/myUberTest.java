package myUber.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUber.MyUber;

class myUberTest {

	@Test
	final void testMyUberIntInt() {
		MyUber univers = new MyUber(4,4);
		assertTrue(univers.nbcars == univers.nbdrivers );
		assertTrue(univers.nbcars == univers.nbcustomers );
		assertTrue(univers.nbdrivers == 4 );
	}

	@Test
	final void testMyUber() {
		MyUber univers = new MyUber();
		System.out.println(univers);
	}

	@Test
	final void testInitiation() {
		MyUber univers = new MyUber();
		
		univers.initiation();
	}
	
	

}

package myUber.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberOthers.PassengerNumber;

class PassengerNumberTest {

	@Test
	final void testPassengerNumber() {
		PassengerNumber test = new PassengerNumber();
		System.out.println(test.passengerNumber);
	}

}

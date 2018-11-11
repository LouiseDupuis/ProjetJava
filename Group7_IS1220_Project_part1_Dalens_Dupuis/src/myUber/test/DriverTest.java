package myUber.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberPeople.Driver;
import myUberPeople.DriverState;

class DriverTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		Driver George = new Driver(); 
		System.out.println(George);
		//George.Parameters();
		//System.out.println(George);
		Driver Paul = new Driver(); 
		System.out.println(Paul);
		Paul.setState(DriverState.ONDUTY); //changement pour ONDUTY
		System.out.println(Paul);
		System.out.println(George);
	}

}

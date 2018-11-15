package myUber.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberCar.Car;
import myUberCar.CarFactory;

class CarFactoryTest {

	@Test
	void test() {
		CarFactory Fact = new CarFactory();
		Car B1 = Fact.createCar("Berline"); 
		System.out.println(B1);
	}

}

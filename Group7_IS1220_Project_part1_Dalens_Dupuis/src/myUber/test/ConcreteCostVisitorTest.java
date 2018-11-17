package myUber.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myUberOthers.GPS;
import myUberOthers.TrafficStatus;
import myUberRide.ConcreteRideCostVisitor;
import myUberRide.Ride;
import myUberRide.UberBlack;
import myUberRide.UberPool;
import myUberRide.UberVan;
import myUberRide.UberX;

class ConcreteCostVisitorTest {

	@Test
	final void testConcreteRideCostVisitor() {
		ConcreteRideCostVisitor visitor = new ConcreteRideCostVisitor(TrafficStatus.LOW);
	}

	@Test
	final void testVisitUberX() {
	ConcreteRideCostVisitor visitor1 = new ConcreteRideCostVisitor(TrafficStatus.LOW);
	ConcreteRideCostVisitor visitor2 = new ConcreteRideCostVisitor(TrafficStatus.HEAVY);
	
	UberX uberx1 = new UberX(new GPS(0,0), new GPS(0,0), 3);
	UberX uberx2 = new UberX(new GPS(4.49,2.22), new GPS(4.48,2.44), 1);
	
	// if the length of the ride is null, the cost is 0
	
	double cost11 = visitor1.visit(uberx1);
	double cost21 = visitor2.visit(uberx1);
	
	assertEquals(cost11,cost21);
	assertEquals(cost11,0);
	
	// the cost of a ride is 1.5 more expensive if the traffic is heavy
	
	
	double cost12 = visitor1.visit(uberx2);
	double cost22 = visitor2.visit(uberx2);
	
	assertEquals(cost22, cost12*1.5, 0.00001); // tests whether the numbers are equal within a delta of 0.00001 
	
	}

	@Test
	final void testVisitUberVan() {
		ConcreteRideCostVisitor visitor1 = new ConcreteRideCostVisitor(TrafficStatus.LOW);
		ConcreteRideCostVisitor visitor2 = new ConcreteRideCostVisitor(TrafficStatus.HEAVY);
		
		UberVan uber1 = new UberVan(new GPS(0,0), new GPS(0,0), 3);
		UberVan uber2 = new UberVan(new GPS(4.49,2.22), new GPS(4.48,2.44), 1);
		
		// if the length of the ride is null, the cost is 0
		
		double cost11 = visitor1.visit(uber1);
		double cost21 = visitor2.visit(uber1);
		
		assertEquals(cost11,cost21);
		assertEquals(cost11,0);
		
		// the cost of a ride is 1.8 more expensive if the traffic is heavy
		
		
		double cost12 = visitor1.visit(uber2);
		double cost22 = visitor2.visit(uber2);
		
		assertEquals(cost22, cost12*1.8, 0.00001);
	}

	@Test
	final void testVisitUberBlack() {
		ConcreteRideCostVisitor visitor1 = new ConcreteRideCostVisitor(TrafficStatus.LOW);
		ConcreteRideCostVisitor visitor2 = new ConcreteRideCostVisitor(TrafficStatus.HEAVY);
		
		UberBlack uber1 = new UberBlack(new GPS(0,0), new GPS(0,0), 3);
		UberBlack uber2 = new UberBlack(new GPS(4.49,2.22), new GPS(4.48,2.44), 1);
		
		// if the length of the ride is null, the cost is 0
		
		double cost11 = visitor1.visit(uber1);
		double cost21 = visitor2.visit(uber1);
		
		assertEquals(cost11,cost21);
		assertEquals(cost11,0);
		
		// the cost of a ride is 1.6 more expensive if the traffic is heavy
		
		
		double cost12 = visitor1.visit(uber2);
		double cost22 = visitor2.visit(uber2);
		
		assertEquals(cost22, cost12*1.6, 0.0001);
	}

	@Test
	final void testVisitUberPool() {
		ConcreteRideCostVisitor visitor1 = new ConcreteRideCostVisitor(TrafficStatus.LOW);
		ConcreteRideCostVisitor visitor2 = new ConcreteRideCostVisitor(TrafficStatus.HEAVY);
		
		UberPool uber1 = new UberPool(new GPS(0,0), new GPS(0,0), 3);
		UberPool uber2 = new UberPool(new GPS(4.49,2.22), new GPS(4.48,2.44), 1);
		
		// if the length of the ride is null, the cost is 0
		
		double cost11 = visitor1.visit(uber1);
		double cost21 = visitor2.visit(uber1);
		
		assertEquals(cost11,cost21);
		assertEquals(cost11,0);
		
		// the cost of a ride is 1.2 more expensive if the traffic is heavy
		
		
		double cost12 = visitor1.visit(uber2);
		double cost22 = visitor2.visit(uber2);
		
		assertEquals(cost22, cost12*1.2, 0.00001);
	}

}

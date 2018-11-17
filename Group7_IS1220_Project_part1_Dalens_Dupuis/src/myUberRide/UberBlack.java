package myUberRide;

import myUberOthers.GPS;

public class UberBlack extends Ride implements VisitableRide {

	public UberBlack(GPS start, GPS end, Integer nbPassengers) {
		super(start, end, nbPassengers);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void accept(RideCostVisitor visitor) {
		visitor.visit(this);
	}
	

}

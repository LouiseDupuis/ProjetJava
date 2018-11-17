package myUberRide;

import myUberOthers.GPS;

public class UberVan extends Ride implements VisitableRide{

	public UberVan(GPS start, GPS end, Integer nbPassengers) {
		super(start, end, nbPassengers);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(RideCostVisitor visitor) {
		visitor.visit(this);
		
	}


}

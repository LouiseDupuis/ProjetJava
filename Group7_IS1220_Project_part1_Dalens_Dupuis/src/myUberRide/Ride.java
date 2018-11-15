package myUberRide;

import myUberOthers.GPS;

public class Ride {
	
	protected GPS start ;
	protected GPS end ;
	
	private Integer nbPassengers ; 
	
	private RideStatus state;

	public Ride(GPS start, GPS end, Integer nbPassengers ) {
		super();
		this.start = start;
		this.end = end;
		this.nbPassengers = nbPassengers;
		this.state = RideStatus.UNCONFIRMED ;
	
	
	} 
	
	
	
	
	

}

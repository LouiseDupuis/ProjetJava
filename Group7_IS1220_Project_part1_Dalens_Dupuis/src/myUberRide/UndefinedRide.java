package myUberRide;

import java.util.Map;

import myUberOthers.GPS;

public class UndefinedRide extends Ride {
	
	public Map<String, Double> priceList;
	

	public UndefinedRide(GPS start, GPS end, Integer nbPassengers, Map<String, Double> priceList) {
		super(start, end, nbPassengers);
		this.priceList = priceList;
		// TODO Auto-generated constructor stub
	}
	
	

}

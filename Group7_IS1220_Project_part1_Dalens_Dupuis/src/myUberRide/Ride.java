package myUberRide;

import myUber.MyUber;
import myUberOthers.GPS;
import myUberPeople.Customer;
import myUberPeople.Driver;

import java.util.*;

public class Ride extends Thread {
	
	protected GPS start ;
	protected GPS end ;
	
	private Integer nbPassengers ; 
	
	private RideStatus state;
	
	public Customer customer; 

	public Ride(GPS start, GPS end, Integer nbPassengers ) {
		super();
		this.start = start;
		this.end = end;
		this.nbPassengers = nbPassengers;
		this.state = RideStatus.UNCONFIRMED ;
	
	
	}
	
	public void run(MyUber myUber) {
		// My Uber classes the driver according to their locations and produces a list of the available drivers ordered by their location
		
		ArrayList<Driver> listeDriver = myUber.orderedDriverList();
		
		
		
	}

	@Override
	public String toString() {
		return "Ride [start=" + start + ", end=" + end + ", nbPassengers=" + nbPassengers + ", state=" + state + "]";
		
	
	
	} 
	
	
	
	
	
	
	

}

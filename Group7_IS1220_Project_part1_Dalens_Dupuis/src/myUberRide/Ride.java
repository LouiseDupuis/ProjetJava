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
		
		ArrayList<Driver> listeDriver = myUber.orderedDriverList(start);
		
		Driver currentDriver = null; 
		
		while (!(this.state == RideStatus.CONFIRMED)) {
		for (Driver driver: listeDriver) {
			if ( driver.acceptRide(this)) {
				this.state = RideStatus.CONFIRMED;
				currentDriver = driver; 
				// here the program should inform the customer that his ride has been confirmed
				System.out.println("Yur ride is taken in charge by driver "+ currentDriver);
				System.out.println("Please wait while he makes his way towards you. ");
				 break;
			}
			
		}
		// here the program should inform the customer that myUber is taking a little bit of time to find a driver
		}
		
		// make the thread wait 5 seconds
		try
		{
		    Thread.sleep(5000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		
		// allow the customer to cancel the ride ?
		
		// the ride now starts
		this.state = RideStatus.ONGOING;
		   // the programm should send a message to the customer saying that the ride has started
		System.out.println("The ride has started " );
		
		// make the thread wait 1 minute or the duration computed from the distance 
		
		// make the thread wait 5 seconds
				try
				{
				    Thread.sleep(5000);
				}
				catch(InterruptedException ex)
				{
				    Thread.currentThread().interrupt();
				}
		
		// the ride has ended
		currentDriver.setGps(end);
		customer.setGPS(end);
		this.state = RideStatus.COMPLETED; 
		myUber.bookOfRides.add(this);
		System.out.println("The ride is over, thank you for choosing myUber ! ");
		
		
		
		
		
	}

	@Override
	public String toString() {
		return "Ride [start=" + start + ", end=" + end + ", nbPassengers=" + nbPassengers + ", state=" + state + "]";
		
	
	
	} 
	
	
	
	
	
	
	

}

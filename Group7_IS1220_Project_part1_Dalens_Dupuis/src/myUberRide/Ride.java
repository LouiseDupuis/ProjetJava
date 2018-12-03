package myUberRide;

import myUber.MyUber;
import myUberOthers.GPS;
import myUberPeople.Customer;
import myUberPeople.Driver;
import myUberPeople.DriverState;

import java.util.*;

public class Ride extends Thread {
	
	public MyUber myUber;
	
	protected GPS start ;
	protected GPS end ;
	
	public Integer nbPassengers ; 
	
	public RideStatus state;
	
	public Customer customer; 
	public Driver currentDriver = null; 

	public Ride(GPS start, GPS end, Integer nbPassengers ) {
		super();
		this.start = start;
		this.end = end;
		this.nbPassengers = nbPassengers;
		this.state = RideStatus.UNCONFIRMED ;
	
	
	}
	
	public void run() {
		// My Uber classes the driver according to their locations and produces a list of the available drivers ordered by their location
		
		ArrayList<Driver> listeDriver = myUber.orderedDriverList(start);
		
		int indice; 
		
		
		while (!(this.state == RideStatus.CONFIRMED)) {
		for (Driver driver: listeDriver) {
			if ( driver.acceptRide(this)) {
				this.state = RideStatus.CONFIRMED;
				driver.setState(DriverState.ONARIDE);
				indice = listeDriver.indexOf(driver)
				// here the program should inform the customer that his ride has been confirmed
				System.out.println("Your ride is taken in charge by driver "+ driver);
				System.out.println("Please wait while they make their way towards you. ");
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
		listeDriver.get(indice).setGps(end);
		listeDriver.get(indice).state = DriverState.OFFDUTY ;
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

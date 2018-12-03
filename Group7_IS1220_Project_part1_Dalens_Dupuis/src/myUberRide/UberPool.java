package myUberRide;

import java.util.ArrayList;

import myUberOthers.GPS;
import myUberPeople.Driver;
import myUberPeople.DriverState;

public class UberPool extends Ride implements VisitableRide {

	public UberPool(GPS start, GPS end, Integer nbPassengers) {
		super(start, end, nbPassengers);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void accept(RideCostVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public void run() {
		System.out.println("Nous recherchons un chauffeur pour vous !");
		
         ArrayList<Driver> listeDriver = myUber.orderedDriverList(start);
		
		
		
		
		while (!(this.state == RideStatus.CONFIRMED)) {
		for (Driver driver: listeDriver) {
			if ( driver.acceptRide(this)) {
				this.state = RideStatus.CONFIRMED;
				driver.setState(DriverState.ONPOOL);
				driver.car.setFreeSeats( driver.car.getFreeSeats() - this.nbPassengers);
				// here the program should inform the customer that his ride has been confirmed
				System.out.println("Your ride is taken in charge by driver "+ currentDriver);
				System.out.println("Please wait while he makes his way towards you and looks for other passengers");
				 break;
			}
			
		}
		// here the program should inform the customer that myUber is taking a little bit of time to find a driver
		}
		
		// make the thread wait 30 seconds
		try
		{
		    Thread.sleep(30000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		
		// allow the customer to cancel the ride ?
		
		// the ride now starts
		
		this.state = RideStatus.ONGOING;
		   // the program should send a message to the customer saying that the ride has started
		System.out.println("The ride has started ");
		
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


}

package myUberOthers;
import java.util.*;

import myUberCar.Car;
import myUberCar.CarFactory;
import myUberPeople.*;
import myUberRide.ConcreteRideCostVisitor;
import myUberRide.Ride;
import myUberRide.RideFactory;
import myUberRide.UberBlack;
import myUberRide.UberPool;
import myUberRide.UberVan;
import myUberRide.UberX;



public class myUber {
	public int nbcustomers;
	public int nbcars;
	public int nbdrivers;
	
	public ArrayList<Customer> customerList ;
	public ArrayList<Driver> driverList ;
	public ArrayList<Car> carList;
	
	public ArrayList<Ride> requestedRides = new ArrayList<Ride>();
	public ArrayList<Ride> bookOfRides = new ArrayList<Ride>();

	public myUber( int nbcustomers, int nbdrivers) {
		this.nbcustomers = nbcustomers;
		this.nbcars = nbdrivers;
		this.nbdrivers = nbdrivers;
		this.customerList = new ArrayList<Customer>();
		this. driverList = new ArrayList<Driver>();
		this.carList = new ArrayList<Car>();
	}
	
	public myUber() {
		int nbcars = (int) (Math.random()*50);
		int nbdrivers = nbcars; //in our simplified model, each driver owns a car 
		int nbcustomers = (int)(Math.random()*75);
		this.nbcustomers = nbcustomers;
		this.nbcars = nbcars;
		this.nbdrivers = nbdrivers;
		
		this.customerList = new ArrayList<Customer>();
		this. driverList = new ArrayList<Driver>();
		this.carList = new ArrayList<Car>();
	}
	
	public void initiation() {
		 for(int i = 1; i <= this.nbcustomers; i++)
		{
			  this.customerList.add(new Customer());
			};
		 for(int i = 1; i <= this.nbdrivers; i++) {
			 Driver driver = new Driver();
			 this.driverList.add(driver);
			 CarFactory cf = new CarFactory();
			 Car car = cf.createRandomCar();
			 car.setDriver(driver);
			 this.carList.add(car);
		 }
	}
	
	
	// this method create a ride with the information of the client and adds it to the list requestedRides
	
	public void requestRide() {
		
		// first, the system selects a random customer which will request a ride
		
		Random rand = new Random();
	    Customer customer = this.customerList.get(rand.nextInt(this.customerList.size()));
	    
	    // then the system asks the client to select an end-point and a number of passengers
	    
	    PassengerNumber PN = new PassengerNumber();
	    Integer nbPassenger = PN.passengerNumber;
	    GPS end = new GPSRide();
	    
	    
	    
	    // it selects a (random) traffic status 
	    
	    TrafficStatus traffic = TrafficStatus.MEDIUM;
	    		
	    int r = (int) (Math.random()*3);
		if (r == 0 ) {
			traffic = TrafficStatus.LOW;
		}else if ( r == 1) {
			traffic = TrafficStatus.MEDIUM;
		}else {
			traffic = TrafficStatus.HEAVY;
		}
	    
	    // it shows to the client the prices of the different rides available
	    
	    ConcreteRideCostVisitor visitor = new ConcreteRideCostVisitor(traffic);
	    Map<String,Double> priceList = visitor.priceList(customer, end, nbPassenger);
	    	
	    	
	    System.out.println("This is the list of rides that we propose :");
	    System.out.println(priceList);
	    	
	    // the client chooses his/her preferred option
	    	
	    RideFactory factory = new RideFactory();
	    	
	    Scanner scan = new Scanner(System.in);
		String input;
		System.out.println("Please type the name of the ride you choose ");
		
	    input = scan.next();
		Ride ride = factory.createRide(input, customer.getGps(), end, nbPassenger);
			  
	    scan.close();
		
	    this.requestedRides.add(ride);
	    	
	    	
	    }
	    


	@Override
	public String toString() {
		return "This myUber is composed of " + nbcustomers + " customers ," + nbcars + " cars and " + nbdrivers + " drivers.";
	}
	
	
}
	
	
	


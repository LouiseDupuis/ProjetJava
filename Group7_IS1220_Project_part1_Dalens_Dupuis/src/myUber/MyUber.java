package myUber;
import java.util.*;

import myUberCar.Car;
import myUberCar.CarFactory;
import myUberOthers.GPS;
import myUberOthers.GPSRide;
import myUberOthers.PassengerNumber;
import myUberOthers.TrafficStatus;
import myUberPeople.*;
import myUberRide.ConcreteRideCostVisitor;
import myUberRide.Ride;
import myUberRide.RideFactory;
import myUberRide.UberBlack;
import myUberRide.UberPool;
import myUberRide.UberVan;
import myUberRide.UberX;

   /**
    * 
    * 
    * @author Louise Dupuis & Ariane Dalens
    *
    */

public class MyUber {
	public int nbcustomers;
	public int nbcars;
	public int nbdrivers;
	
	public ArrayList<Customer> customerList ;
	public ArrayList<Driver> driverList ;
	public ArrayList<Car> carList;
	
	public ArrayList<Ride> requestedRides = new ArrayList<Ride>();
	public ArrayList<Ride> bookOfRides = new ArrayList<Ride>();

	public MyUber( int nbcustomers, int nbdrivers) {
		this.nbcustomers = nbcustomers;
		this.nbcars = nbdrivers; // we decided to affect exactly one car per driver
		this.nbdrivers = nbdrivers;
		this.customerList = new ArrayList<Customer>();
		this. driverList = new ArrayList<Driver>();
		this.carList = new ArrayList<Car>();
	}
	
	public MyUber() {
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
			 
			 CarFactory cf = new CarFactory();
			 Car car = cf.createRandomCar();
			 car.setDriver(driver);
			 driver.setCar(car);
			 driver.setGps(car.getGPS());
			 this.carList.add(car);
			 this.driverList.add(driver);
		 }
	}
	
	public void addCustomer (Customer customer) {
		this.customerList.add(customer);
	}
	
	public synchronized ArrayList<Driver> orderedDriverList(GPS position){
		ArrayList<Driver> orderedList = new ArrayList<Driver>();
		
		return this.driverList;
	}
	    


	@Override
	public String toString() {
		return "This myUber is composed of " + nbcustomers + " customers ," + nbcars + " cars and " + nbdrivers + " drivers.";
	}
	
	
}
	
	
	


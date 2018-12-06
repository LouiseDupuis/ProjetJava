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
	
	public ArrayList<Ride> waitingPoolRides = new ArrayList<Ride>();

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
	
	public void initiation(int nbStandard, int nbBerline, int nbVan) {
		 for(int i = 1; i <= this.nbcustomers; i++)
		{
			  this.customerList.add(new Customer());
			};
			
			
		 for(int i = 1; i <= nbStandard; i++) {
			 Driver driver = new Driver();
			 
			 CarFactory cf = new CarFactory();
			 Car car = cf.createCar("Standard");
			 car.setDriver(driver);
			 driver.setCar(car);
			 driver.setGps(car.getGPS());
			 this.carList.add(car);
			 this.driverList.add(driver);
		 }
		 
		 for(int i = 1; i <= nbBerline; i++) {
			 Driver driver = new Driver();
			 
			 CarFactory cf = new CarFactory();
			 Car car = cf.createCar("Berline");
			 car.setDriver(driver);
			 driver.setCar(car);
			 driver.setGps(car.getGPS());
			 this.carList.add(car);
			 this.driverList.add(driver);
		 }
		 
		 for(int i = 1; i <= nbVan; i++) {
			 Driver driver = new Driver();
			 
			 CarFactory cf = new CarFactory();
			 Car car = cf.createCar("Van");
			 car.setDriver(driver);
			 driver.setCar(car);
			 driver.setGps(car.getGPS());
			 this.carList.add(car);
			 this.driverList.add(driver);
		 }
	}
	
	public Customer findCustomerByID(int id) {
		for (Customer customer: this.customerList) {
			if( customer.getCustomerID() == id) {
				return customer;
			}
		}return null;
	}
	
	public Car findCarByID(String id) {
		for (Car car: this.carList) {
			if( car.getCarID() == id) {
				return car;
			}
		}return null;
	}

	
	public Driver findDriverByName(String name, String surname) {
		for (Driver driver: this.driverList) {
			if(driver.name == name && driver.surname ==surname){
				
				return driver;
			}
		} return null;
	} 
	
	public void addCustomer (Customer customer) {
		this.customerList.add(customer);
	}
	
	//Method to order Drivers according to their proximity to position
	public synchronized ArrayList<Driver> orderedDriverList(GPS position){
		ArrayList<Driver> orderedList = new ArrayList<Driver>();
		int n = this.driverList.size();
		orderedList.add(this.driverList.get(0));
		for (int i=1;i<n;i++) {
			Driver temp = this.driverList.get(i);
			int j = 0;
			double distance = temp.getGps().length(position);
			while (j<orderedList.size() && distance>orderedList.get(j).getGps().length(position)) {
				j++;
				}
			orderedList.add(j,temp);
			}
		//Verification 
		ArrayList<String> list = new ArrayList<String>();
		for (int i=0;i<n;i++) {
			list.add(orderedList.get(i).distancetoString(position));
		}
		//System.out.println(list);
	return orderedList;
}
	
		

	@Override
	public String toString() {
		return "This myUber is composed of " + nbcustomers + " customers ," + nbcars + " cars and " + nbdrivers + " drivers.";
	}
	
	
}
	
	
	


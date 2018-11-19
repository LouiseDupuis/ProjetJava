package myUberOthers;
import java.util.*;

import myUberCar.Car;
import myUberCar.CarFactory;
import myUberPeople.*;



public class myUber {
	public int nbcustomers;
	public int nbcars;
	public int nbdrivers;
	
	public ArrayList<Customer> customerList ;
	public ArrayList<Driver> driverList ;
	public ArrayList<Car> carList;

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

	@Override
	public String toString() {
		return "This myUber is composed of " + nbcustomers + " customers ," + nbcars + " cars and " + nbdrivers + " drivers.";
	}
	
	
}
	
	
	


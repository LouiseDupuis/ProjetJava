package myUberPeople;

import java.util.Scanner;

import myUberCar.Car;
import myUberOthers.GPS;
import myUberRide.Ride;

public class Driver {
	/**
	 * Driver class
	 * @author Ariane Dalens
	 * @version 0.2
	 */
	
	//public static ArrayList<Driver> drivers;    // list of all drivers 
	public static int counter = 0;  // count of drivers in the system
	
	public String name;   
	public String surname;  
	public int driverID;            // Driver ID
	
	public DriverState state; // State of the driver
	
	public double balance;  // balance in the account
	public int nbRide;    // number of rides done by the driver
	
	public GPS gps;     


	public Car car; 
	
	
	// Constructor
	public Driver() {
		// Creation of a driver
		counter++;
		this.driverID=counter;
		this.name="John";
		this.surname="Doe";
		this.balance=0.0;
		this.nbRide=0;
		//drivers.add(this);
		
		// adds a random state for the driver
		int r = (int) (Math.random()*5);
		if (r == 0 || r == 1) {
			this.state = DriverState.OFFLINE;
		}else if ( r == 2) {
			this.state = DriverState.OFFDUTY;
		}else {
			this.state = DriverState.ONDUTY;
		}
	}
	
	public void Parameters() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Change your name: ");
		this.setName(scan.nextLine());
		System.out.println("Change your surname: ");
		this.setSurname(scan.nextLine());
		scan.close();
	}
	
	//this method allows the driver to choose whether to accept the ride or not
	
	public boolean acceptRide(Ride ride) {
		return true ; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	public DriverState getState() {
		return state;
	}

	public void setState(DriverState state) {
		this.state = state;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getNbRide() {
		return nbRide;
	}

	public void setNbRide(int nbRide) {
		this.nbRide = nbRide;
	}
	
	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + ", surname=" + surname + ", driverID=" + driverID + ", state=" + state
				+ ", balance=" + balance + ", nbRide=" + nbRide + "]";
	}

}

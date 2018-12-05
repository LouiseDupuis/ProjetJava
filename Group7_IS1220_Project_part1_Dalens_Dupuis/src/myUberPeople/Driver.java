package myUberPeople;

import java.util.ArrayList;
import java.util.Scanner;

import myUberCar.Berline;
import myUberCar.Car;
import myUberCar.Van;
import myUberOthers.GPS;
import myUberRide.Ride;
import myUberRide.UberBlack;
import myUberRide.UberPool;
import myUberRide.UberVan;

public class Driver {
	/**
	 * Driver class
	 * @author Ariane Dalens et Louise Dupuis
	 * @version 0.2
	 */
	
	//public static ArrayList<Driver> drivers;    // list of all drivers 
	public static int counter = 0;  // count of drivers in the system
	
	public String name;   
	public String surname;  
	public int driverID;            // Driver ID
	
	public DriverState state; // State of the driver
	
	public Double balance;  // balance in the account
	public int nbRide;    // number of rides done by the driver
	public double rating;
	public GPS gps; 
	public ArrayList<String> messageBox = new ArrayList<String>();
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
		this.balance=0.0;
		this.rating=5;
		this.messageBox = new ArrayList<String>();
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
	//If he can he automatically accept the ride
	
	public boolean acceptRide(Ride ride) {
		if(this.state == DriverState.ONDUTY || this.state==DriverState.OFFLINE || this.state == DriverState.ONARIDE) {
			return false;
		}
		if (ride instanceof UberVan && !(this.car instanceof Van)) {
			return false;
		}
		if (ride instanceof UberBlack && !(this.car instanceof Berline)) {
			return false;
		}
		if (ride instanceof UberPool && this.car.getFreeSeats() < ride.nbPassengers) {
			return false;
		}
		if( !(ride instanceof UberPool) && this.state == DriverState.ONPOOL) {
			return false;
		}
		
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
	
	/**
	 * Permet avec un Scanner de noter un chauffeur
	 * 
	 */
	
	public synchronized void rate(Customer cust) {
		Scanner scan1 = new Scanner(System.in);
		int input;
		System.out.println("Please rate your driver");
		cust.getMessageBox().add("Please rate your driver");
		input = scan1.nextInt();
		while (!(input>0 && input<=5)){
		System.out.println("Rate beetween 1 & 5");
		cust.getMessageBox().add("Rate beetween 1 & 5");
		input = scan1.nextInt();
	    }
		this.rating = (this.rating*this.nbRide+input)/(this.nbRide+1);
		//System.out.println(this);
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + ", surname=" + surname + ", driverID=" + driverID + ", state=" + state
				+ ", balance=" + balance + ", nbRide=" + nbRide +  ", rating=" + rating + ", gps=" + gps + ", ]";
	}

	public String distancetoString(GPS position){
		return "Driver [ID=" + driverID + "," + this.getGps().length(position)+ ", ]"; 
	}


}

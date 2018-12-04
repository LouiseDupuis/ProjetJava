package myUberPeople;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import myUber.MyUber;
import myUberOthers.GPS;
import myUberOthers.GPSRide;
import myUberOthers.Message;
import myUberOthers.PassengerNumber;
import myUberOthers.TrafficStatus;
import myUberRide.ConcreteRideCostVisitor;
import myUberRide.Ride;
import myUberRide.RideFactory;

public class Customer {

	private static int counter = 0;
	private int customerID;
	private String name;
	private String surname;
	private GPS gps;
	private int NbRides=0;
	private long CreditCard=1000000000;
	private Double balance= 0.0; 
    ArrayList<Message> messageBox = new ArrayList<Message>();
	
	
	public Customer() {
		counter++;
		this.customerID=counter;
		this.name= "John" ;
		this.surname= "Doe";
		this.gps= new GPS();
		this.setBalance(0.0);
	}
	

	public Customer(String name, String surname, long creditCard) {
		super();
		counter++;
		this.customerID=counter;
		this.name = name;
		this.surname = surname;
		this.gps= new GPS();
		this.setBalance(0.0);
		if(creditCard >= 1000000000000000.0 && creditCard <= 9999999999999999.0)
		    {
		    	this.CreditCard= creditCard;
		    }
		    else
		    {
		     System.out.println("Please enter a valide CreditCard Number");   
		    }	
	}
	
	
	// This methods allows a client to request a ride by entering a destination and a number of passengers
	// it presents the list of offererd rides and their price (the traffic is selected randomly)
	// the choice is made through the command line 
	// The method returns the chosen ride 
	
    public synchronized void requestRide(int nbPassenger, GPS end, MyUber myUber ) {
	    
	    
	    
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
	    Map<String,Double> priceList = visitor.priceList(this, end, nbPassenger);
	    	
	    	
	    System.out.println("This is the list of rides that we propose :");
	    System.out.println(priceList);
	    	
	    // the client chooses his/her preferred option
	    	
	    RideFactory factory = new RideFactory();
	    	
	    Scanner scan = new Scanner(System.in);
		String input;
		System.out.println("Please type the name of the ride you choose ");
		
	    input = scan.next();
		Ride ride = factory.createRide(input, this.getGps(), end, nbPassenger);
			  
		ride.myUber = myUber;
		ride.price = priceList.get(input);
	    ride.customer = this;
		
	    myUber.requestedRides.add(ride) ; 
	    	
	    	
	    }
	
	



	public int getCustomerID() {
		return customerID;
	}



	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}



	public GPS getGps() {
		return gps;
	}



	public void setGps(GPS gps) {
		this.gps = gps;
	}



	public int getNbRides() {
		return NbRides;
	}



	public void setNbRides(int nbRides) {
		NbRides = nbRides;
	}



	public long getCreditCard() {
		return CreditCard;
	}



	public void setCreditCard(long creditCard) {
		if(creditCard >= 1000000000000000.0 && creditCard <= 9999999999999999.0)
	    {
	    	CreditCard= creditCard;
	    }
	    else
	    {
	     System.out.println("Please enter a valide CreditCard Number");   
	    }	
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public ArrayList<Message> getMessageBox() {
		return messageBox;
	}



	public void setMessageBox(ArrayList<Message> messageBox) {
		this.messageBox = messageBox;
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

	public GPS getGPS() {
		return gps;
	}

	public void setGPS(GPS gps) {
		this.gps = gps;
	}


	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", surname=" + surname + ", gps=" + gps
				+ ", NbRides=" + NbRides + ", CreditCard=" + CreditCard + ", balance=" + getBalance() + ", messageBox="
				+ messageBox + "]";
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
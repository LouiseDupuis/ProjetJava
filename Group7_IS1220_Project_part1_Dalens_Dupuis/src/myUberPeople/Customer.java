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
	private int CreditCard=1000000000;
	private Double balance= 0.0; 
    private ArrayList<String> messageBox = new ArrayList<String>();
	
	
	public Customer() {
		counter++;
		this.customerID=counter;
		this.name= "John" ;
		this.surname= "Doe";
		this.gps= new GPS();
		this.setBalance(0.0);
		this.messageBox=new ArrayList<String>();
	}
	

	public Customer(String name, String surname, int creditCard) {
		super();
		counter++;
		this.customerID=counter;
		this.name = name;
		this.surname = surname;
		this.gps= new GPS();
		this.setBalance(0.0);
		this.messageBox=new ArrayList<String>();
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

	
    public synchronized Map<String,Double> requestRide(int nbPassenger, GPS end, MyUber myUber ) {
	    
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
	    return priceList; 	
	    	
	   
	    	

	    	
	    }
    
public synchronized void requestRandomRide(MyUber myUber ) {
	    
	    // definition of a random number of passengers (between 1 and 6)
	    int nbPassenger = (int) (Math.random()*6) + 1;
	    
	    // random GPS destination
	    
	    GPS end = new GPS();

	
	
	    
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
	    
	    // computing of the prices
	    
	    ConcreteRideCostVisitor visitor = new ConcreteRideCostVisitor(traffic);
	    Map<String,Double> priceList = visitor.priceList(this, end, nbPassenger);
	    
	    	
	    // a type of ride is chosen
	    
	    String name = "";
	    RideFactory factory = new RideFactory();

	    
	    if (nbPassenger <5) {
	    int l = (int) (Math.random()*4);
		if (l == 0 ) {
			name = "UberX";
		}else if ( l == 1) {
			name = "UberVan";
		}else if ( l == 2) {
			name = "UberPool";
		}else if ( l == 3) {
			name = "UberBlack";
		}
	    }else {
	    	name = "UberVan";
	    }
	
	    
		Ride ride = factory.createRide(name, this.getGps(), end, nbPassenger);
		System.out.println(ride);

			  
		ride.myUber = myUber;
		
		try {
		 ride.price = priceList.get(name);
		} catch(NullPointerException e) {
			System.out.println("Problème : le ride n'a pas de type");
		}
		
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



	public void setCreditCard(int creditCard) {
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



	public ArrayList<String> getMessageBox() {
		return messageBox;
	}



	public void setMessageBox(ArrayList<String> messageBox) {
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
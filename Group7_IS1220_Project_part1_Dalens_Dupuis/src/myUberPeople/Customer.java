package myUberPeople;

import java.util.ArrayList;

import myUberOthers.GPS;
import myUberOthers.Message;

public class Customer {

	private static int counter = 0;
	private int customerID;
	private String name;
	private String surname;
	private GPS gps;
	private int NbRides=0;
	private long CreditCard=1000000000;
	private double balance= 0.0; 
    ArrayList<Message> messageBox = new ArrayList<Message>();
	
	
	public Customer() {
		counter++;
		this.customerID=counter;
		this.name= "John" ;
		this.surname= "Doe";
		this.gps= new GPS();
	}
	

	public Customer(String name, String surname, long creditCard) {
		super();
		counter++;
		this.customerID=counter;
		this.name = name;
		this.surname = surname;
		this.gps= new GPS();
		if(creditCard >= 1000000000000000.0 && creditCard <= 9999999999999999.0)
		    {
		    	this.CreditCard= creditCard;
		    }
		    else
		    {
		     System.out.println("Please enter a valide CreditCard Number");   
		    }	
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
				+ ", NbRides=" + NbRides + ", CreditCard=" + CreditCard + ", balance=" + balance + ", messageBox="
				+ messageBox + "]";
	}

}
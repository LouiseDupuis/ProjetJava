package myUberCore;

import java.util.ArrayList;

import myUberCore.GPS;
import myUberCore.Message;

public class Customer {

	private static int counter = 0;
	private int customerID;
	public String name;
	public String surname;
	public GPS gps;
    ArrayList<Message> messageBox = new ArrayList<Message>();
	
	
	public Customer() {
		counter++;
		this.customerID=counter;
		this.name=null;
		this.surname=null;
		this.gps= new GPS(0,0);
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

}
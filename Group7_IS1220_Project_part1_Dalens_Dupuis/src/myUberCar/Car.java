package myUberCar;

import myUberPeople.Driver;
import myUberOthers.GPS;

public abstract class Car {
	
	protected String carID;
	protected int nbSeats;
	protected int freeSeats;
	protected GPS GPS= new GPS();
	protected Driver Driver;
	
	public String getCarID() {
		return carID;
	}
	public void setCarID(String carID) {
		this.carID = carID;
	}
	public int getNbSeats() {
		return nbSeats;
	}
	public void setNbSeats(int nbSeats) {
		this.nbSeats = nbSeats;
	}
	public int getFreeSeats() {
		return freeSeats;
	}
	public void setFreeSeats(int freeSeats) {
		this.freeSeats = freeSeats;
	}
	public GPS getGPS() {
		return GPS;
	}
	public void setGPS(GPS gPS) {
		GPS = gPS;
	}
	public Driver getDriver() {
		return Driver;
	}
	public void setDriver(Driver driver) {
		Driver = driver;
	}
	@Override
	public String toString() {
		return "Car [carID=" + carID + ", nbSeats=" + nbSeats + ", freeSeats=" + freeSeats + ", GPS=" + GPS
				+ ", Driver=" + Driver + "]";
	} 
	
	


}

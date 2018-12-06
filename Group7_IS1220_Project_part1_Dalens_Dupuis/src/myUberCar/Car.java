package myUberCar;

import myUberPeople.Driver;
import myUberOthers.GPS;

/**
 * Classe abstraite de Voiture
 * @author Ariane Dalens et Louise Dupuis
 * @version 0.1
 */

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
		return "Car [carID=" + carID  + ", GPS=" + GPS
				+  "]";
	} 
	
	


}

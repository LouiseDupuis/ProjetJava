package myUberCar;

public class Berline extends Car {
	
	private static int counter; 

	public Berline() {
		super();
		counter++; 
		this.carID="Berline"+ counter;
		this.nbSeats=4;
		this.freeSeats=4;
	}
	
	

}

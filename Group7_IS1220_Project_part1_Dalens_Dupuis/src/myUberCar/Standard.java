package myUberCar;

public class Standard extends Car {
	
	private static int counter;
	
	public Standard() {
		super();
		counter++; 
		this.carID="Standard"+ counter;
		this.nbSeats=4;
		this.freeSeats=4;
	}

}

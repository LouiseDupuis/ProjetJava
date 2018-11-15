package myUberCar;

public class Van extends Car {
	
	private static int counter;
	
	public Van() {
		super();
		counter++; 
		this.carID="Van"+ counter;
		this.nbSeats=6;
		this.freeSeats=6;
	}
	

}

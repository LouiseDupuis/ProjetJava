package myUberOthers;
import java.util.*;


public class myUber {
	public int nbcustomers;
	public int nbcars;
	public int nbdrivers;
	 
	
	public myUber( int nbcustomers, int nbcars, int nbdrivers) {
		this.nbcustomers = nbcustomers;
		this.nbcars = nbcars;
		this.nbdrivers = nbdrivers;
	}
	
	public myUber() {
		int nbcars = (int) (Math.random()*100);
		int nbdrivers = nbcars; //in our simplified model, each driver owns a car 
		int nbcustomers = (int)(Math.random()*150);
		this.nbcustomers = nbcustomers;
		this.nbcars = nbcars;
		this.nbdrivers = nbdrivers;
	
	
	}
	
	
	

}

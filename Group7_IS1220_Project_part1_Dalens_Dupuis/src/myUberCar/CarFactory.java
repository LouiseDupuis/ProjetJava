package myUberCar;

import myUberOthers.GPS;

public class CarFactory {
		
		public Car createCar( String typeofCar ) {
			if ( typeofCar.equalsIgnoreCase("STANDARD")) {
				return new Standard();
				
			} else if ( typeofCar.equalsIgnoreCase("VAN")) {
				return new Van();
				
			} else if ( typeofCar.equalsIgnoreCase("BERLINE")) {
				return new Berline();

			}
			
			return null; 
		
	}
}

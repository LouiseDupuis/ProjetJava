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
			
			System.out.println("Impossible to create a " + typeofCar);
			return null; 
		}
			
		public Car createRandomCar() {
			int r = (int) (Math.random()*3);
			if (r == 0) {
				return new Standard();
			}else if (r==1) {
				return new Van();
			}else {
				return new Berline();
			}
		}
		
	}

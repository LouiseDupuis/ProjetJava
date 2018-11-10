package myUberOthers;

import java.util.Scanner;

public class GPSRide extends GPS {
	 /**
	Classe avec condition et input console pour construction
*/

	public GPSRide() {

			Scanner scan = new Scanner(System.in);
			Double input;
			System.out.println("What is the latitude of the end point [48,8 - 48,9]: ");
			while (true){
			   if (scan.hasNextDouble()){
			             input = scan.nextDouble();// Assign the next integer to a variable
			             if (input  <= 48.9 && input >= 48.8 ){ // Check if integer meets condition
			            	 this.latitude=input;  
			            	 break; // Condition met, break out of loop
			            }
			        }else{
			              scan.next();
			        }
			        System.out.println("Please enter a valid number between 48,8 and 48,9 we only take rides in Paris ! : ");
			    }
			System.out.println("What is the longitude of the end point [2,22 - 2,44]: ");
			while (true){
			if (scan.hasNextDouble()){
	             input = scan.nextDouble();// Assign the next integer to a variable
	             if (input  <= 2.44 && input >= 2.22 ){ // Check if integer meets condition
	            	 this.longitude=input; 
	            	 break; // Condition met, break out of loop
	            }
	        }else{
	              scan.next();
	        }
	        System.out.println("Please enter a valid number between 2,22 and 2,44 we only take rides in Paris ! : ");
	    }
			scan.close();
		}

	}
	


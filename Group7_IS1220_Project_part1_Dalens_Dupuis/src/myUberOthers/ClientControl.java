package myUberOthers;

import java.util.Scanner;

// this class treats the demands of the customers 

public class ClientControl {

	public ClientControl() {
		Scanner scan = new Scanner(System.in);
		Integer input;
		System.out.println("How many passengers will board ? (1-6) ");
		while (true){
		   if (scan.hasNextInt()){
		             input = scan.nextInt();// Assign the next integer to a variable
		             if (input  <= 6 && input >= 1){ // Check if integer meets condition
		            	 this.passengerNumber=input;  
		            	 break; // Condition met, break out of loop
		            }
		        }else{
		              scan.next();
		        }
		        System.out.println("Please enter a valid number between 1 and 6");
		    }
		
		scan.close();
	}
	
	

}

package myUberRide;
import java.util.*;
import myUberOthers.*;

// Cette classe est celle qui calcule concr�tement le prix d'une course
// Les m�thodes visit retournent des Hashmap o� les cl�s sont des Strings et les �l�ments des Float ce qui permet 
// de repr�senter le tableau donn� dans l'�nonc� (� faire lorsqu'on aura trouv� une mani�re efficace de le faire)

public class ConcreteRideCostVisitor implements RideCostVisitor {
	
	public Map<String, Double> visit(UberX uberx) {
		Map<String, Double> tableau = new HashMap<>();
		tableau.put("a", 3.3);
		tableau.put("b", 4.2);
		tableau.put("c", 1.91);
		tableau.put("d",1.5);
		return tableau; 
		
	};
	
	public double rideFare(Ride ride) {
		double longueur = ride.start.length(ride.end);
		double basicRate = 1;
		if
		
	}

}

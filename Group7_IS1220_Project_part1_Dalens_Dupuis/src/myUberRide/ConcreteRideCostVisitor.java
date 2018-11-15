package myUberRide;
import java.util.*;
import myUberOthers.*;

// Cette classe est celle qui calcule concrètement le prix d'une course
// Les méthodes visit retournent des Hashmap où les clés sont des Strings et les éléments des Float ce qui permet 
// de représenter le tableau donné dans l'énoncé (à faire lorsqu'on aura trouvé une manière efficace de le faire)

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

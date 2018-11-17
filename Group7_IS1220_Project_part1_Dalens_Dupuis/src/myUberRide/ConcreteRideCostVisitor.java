package myUberRide;
import java.util.*;
import myUberOthers.*;

// Cette classe est celle qui calcule concretement le prix d'une course


public class ConcreteRideCostVisitor implements RideCostVisitor {
	
	// pour regler le probleme du traffic, pour l'instant on utilise un attribut du visitor 
	
	public TrafficStatus trafficState; 
	
	
	public ConcreteRideCostVisitor(TrafficStatus trafficState) {
		super();
		this.trafficState = trafficState;
	}

	// la methode visit retourne le prix du ride
	
	public double visit(UberX uberx) { 
		double longueur = uberx.start.length(uberx.end);
		double rate = 0;
		if (longueur <= 5) {
			rate = 3.3;
		} else if (longueur <= 10) {
			rate = 4.2;
		} else if (longueur <= 20) {
			 rate = 1.91;
		}else {
			 rate = 1.5;
		}
		
		double tRate = 0;
		if (this.trafficState == TrafficStatus.LOW) {
			tRate = 1;
		}else if (this.trafficState == TrafficStatus.MEDIUM) {
			tRate = 1.1;
		}else if (this.trafficState == TrafficStatus.HEAVY) {
			tRate = 1.5;
		}
		return rate *  tRate * longueur ;
		
		
	};
	
		
		
	}

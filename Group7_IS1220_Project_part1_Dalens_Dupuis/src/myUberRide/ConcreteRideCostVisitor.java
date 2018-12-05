package myUberRide;
import java.util.*;
import myUberOthers.*;
import myUberPeople.Customer;

// Cette classe est celle qui calcule concretement le prix d'une course


public class ConcreteRideCostVisitor implements RideCostVisitor {
	
	// pour regler le probleme du traffic, pour l'instant on utilise un attribut du visitor 
	
	public TrafficStatus trafficState; 
	
	
	public ConcreteRideCostVisitor(TrafficStatus trafficState) {
		super();
		this.trafficState = trafficState.set();
		System.out.println(this.trafficState);
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
		
		
	}

	@Override
	public double visit(UberVan ubervan) {
		double longueur = ubervan.start.length(ubervan.end);
		double rate = 0;
		if (longueur <= 5) {
			rate = 6.2;
		} else if (longueur <= 10) {
			rate = 7.7;
		} else if (longueur <= 20) {
			 rate = 3.25;
		}else {
			 rate = 2.6;
		}
		
		double tRate = 0;
		if (this.trafficState == TrafficStatus.LOW) {
			tRate = 1;
		}else if (this.trafficState == TrafficStatus.MEDIUM) {
			tRate = 1.5;
		}else if (this.trafficState == TrafficStatus.HEAVY) {
			tRate = 1.8;
		}
		return rate *  tRate * longueur ;
		
	}

	@Override
	public double visit(UberBlack uberblack) {
		double longueur = uberblack.start.length(uberblack.end);
		double rate = 0;
		if (longueur <= 5) {
			rate = 6.2;
		} else if (longueur <= 10) {
			rate = 5.5;
		} else if (longueur <= 20) {
			 rate = 3.25;
		}else {
			 rate = 2.6;
		}
		
		double tRate = 0;
		if (this.trafficState == TrafficStatus.LOW) {
			tRate = 1;
		}else if (this.trafficState == TrafficStatus.MEDIUM) {
			tRate = 1.3;
		}else if (this.trafficState == TrafficStatus.HEAVY) {
			tRate = 1.6;
		}
		return rate *  tRate * longueur ;
		
	}

	@Override
	public double visit(UberPool uberpool) {
		double longueur = uberpool.start.length(uberpool.end);
		double rate = 0;
		if (longueur <= 5) {
			rate = 2.4;
		} else if (longueur <= 10) {
			rate = 3;
		} else if (longueur <= 20) {
			 rate = 1.3;
		}else {
			 rate = 1.1;
		}
		
		double tRate = 0;
		if (this.trafficState == TrafficStatus.LOW) {
			tRate = 1;
		}else if (this.trafficState == TrafficStatus.MEDIUM) {
			tRate = 1.1;
		}else if (this.trafficState == TrafficStatus.HEAVY) {
			tRate = 1.2;
		}
		return rate *  tRate * longueur ;
		
	};
	
	// this method returns the list of different prices for various rides available
	
	public Map<String,Double> priceList(Customer customer, GPS end, int nbPassenger){
       Map<String,Double> priceList = new HashMap<>();
	    
	    if (nbPassenger<= 4) {
	    	UberX uberx = new UberX(customer.getGps(),end,nbPassenger);
	    	UberBlack uberblack = new UberBlack(customer.getGps(),end,nbPassenger);
	    	UberPool uberpool = new UberPool(customer.getGps(),end,nbPassenger);
	    	UberVan ubervan = new UberVan(customer.getGps(),end,nbPassenger);
	    	
	    	
	    	
	    	priceList.put("UberX",this.visit(uberx));
	    	priceList.put("UberBlack",this.visit(uberblack));
	    	priceList.put("UberPool",this.visit(uberpool));
	    	priceList.put("UberVan",this.visit(ubervan));
	    }else {
            UberVan ubervan = new UberVan(customer.getGps(),end,nbPassenger);
	    	
	    	
	    	priceList.put("UberVan",this.visit(ubervan));
	    }
	    
	    return priceList;
	}
	
		
		
	}

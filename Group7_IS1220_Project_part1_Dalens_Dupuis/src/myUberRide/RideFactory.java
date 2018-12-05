package myUberRide;

import myUberOthers.GPS;
/**
 * cette classe permet de creer un ride pas encore confirme en specifiant le type, le debut et la fin et le nombre de passagers
 * @author Ariane Dalens et Louise Dupuis
 * @version 1.3
 */

public class RideFactory {
	
	public Ride createRide( String typeOfRide, GPS start, GPS end, Integer nbPassagers ) {
		if ( typeOfRide.equalsIgnoreCase("UBERX") && nbPassagers <= 4) {
			return new UberX( start, end, nbPassagers);
			
		} else if ( typeOfRide.equalsIgnoreCase("UBERVAN") && nbPassagers <= 6) {
			return new UberVan( start, end, nbPassagers);
			
		} else if ( typeOfRide.equalsIgnoreCase("UBERBLACK") && nbPassagers <= 4) {
			return new UberBlack( start, end, nbPassagers);
		}else if ( typeOfRide.equalsIgnoreCase("UBERPOOL") && nbPassagers <= 4) {
			return new UberPool( start, end, nbPassagers);
		}
		return null; 
	}

	public RideFactory() {
		
	}
	
	 

}

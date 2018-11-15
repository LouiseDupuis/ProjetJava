package myUberRide;

import myUberOthers.GPS;

// cette classe permet de cr�er un ride pas encore confirm� en sp�cifiant le type, 
// le d�but et la fin et le nombre de passagers 

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

}

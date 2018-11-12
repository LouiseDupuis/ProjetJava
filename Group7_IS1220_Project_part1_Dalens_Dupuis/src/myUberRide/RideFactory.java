package myUberRide;

import myUberOthers.GPS;

// cette classe permet de créer un ride pas encore confirmé en spécifiant le type, 
// le début et la fin et le nombre de passagers 

public class RideFactory {
	
	public Ride createRide( RideType typeOfRide, GPS start, GPS end, Integer nbPassagers ) {
		if ( typeOfRide == RideType.UBERX && nbPassagers <= 4) {
			return new UberX( start, end, nbPassagers);
			
		} else if ( typeOfRide == RideType.UBERVAN && nbPassagers <= 6) {
			return new UberVan( start, end, nbPassagers);
			
		} else if ( typeOfRide == RideType.UBERBLACK && nbPassagers <= 4) {
			return new UberBlack( start, end, nbPassagers);
		}else if ( typeOfRide == RideType.UBERPOOL && nbPassagers <= 4) {
			return new UberPool( start, end, nbPassagers);
		}
		
		return null; 
	}

}

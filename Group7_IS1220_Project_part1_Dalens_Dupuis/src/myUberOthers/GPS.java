package myUberOthers;

import java.util.Random;

public class GPS {
	
	
	protected int latitude ;
	protected int longitude ;
	
	public GPS(int latitude, int longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	public GPS() {
		Random random = new Random();
		this.latitude = random.nextInt(101) - 50;
		this.longitude = random.nextInt(101) - 50;
	}
	

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	
	public double length(GPS gps2) { //https://www.geodatasource.com/developers/java
		// return Math.sqrt(Math.pow(this.getLatitude()-gps2.getLatitude(),2.0) + Math.pow(this.getLongitude()-gps2.getLongitude(),2.0));
		 /**
        Get length in km btw two GPS coordinates
        @param gps2 ending point.
        
        
        
    */
		
		int x = this.longitude - gps2.longitude;
		int y = this.latitude - gps2.latitude;
		return Math.sqrt( x^2 + y^2);		
	}

	@Override
	public String toString() {
		return "GPS [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	

}

package myUberOthers;


public class GPS {
	
	
	protected double latitude ;
	protected double longitude ;
	
	public GPS(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	// on suppose à Paris soit long 2.22 et 2.44 et lat entre 48.8 et 48.9
	public GPS() {
		this.latitude = 48.8 + Math.random()*0.1;
		this.longitude = 2.22 + Math.random()*0.22;
	}
	

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public double length(GPS gps2) { //https://www.geodatasource.com/developers/java
		// return Math.sqrt(Math.pow(this.getLatitude()-gps2.getLatitude(),2.0) + Math.pow(this.getLongitude()-gps2.getLongitude(),2.0));
		 /**
        Get length in km btw two GPS coordinates
        @param gps2 ending point.
        @param gps1 starting point. 
    */
		if ((this.getLatitude() == gps2.getLatitude()) && (this.getLongitude() == gps2.getLongitude())) {
			return 0;
		}
		else {
			double theta = this.getLongitude() - gps2.getLongitude();
			double dist = Math.sin(Math.toRadians(this.getLatitude())) * Math.sin(Math.toRadians(gps2.getLatitude())) + Math.cos(Math.toRadians(this.getLatitude())) * Math.cos(Math.toRadians(gps2.getLatitude())) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			dist = dist * 1.609344;
			return (dist);		
		}
	}

	@Override
	public String toString() {
		return "GPS [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	

}

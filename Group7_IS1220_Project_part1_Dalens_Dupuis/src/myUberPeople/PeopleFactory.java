package myUberPeople;


public class PeopleFactory {
	
	
	public Driver createRandomDriver() {
		Driver driver = new Driver();
		int r = (int) (Math.random()*3);
		if (r == 0) {
			driver.setState(DriverState.OFFLINE);
		}else if (r==1) {
			driver.setState(DriverState.ONDUTY);
		}else {
			driver.setState(DriverState.OFFDUTY);
		}
		
		return driver;
	}
	

}

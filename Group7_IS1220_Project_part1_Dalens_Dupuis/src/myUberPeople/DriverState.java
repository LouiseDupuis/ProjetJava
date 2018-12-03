package myUberPeople;

public enum DriverState {
	OFFLINE("offline"),
	ONDUTY("on-duty"),
	ONARIDE("on-a-ride"),
	OFFDUTY("off-duty"),
	ONPOOL("on-pool");
	final private String state;

	private DriverState(String state) {
		this.state = state;
	}
	
	
}

package myUberPeople;

public enum DriverState {
	OFFLINE("offline"),
	ONDUTY("on-duty"),
	ONARIDE("on-a-ride"),
	OFFDUTY("off-duty");
	final private String state;

	private DriverState(String state) {
		this.state = state;
	}
	
	
}

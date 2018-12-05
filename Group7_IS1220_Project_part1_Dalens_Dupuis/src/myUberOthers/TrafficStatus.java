package myUberOthers;

import java.util.GregorianCalendar;

import myUberPeople.DriverState;

public enum TrafficStatus{
	LOW,
	MEDIUM,
	HEAVY;
	
public TrafficStatus set() {
		java.util.GregorianCalendar calendar = new GregorianCalendar();
		int heure = calendar.get(java.util.Calendar.HOUR_OF_DAY);
		double a=Math.random();
		System.out.println(heure + a);
		if ((heure<7)&(heure>=22)) {
			if (a<0.95) {return TrafficStatus.LOW;}
			if ((a>=0.95)&(a<0.99)) {return TrafficStatus.MEDIUM;}
			if (a>0.99) {return TrafficStatus.HEAVY;}
			
		}
		if ((heure>=7)&(heure<11)) {
			if (a<0.05) {return TrafficStatus.LOW;}
			if ((a>=0.05)&(a<0.25)) {return TrafficStatus.MEDIUM;}
			if (a>0.25) {return TrafficStatus.HEAVY;}
			
		}
		if ((heure>=11)&(heure<17)) {
			if (a<0.15) {return TrafficStatus.LOW;}
			if ((a<=0.85)&(a>=0.15)) {return TrafficStatus.MEDIUM;}
			if (a>0.85) {return TrafficStatus.HEAVY;}
			
		}
		if ((heure>=17)&(heure<22)) {
			if (a<0.01) {return TrafficStatus.LOW;}
			if ((a>=0.01)&(a<0.05)) {return TrafficStatus.MEDIUM;}
			if (a>0.05) {return TrafficStatus.HEAVY;}
			
		}
		return(null);
	}
   
	
}
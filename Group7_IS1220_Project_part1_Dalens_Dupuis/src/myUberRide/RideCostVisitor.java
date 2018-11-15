package myUberRide;
import java.util.*;

public interface RideCostVisitor {
	
public Map<String,Double> visit(UberX uberx);

}

package myUberRide;



public interface RideCostVisitor {
	
public double visit(UberX uberx);
public double visit(UberVan ubervan);
public double visit(UberBlack uberblack);
public double visit(UberPool uberpool);
}

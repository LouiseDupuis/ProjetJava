package myUberStatistics;

import myUber.MyUber;

/**
 * Classe de calculs de statistiques sur l'univers myUber
 * @author Ariane Dalens et Louise Dupuis
 * @version 0.1
 */

public class Statistics {
	public MyUber myuber;
	
	public Statistics(MyUber myuber) {
		this.myuber = myuber; 
	}
	
	/**
	 * Méthode qui permet de calculer le nombre total de ride  
	 * @return l'entier qui correspond au nombre de courses
	 */
	
	public synchronized int NbTotalRides() {
		return myuber.bookOfRides.size();
	}
	
	/**
	 * Méthode qui permet de calculer le total d'argent collecté par les drivers
	 * @return le montant total encaissé
	 */
	
	public synchronized Double TotalCashed() {
		Double k=0.0;
		for (int i=0; i<myuber.driverList.size();i++) {
			k+=myuber.driverList.get(i).getBalance();
		}
		return k;
		}
	}
	
/**
 * Méthode qui permet de classer les customers
 * 
 */

	

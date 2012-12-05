package pto.grails

import java.util.Date;

/**
 * The Class PtoApplication.
 * 
 * @author W039080 Aug 22, 2012 10:45:37 AM
 */
class PtoApplication {

	/** The application name short. */
	String applicationNameShort;
	
	/** The application name long. */
	String applicationNameLong;
	
	/** The business unit. */
	BusinessUnit businessUnit;
	
	/** The seal application id. */
	Integer  sealApplicationId;
	
	/** The cbt. */
	User cbt;



	/** The constraints. */
	static constraints = {
		applicationNameShort(nullable: true)
		applicationNameLong(nullable: true)
		businessUnit(nullable: true)
		sealApplicationId(nullable: true)
		cbt(nullable: true)
	}
}

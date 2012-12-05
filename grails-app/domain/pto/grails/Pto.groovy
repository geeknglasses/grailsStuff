package pto.grails

/**
 * The Class Pto.
 * 
 * @author W039080 Aug 22, 2012 10:45:33 AM
 */
class Pto {
	
	/** The release title. */
	String releaseTitle;
	
	/** The description. */
	String description;
	
	/** The pto type. */
	PtoType ptoType;
	
	/** The owner. */
	User owner;
	
	/** The create date. */
	Date createDate;
	
	/** The go live date. */
	Date goLiveDate;
	
	/** The target completion date. */
	Date targetCompletionDate;
	
	/** The pto application. */
	PtoApplication ptoApplication;
	
	/** The status. */
	Status status;
	
	/** The ad manager. */
	User adManager;
	
	/** The operate manager. */
	User operateManager;
	
	/** The database manager. */
	User databaseManager;
	
	/** The region. */
	Region region;
	
	/** The sub region. */
	Region subRegion
	
	/** The lob. */
	LOB lob;
	
	/** The release type. */
	ReleaseType releaseType;
	
		/** The constraints. */
		static constraints = {
		ptoType(nullable:true)
		createDate(nullable:true)
		ptoApplication(nullable:true)
		status(nullable:true)
		operateManager(nullable:true)
		targetCompletionDate(nullable:true)
		databaseManager(nullable:true)
		region(nullable:true)
		subRegion(nullable:true)
		lob(nullable:true)
	}
}

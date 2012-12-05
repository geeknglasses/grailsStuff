package pto.grails

/**
 * The Class SDLC.
 * 
 * @author W039080 Aug 22, 2012 10:46:09 AM
 */
class SDLC {

	/** The release name. */
	String releaseName;
	
	/** The description. */
	String description;
	
	/** The sdlc type. */
	String sdlcType;
	
	/** The create date. */
	Date createDate;
	
	/** The go live date. */
	Date goLiveDate;
	
	/** The planned completion date. */
	Date plannedCompletionDate;
	
	/** The actual completion date. */
	Date actualCompletionDate;
	
	/** The application. */
	PtoApplication application;
	
	/** The owner. */
	User owner;
	
	/** The region. */
	Region region;
	
	/** The lob. */
	LOB lob;
	
	/** The status. */
	String status;
	
	/** The sub region. */
	Region subRegion;
	
	/** The release type. */
	ReleaseType releaseType;
	
	/** The last updated by. */
	User lastUpdatedBy;
	
	/** The methodology. */
	Methodology methodology;
	
	/** The business unit. */
	BusinessUnit businessUnit;



	/** The constraints. */
	static constraints = {

		releaseName(nullable: false)
		description(nullable: false)
		sdlcType(nullable: true)
		createDate(nullable: true)
		goLiveDate(nullable: true)
		plannedCompletionDate(nullable: true)
		actualCompletionDate(nullable: true)
		application(nullable: true)
		owner(nullable: true)
		region(nullable: true)
		lob(nullable: true)
		status(nullable: true)
		subRegion(nullable: true)
		releaseType(nullable: true)
		lastUpdatedBy(nullable: true)
		methodology(nullable: true)
		businessUnit(nullable: false)
	}
}

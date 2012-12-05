/**
 * .
 */
package pto.grails

/**
 * The Enum ReleaseType.
 * 
 * @author W039080 Aug 22, 2012 10:46:01 AM
 */
enum ReleaseType {

	/** The New business. */
	NewBusiness(1, 'New Business'), /** The New application. */
 NewApplication(2, 'New Application'), /** The Scheduled. */
 Scheduled(3, 'Scheduled')


	/**
	 * Instantiates a new release type.
	 * 
	 * @param id
	 *            the id
	 * @param desc
	 *            the desc
	 */
	ReleaseType(Integer id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	/** The desc. */
	private final String desc;
	
	/** The id. */
	final String id
	
	/**
	 * Desc.
	 * 
	 * @return the string
	 */
	public String desc() {
		return this.desc;
	}
}

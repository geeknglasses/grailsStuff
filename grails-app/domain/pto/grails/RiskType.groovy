/**
 * .
 */
package pto.grails

/**
 * The Enum RiskType.
 * 
 * @author W039080 Aug 22, 2012 10:46:05 AM
 */
enum RiskType {

	/** The low. */
	LOW(1, 'Low'), /** The medium. */
 MEDIUM(2, 'Medium'), /** The high. */
 HIGH(3, "High"), /** The notrated. */
 NOTRATED(4, "Not Rated")

	/**
	 * Instantiates a new risk type.
	 * 
	 * @param id
	 *            the id
	 * @param desc
	 *            the desc
	 */
	RiskType(Integer id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	/** The desc. */
	private final String desc;
	
	/** The id. */
	final String id
	
	/**
	 * Gets the desc.
	 * 
	 * @return the desc
	 */
	public String getDesc() {
		return this.desc;
	}
}

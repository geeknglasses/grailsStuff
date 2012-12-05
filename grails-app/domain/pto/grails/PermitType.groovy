/**
 * .
 */
/**
 * .
 */
package pto.grails

/**
 * The Enum PermitType.
 *
 * @author W039080 Aug 22, 2012 10:46:05 AM
 */
enum PermitType {

	PtS(1, 'PtS'), /** The medium. */
	PtB(2, 'PtB'), /** The high. */
	PtT(3, "PtT"), /** The notrated. */
	PtO(4, "PtO")

	/**
	 * Instantiates a new risk type.
	 *
	 * @param id
	 *            the id
	 * @param desc
	 *            the desc
	 */
	PermitType(Integer id, String desc) {
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

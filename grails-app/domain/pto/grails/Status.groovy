/**
 * .
 */
package pto.grails

/**
 * The Enum Status.
 * 
 * @author W039080 Aug 22, 2012 10:46:27 AM
 */
enum Status {

	/** The New. */
	New('New', 'New'), /** The Complete. */
 Complete('Complete', 'Complete')

	/**
	 * Instantiates a new status.
	 * 
	 * @param id
	 *            the id
	 * @param display
	 *            the display
	 */
	Status(String id, String display) {
		this.id = id;
		this.display = display;
	}
	
	/** The display. */
	private final String display;
	
	/** The id. */
	final String id
	
	/**
	 * Gets the display.
	 * 
	 * @return the display
	 */
	public String getDisplay() {
		return this.display;
	}
}

/**
 * .
 */
package pto.grails

import java.util.Date;

/**
 * The Enum PtoType.
 * 
 * @author W039080 Aug 22, 2012 10:45:49 AM
 */
enum PtoType {

	/** The newpto. */
	NEWPTO(1, 'New'), /** The largepto. */
	LARGEPTO(2, 'Large'), /** The smallpto. */
	SMALLPTO(3, 'Small')

	/** The id. */
	Integer id;

	/** The desc. */
	String desc;

	/**
	 * Instantiates a new pto type.
	 * 
	 * @param id
	 *            the id
	 * @param desc
	 *            the desc
	 */
	PtoType(Integer id, String desc){
		this.id = id
		this.desc = desc
	}
}

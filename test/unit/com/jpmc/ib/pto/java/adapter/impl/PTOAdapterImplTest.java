/**
 * W039080 Aug 15, 2012 10:49:22 PM
 */
package com.jpmc.ib.pto.java.adapter.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.jpmc.ib.pto.java.adapter.PTOAdapter;
import com.jpmc.ib.pto.java.bean.PTOApplication;

/**
 * @author W039080 Aug 15, 2012 10:49:22 PM
 * 
 */
public class PTOAdapterImplTest {

	PTOAdapter ptoAdapter;

	@Before
	public void setup() {
		ptoAdapter = new PTOAdapterImpl();
	}

	@Test
	public void testPTOApplication_ValidApplicationId() {
		try {
			PTOApplication ptoApplication = (PTOApplication) ptoAdapter.transformSEALtoPTO(28041);
			assertNotNull(ptoApplication);
			assertEquals(ptoApplication.getId(), 28041);
			assertEquals(ptoApplication.getName(), "Operate Workstation");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testPTOApplication_InvalidApplicationId() {
		PTOApplication ptoApplication;
		try {
			ptoApplication = (PTOApplication) ptoAdapter.transformSEALtoPTO(12345);

			assertNotNull(ptoApplication);
			assertEquals(ptoApplication.getId(), 0);
			assertEquals(ptoApplication.getName(), null);
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

}

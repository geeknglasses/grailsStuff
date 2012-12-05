/**
 * W039080 Aug 15, 2012 7:33:29 PM
 */
package com.jpmc.ib.pto.java.adapter.impl;

import com.jpmc.ib.pto.java.adapter.PTOAdapter;
import com.jpmc.ib.pto.java.bean.PTOApplication;
import com.jpmc.ib.pto.java.bean.RESTUrl;
import com.jpmc.ib.pto.java.util.XPathConstants;
import com.jpmc.ib.pto.java.util.XPathProcessor;

/**
 * @author W039080 Aug 15, 2012 7:33:29 PM
 * 
 */
public class PTOAdapterImpl implements PTOAdapter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jpmc.ib.pto.java.adapter.PTOAdapter#transformSEALtoPTO()
	 */
	@Override
	public Object transformSEALtoPTO(int applicationId) throws Exception {

		try {
			XPathProcessor xPathProcessorForPTO = new XPathProcessor(RESTUrl.SEALUrl.getUrl());
			xPathProcessorForPTO.init(String.valueOf(applicationId));

			String id = xPathProcessorForPTO.xPathParser(XPathConstants.APPLICATION_ID.getxPath());
			String name = xPathProcessorForPTO.xPathParser(XPathConstants.APPLICATION_NAME.getxPath());

			return buildPTOApplication(id, name);

		} catch (Exception e) {
			// TODO Add logger and throw exception
			e.printStackTrace();
			throw e;
		}
	}

	private PTOApplication buildPTOApplication(String id, String name) {

		PTOApplication ptoApplication = new PTOApplication();

		if (null != id && id.trim() != "")
			ptoApplication.setId(Integer.parseInt(id));

		if (null != name && name.trim() != "")
			ptoApplication.setName(name);

		return ptoApplication;
	}

}

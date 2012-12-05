package com.jpmc.ib.pto.java.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.sun.org.apache.xml.internal.dtm.ref.DTMNodeList;

/**
 * The Class XPathProcessor.
 * 
 * @author W039080 Jun 3, 2010 1:08:09 PM The Class XPathProcessor.
 */
public class XPathProcessor {

	/** The rest url. */
	private String restURL;

	/** The x path. */
	private XPath xPath;

	/** The xml document. */
	private Document xmlDocument;

	/**
	 * Instantiates a new x path processor.
	 * 
	 * @param restURL
	 *            the rest url
	 */
	public XPathProcessor(String restURL) {

		this.restURL = restURL;

	}

	/**
	 * 
	 * Use this init method if you want to use the xPath parser method:
	 * xPathParser This gets the response from the HTTP connection mentioned in
	 * the restURL and builds an xmlDocument to be used later by the xPath
	 * parser.
	 * 
	 */
	public void init(String inputId) throws Exception {

		try {

			String sealURL = restURL + inputId;
			URL url = new URL(sealURL);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			InputStream response = httpConn.getInputStream();
			Reader reader = new InputStreamReader(new GZIPInputStream(response), "UTF-8");

			InputSource is = new InputSource(reader);
			is.setEncoding("UTF-8");

			xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
			xPath = XPathFactory.newInstance().newXPath();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 
	 * Use this init method if you want to the use XStream for parsing. This
	 * gets the response from the HTTP connection mentioned in the restURL and
	 * builds an InputStream to be used later by the XStream parser. The caveat
	 * being, XStream mappings need to be defined for all the elements that are
	 * part of the responseXML.
	 * 
	 */
	public InputStream initXML(String inputId) throws Exception {

		URL url = null;
		URLConnection connection = null;
		try {

			String sealURL = restURL + inputId;
			url = new URL(sealURL);
			connection = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			InputStream response = httpConn.getInputStream();

			return response;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Uses the xPathExpression to parse the xmlDocument set in
	 * {@link #init(String)}method Returns the value of the element mentioned in
	 * the xPathString
	 * 
	 * @param xPathString
	 * 
	 * @return the string
	 */
	public String xPathParser(String xPathString) throws Exception {

		try {
			XPathExpression xPathExpression = xPath.compile(xPathString);
			return (String) xPathExpression.evaluate(xmlDocument, XPathConstants.STRING);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Uses the xPathExpression to parse the xmlDocument set in
	 * {@link #init(String)}method Returns the a set of nodes which are part of
	 * the response xml. Use this method if you are pasring anything other than
	 * a simple String.
	 * 
	 * @param xPathString
	 * 
	 * @return the DTMNodeList
	 */
	public DTMNodeList parseResponseForNodes(String xPathString) throws Exception {

		try {
			XPathExpression xPathExpression = xPath.compile(xPathString);
			Object obj = xPathExpression.evaluate(xmlDocument, XPathConstants.NODESET);
			if (null != obj) {
				System.out.println("Class for Node " + obj.getClass().getName());
				return (DTMNodeList) xPathExpression.evaluate(xmlDocument, XPathConstants.NODESET);
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	/**
	 * Gets the rest url.
	 * 
	 * @return the rest url
	 */
	public String getRestURL() {

		return restURL;
	}

	/**
	 * Sets the rest url.
	 * 
	 * @param restURL
	 *            the new rest url
	 */
	public void setRestURL(String restURL) {

		this.restURL = restURL;
	}

}

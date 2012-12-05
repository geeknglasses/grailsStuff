/**
 * W039080 Aug 15, 2012 10:26:36 PM
 */
package com.jpmc.ib.pto.java.bean;

/**
 * @author W039080 Aug 15, 2012 10:26:36 PM
 *
 */
public enum RESTUrl {
	
	SEALUrl("http://sealdi-uat.jpmchase.net/sealdi/legacy/data?clientAppId=28041&clientEnv=DEV&appId="),
	PhoneBookUrl("http://phone.jpmchase.net/services/search.aspx?appid=25190&sid=");
	
	
	String url; 
	
	private RESTUrl(String url){
		this.url = url;
	}

	public String getUrl() {
		return url;
	}


	
}

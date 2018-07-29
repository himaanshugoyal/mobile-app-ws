/**
 * 
 */
package com.himanshugoyal.tech.app.ws.ui.model.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author himanshugoyal
 *
 */
@XmlRootElement
public class AuthenticatonDetails {
	private String id;
	private String token;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	

}

package ar.com.UserGestioner.model.request;

import java.util.List;

public class UserRequest {
	String name;
	String email;
	String password;
	List<PhoneRequest> pones;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<PhoneRequest> getPones() {
		return pones;
	}
	public void setPones(List<PhoneRequest> pones) {
		this.pones = pones;
	}
	
	
}

package ar.com.UserGestioner.model.request;

import java.util.List;

import javax.validation.constraints.Pattern;

public class UserRequest {
	String name;

	
	@Pattern(regexp = "\\b[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]+\\b", message ="Mail mal escrito")
	String email;
	
	@Pattern(regexp ="^(?=(?:\\D*\\d){2}\\D*$)(?=(?:[^A-Z]*[A-Z]){1}[^A-Z]*$)[A-Za-z0-9]{8,12}$", message ="password mal escrito")
	String password;
	List<PhoneRequest> phones;
	
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
	public List<PhoneRequest> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneRequest> phones) {
		this.phones = phones;
	}
	
	
}

package ar.com.UserGestioner.builder;

import java.time.LocalDateTime;
import java.util.List;

import ar.com.UserGestioner.model.entity.Phone;
import ar.com.UserGestioner.model.entity.User;

public class UserBuilder {

	private long id;

	String email;

	String password;

	String name;

	private LocalDateTime created;

	private LocalDateTime lastLogin;

	private String token;

	private Boolean isActive;

	List<Phone> phones;

	public UserBuilder widthId(long id) {
		this.id = id;
		return this;
	}

	public UserBuilder widthEmail(String email) {
		this.email = email;
		return this;
	}

	public UserBuilder widthPassword(String password) {
		this.password = password;
		return this;
	}

	public UserBuilder widthName(String name) {
		this.name = name;
		return this;
	}



	public UserBuilder widthCreated(LocalDateTime created) {
		this.created = created;
		return this;
	}

	public UserBuilder widthLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
		return this;
	}

	public UserBuilder widthToken(String token) {
		this.token = token;
		return this;
	}

	public UserBuilder widthIsActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public UserBuilder widthPhones(List<Phone> phones) {
		this.phones = phones;
		return this;
	}

	public User build() {
		User user = new User();
		user.setId(this.id);
		user.setEmail(this.email);
		user.setPassword(this.password);
		user.setName(this.name);
		user.setCreated(this.created);
		user.setLastLogin(this.lastLogin);
		user.setToken(this.token);
		user.setIsActive(this.isActive);
		user.setPhones(this.phones);
		return user;

	}

}

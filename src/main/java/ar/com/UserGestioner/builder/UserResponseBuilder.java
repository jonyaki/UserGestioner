package ar.com.UserGestioner.builder;

import java.time.LocalDateTime;
import ar.com.UserGestioner.model.response.UserResponse;

public class UserResponseBuilder {

	private long id;
	private LocalDateTime created;
	private LocalDateTime lastLogin;
	private String token;
	private Boolean isActive;
	public UserResponseBuilder widthId(long id) {
		this.id = id;
		return this;
	}

	public UserResponseBuilder widthCreated(LocalDateTime created) {
		this.created = created;
		return this;
	}
	public UserResponseBuilder widthLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
		return this;
	}
	public UserResponseBuilder widthToken(String token) {
		this.token = token;
		return this;
	}
	public UserResponseBuilder widthIsActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public UserResponse build() {
		UserResponse user = new UserResponse();
		user.setId(this.id);
		user.setCreated(this.created);
		user.setLastLogin(this.lastLogin);
		user.setToken(this.token);
		user.setIsActive(this.isActive);
		return user;

	}

}

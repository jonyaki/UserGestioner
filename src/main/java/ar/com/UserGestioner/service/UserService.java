package ar.com.UserGestioner.service;

import ar.com.UserGestioner.model.request.UserRequest;
import ar.com.UserGestioner.model.response.UserResponse;

public interface UserService {
	public UserResponse singUp(UserRequest userRequest) throws Exception;

}

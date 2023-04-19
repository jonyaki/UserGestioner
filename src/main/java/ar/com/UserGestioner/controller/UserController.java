package ar.com.UserGestioner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.UserGestioner.model.request.UserRequest;
import ar.com.UserGestioner.model.response.UserResponse;
import ar.com.UserGestioner.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value= "/echo")
	public ResponseEntity<String> echo() {
		return ResponseEntity.ok("Todo Bien");
	}

	@PostMapping(value = "/sign-up")
	public ResponseEntity<UserResponse> singUp(@RequestBody UserRequest userRequest) {
		UserResponse userResponse = null;
		userService.singUp(userRequest);
		return ResponseEntity.ok(userResponse);

	}

}

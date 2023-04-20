package ar.com.UserGestioner.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import ar.com.UserGestioner.model.request.UserRequest;
import ar.com.UserGestioner.model.response.UserResponse;
import ar.com.UserGestioner.service.UserService;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

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
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = UserResponse.class),
		@ApiResponse(code = 400, message = "Error 400", response =Error.class ),
		@ApiResponse(code=422, message= "Error 422", response =Error.class),
		@ApiResponse(code = 500, message = "Error 500", response =Error.class) })
	public ResponseEntity<UserResponse> singUp(@Valid @RequestBody UserRequest userRequest) throws Exception {
		UserResponse userResponse = userService.singUp(userRequest);
		return ResponseEntity.ok(userResponse);

	}

}

package ar.com.UserGestioner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@GetMapping(value="/sign-up")
	public ResponseEntity singUp() {
		return ResponseEntity.status(ResponseEntity.accepted()).entity().build();

	}

}

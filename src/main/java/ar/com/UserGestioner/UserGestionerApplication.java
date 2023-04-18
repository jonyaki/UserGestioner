package ar.com.UserGestioner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("ar.com.UserGestioner.model.entity")
public class UserGestionerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserGestionerApplication.class, args);
	}

}

package ar.com.UserGestioner.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.UserGestioner.builder.PhoneBuilder;
import ar.com.UserGestioner.builder.UserBuilder;
import ar.com.UserGestioner.model.entity.User;
import ar.com.UserGestioner.model.request.UserRequest;
import ar.com.UserGestioner.repository.UserRepository;
import ar.com.UserGestioner.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void singUp(UserRequest userRequest) {
		persist(buildUser(userRequest));
	}

	public User buildUser(UserRequest userRequest) {
		return new UserBuilder().widthName(userRequest.getName()).widthPassword(userRequest.getPassword())
				.widthPhones(userRequest.getPhones().stream()
						.map((phone) -> new PhoneBuilder().widthNumber(phone.getNumber())
								.widthCityCode(phone.getCityCode()).widthContryCode(phone.getContryCode()).build())
						.collect(Collectors.toList()))
				.widthEmail(userRequest.getEmail()).build();
	}

	public void persist(User user) {
		userRepository.save(user);
		userRepository.flush();

	}

}

package ar.com.UserGestioner.service.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.UserGestioner.Exeptions.BadRequestException;
import ar.com.UserGestioner.builder.PhoneBuilder;
import ar.com.UserGestioner.builder.UserBuilder;
import ar.com.UserGestioner.builder.UserResponseBuilder;
import ar.com.UserGestioner.model.entity.User;
import ar.com.UserGestioner.model.request.UserRequest;
import ar.com.UserGestioner.model.response.UserResponse;
import ar.com.UserGestioner.repository.UserRepository;
import ar.com.UserGestioner.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserResponse singUp(UserRequest userRequest) throws Exception {
		userExistationValidate(userRequest);
		User user = buildUser(userRequest);
		persist(user);
		return buildUserResponse(user);
	}

	public User buildUser(UserRequest userRequest){		
		return new UserBuilder()
				.widthCreated(LocalDateTime.now())
				.widthName(userRequest.getName())
				.widthPassword(userRequest.getPassword())
				.widthCreated(LocalDateTime.now())
				.widthLastLogin(LocalDateTime.now())
				.widthIsActive(Boolean.TRUE)
				.widthPhones(userRequest.getPhones().stream()
						.map(phone -> 
							new PhoneBuilder()
								.widthNumber(phone.getNumber())
								
								.widthCityCode(phone.getCityCode())
								.widthContryCode(phone.getContryCode())
								.build()
							).collect(Collectors.toList()))
				.widthEmail(userRequest.getEmail()).build();
	}
	
	public UserResponse buildUserResponse(User user){		
		return new UserResponseBuilder()
				.widthCreated(user.getCreated())
				.widthLastLogin(user.getLastLogin())
				.widthIsActive(user.getIsActive())
				.widthId(user.getId())
				.widthToken(generateToken(user.getName()))
				.build();
	}
	public void persist(User user) {
		userRepository.save(user);
		userRepository.flush();

	}
	public void userExistationValidate(UserRequest userRequest) throws Exception {
		if(userRepository.existsUserByName(userRequest.getName())) {		
			throw new BadRequestException("Ya Existe el usuario");
		}
	}
	
	public String generateToken(String name) {
		  return Jwts.builder()
		          .setSubject(name)
		          .setExpiration(new Date(System.currentTimeMillis() + 3600000))
		          .signWith(SignatureAlgorithm.HS512, "miSecreto")
		          .compact();
	}
}

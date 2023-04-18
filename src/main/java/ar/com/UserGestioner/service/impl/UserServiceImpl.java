package ar.com.UserGestioner.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.UserGestioner.model.entity.Phone;
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
		User user = new User();
		user.setNombre("sdd");
		Phone phone = new Phone();
		phone.setNumber(123333);
		phone.setCityCode(117);
		List<Phone> phns= new ArrayList<>();
		phns.add(phone);
		user.setPhones(phns);
		persist(user);

	}
	public void persist(User user) {
		userRepository.save(user);
		userRepository.flush();

	}

}

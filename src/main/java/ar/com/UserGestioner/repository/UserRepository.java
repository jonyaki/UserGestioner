package ar.com.UserGestioner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.UserGestioner.model.entity.User;
import ar.com.UserGestioner.model.request.UserRequest;

public interface UserRepository extends JpaRepository<User, Long>{
}

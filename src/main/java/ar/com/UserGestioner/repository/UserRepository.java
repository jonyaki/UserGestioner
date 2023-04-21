package ar.com.UserGestioner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.UserGestioner.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public boolean existsUserByEmail(String name);
	public User getByMail(String name);
}

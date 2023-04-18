package ar.com.UserGestioner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.UserGestioner.model.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long>{
}

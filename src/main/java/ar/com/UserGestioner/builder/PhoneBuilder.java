package ar.com.UserGestioner.builder;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ar.com.UserGestioner.model.entity.Phone;
import ar.com.UserGestioner.model.entity.User;
import ar.com.UserGestioner.model.request.PhoneRequest;


public class PhoneBuilder {
	
	private long number;
	
	private long cityCode;
		
	private String contryCode;

	private User user;

	public PhoneBuilder widthNumber(long number) {
		this.number = number;
		return this;
	}

	public PhoneBuilder widthCityCode(long cityCode) {
		this.cityCode = cityCode;
		return this;
	}

	public PhoneBuilder widthContryCode(String contryCode) {
		this.contryCode = contryCode;
		return this;
	}
	
	public PhoneBuilder widthUser(User user) {
		this.user = user;
		return this;
	}

	public Phone build() {
		Phone phone = new Phone();
		phone.setNumber(this.number);
		phone.setCityCode(this.cityCode);
		phone.setContryCode(this.contryCode);
		phone.setUser(this.user);
		return phone;
	}
	
	
	
}

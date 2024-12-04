package com.meenus.springboot_dto;

import com.meenus.springboot_dto.model.Location;
import com.meenus.springboot_dto.model.User;
import com.meenus.springboot_dto.repository.LocationRepository;
import com.meenus.springboot_dto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDtoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDtoApplication.class, args);
	}
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Override
	public void run(String... args) throws Exception {
    Location location=new Location();
	location.setPlace("pune");
	location.setDescription("good");
	location.setLongitude(1);
	location.setLatitude(2);
	locationRepository.save(location);

	User user1=new User();
	user1.setFirstName("meenu");
    user1.setLastName("rooney");
	user1.setEmail("lots@lmal.com");
	user1.setLocation(location);
	user1.setPassword("");
	userRepository.save(user1);

		User user2=new User();
		user2.setFirstName("lloyd");
		user2.setLastName("rooney");
		user2.setLocation(location);
		user2.setEmail("lo4ts@lmal.com");
		user2.setPassword("");
		userRepository.save(user2);

	}
}

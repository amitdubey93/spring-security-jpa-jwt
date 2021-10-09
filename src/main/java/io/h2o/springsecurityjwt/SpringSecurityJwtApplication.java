package io.h2o.springsecurityjwt;

import io.h2o.springsecurityjwt.models.User;
import io.h2o.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initUser(){
		List<User> users = Stream.of(
				new User(101,"amit","amit","amit1@email.com"),
				new User(102,"amit2","amit2","amit2@email.com"),
				new User(103,"amit3","amit3","amit3@email.com"),
				new User(104,"amit4","amit4","amit4@email.com")
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}

package com.wa;

import com.wa.domain.User;
import com.wa.repositories.UserRepository;
import com.wa.security.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@SpringBootApplication
public class WunderListApplication {

	public static void main(String[] args) {
		SpringApplication.run(WunderListApplication.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository) throws Exception {
	    if(repository.count()==0){
	        User user = new User();
	        user.setPassword("user");
	        user.setUsername("user");
	        repository.save(user);
        }
		builder.userDetailsService(s -> new CustomUserDetail(repository.findByUsername(s)));
	}
}

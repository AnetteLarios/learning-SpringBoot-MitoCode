package com.testWeb;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.testweb.repo.IUserRepo;
import com.testweb.model.UserLog;
@SpringBootTest
class DemoWebSpringBootApplicationTests {
	
	@Autowired
	private IUserRepo userRepository;
	
	@Autowired
	private BCryptPasswordEncoder cryptPassword;
	
	
	
	@Test
	void createUserTest() {
		UserLog user = new UserLog();
		user.setId(2);
		user.setName("editor");
		user.setPassword(cryptPassword.encode("2003"));
		UserLog userReturn = userRepository.save(user);
		assertTrue(userReturn.getPassword().equalsIgnoreCase(user.getPassword()));
	}

}

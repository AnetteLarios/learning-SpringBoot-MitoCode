package com.testweb.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.testweb.model.UserLog;

public interface IUserRepo extends JpaRepository<UserLog, Integer>{
	UserLog findByName(String name);
}

package com.testweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testweb.model.Human;

public interface IHumanRepo extends JpaRepository<Human, Integer> {
	
}

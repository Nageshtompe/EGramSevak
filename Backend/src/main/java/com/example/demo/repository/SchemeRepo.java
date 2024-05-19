package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Scheme;

@Repository
public interface SchemeRepo  extends JpaRepository<Scheme, Integer>{
	
	Scheme findBySchemeShortName(String shortName);

	
}

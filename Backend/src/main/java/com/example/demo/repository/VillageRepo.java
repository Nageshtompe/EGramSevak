package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Village;


@Repository
public interface VillageRepo  extends JpaRepository<Village, Integer>{
	
	Village findByVillageName(String villageName);
	
	

}

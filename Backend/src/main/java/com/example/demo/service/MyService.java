package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Scheme;
import com.example.demo.model.User;
import com.example.demo.model.Village;

@Service
public interface MyService {
	
	 boolean userRegister(User user,String selectedVillage);
	 
	 int loginUser(String UIusername,String UIpassword);
	 
	 List<User> getunverifiedUserInDB();
	 
	 boolean addVillageDataInDB(Village village);
	 
	 List<Village> getAllVillage();
	 
	 boolean addSchemeInVillage(Scheme scheme,String selectVillage);

}

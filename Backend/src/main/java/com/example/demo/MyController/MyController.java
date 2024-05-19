package com.example.demo.MyController;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Scheme;
import com.example.demo.model.User;
import com.example.demo.model.Village;
import com.example.demo.service.MyService;


@CrossOrigin(origins = "*")
@RestController
public class MyController {

	@Autowired
	MyService service;
	
	@PostMapping("addScheme{selectVillage}")
	public boolean addScheme(@RequestBody Scheme scheme,@PathVariable String selectVillage)
	{
		System.out.println(scheme);
		System.out.println(selectVillage);
		
		return service.addSchemeInVillage(scheme, selectVillage);
	}


	@PostMapping("register{selectedVillage}")
	public boolean register(@RequestBody User user,@PathVariable String selectedVillage)
	{
		try {
			
			service.userRegister(user, selectedVillage);
			return true;
		} catch (Exception e) { 
			e.printStackTrace();
			return false;
		}
	}
	
	@GetMapping("login{UIusername}/{UIpassword}")
	public int login(@PathVariable String UIusername,@PathVariable String UIpassword)
	{
	
		return service.loginUser(UIusername,UIpassword);
	}
	
	@PostMapping("addVillageData")
	public boolean addVillageData(@RequestBody Village vlg)
	{
		return service.addVillageDataInDB(vlg);
	}
	
	
	@GetMapping("getunverifiedUserData")
	public List<User> getunverifiedUserData()
	{
		return service.getunverifiedUserInDB();
	}
	
	@GetMapping("getVillageData")
	public List<Village> getVillageData()
	{
		return service.getAllVillage();
	}

}

package com.example.demo.serviceImplementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Scheme;
import com.example.demo.model.User;
import com.example.demo.model.Village;
import com.example.demo.repository.SchemeRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.VillageRepo;
import com.example.demo.service.MyService;

@Component
public class ServiceImplementation implements MyService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	VillageRepo villageRepo;

	@Autowired
	SchemeRepo schemeRepo;


	@Override
	public boolean userRegister(User user,String selectedVillage) {
		try {

			user.setRegistrationDate(new Date());
			user.setUserRole(3);
			user.setIsuserundefined(1);
			userRepo.save(user);
			
			Village village = villageRepo.findByVillageName(selectedVillage);
			User dbUser = userRepo.getUserFromUsername(user.getUsername());
			List<User> users = village.getUsers();
			users.add(dbUser);
			villageRepo.save(village);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}

	}

	@Override
	public int loginUser(String UIusername, String UIpassword) {

		int cnt=userRepo.countByUsername(UIusername);
		if(cnt==1)
		{

			User user=userRepo.getUserFromUsername(UIusername);
			if(user.getUsername().equals(UIusername)&&user.getPassword().equals(UIpassword))
			{
				if(user.getIsuserundefined()==2)
				{
					return user.getUserRole();
				}
				else if(user.getIsuserundefined()==3)
				{
					return -3;
				}else
				{
					return -2;
				}
				
			}
			else
			{
				return -1;
			}

		}
		return -1;
	}

	@Override
	public List<User> getunverifiedUserInDB() {

		try {

			List<User> userData=userRepo.getDataOfUnverified();
			return userData;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean addVillageDataInDB(Village village) {

		try {

			villageRepo.save(village);
			return true;



		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}



	}

	@Override
	public List<Village> getAllVillage() {

		try {

			List<Village> allData=villageRepo.findAll();
			return allData;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}



	}

	@Override
	public boolean addSchemeInVillage(Scheme scheme, String selectVillage) {

		try {
			schemeRepo.save(scheme);
			Village village=villageRepo.findByVillageName(selectVillage);
			System.out.println(village);
			Scheme dbScheme=schemeRepo.findBySchemeShortName(scheme.getSchemeShortName());
			System.out.println("My DB Scheme"+dbScheme);
			List<Village> villages=dbScheme.getVillage();
			villages.add(village);
			schemeRepo.save(dbScheme);
			return true;


		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}


	}

}

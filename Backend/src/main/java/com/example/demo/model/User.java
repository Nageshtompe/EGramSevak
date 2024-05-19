package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity@Data@NoArgsConstructor@AllArgsConstructor@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String fullname;
	String username;
	String password;
	//String confirmPassword;
	long mobNum;
	Date registrationDate;
	int userRole;		//1-superAdmin	2-admin	3-user
	int isuserundefined;		//1-none	2-VerifiedUser	3-rejectedUser 
	
	
	
	
	

}

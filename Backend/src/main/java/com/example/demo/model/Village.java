package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity@Data@ToString@AllArgsConstructor@NoArgsConstructor
public class Village {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String villageName;
	int pincode;
	
	
	@OneToMany
	List<User> users;
}

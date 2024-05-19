package com.example.demo.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class Scheme{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String schemeShortName;
	String schemeDesc;
	Date schemeStartDate;
	Date expDate;
	
	
	@ManyToMany
	List<Village> village;
	
	
	

}

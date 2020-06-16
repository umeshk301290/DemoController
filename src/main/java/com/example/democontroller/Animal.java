package com.example.democontroller;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;

@Service
@Scope("prototype")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Animal {
	
	Integer id;
	String password;
	Animal(){
		
	}
	
	Animal(Integer id,String name){
		this.id=id;
		this.password=name;
	}
	@PostConstruct
	public void init() {
	System.out.println("bean init");
		
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", password=" + password + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

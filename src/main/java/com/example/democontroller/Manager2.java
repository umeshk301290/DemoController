package com.example.democontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="man2")
public class Manager2 extends Manager{

	Manager2(@Value("${value.id}")String id, @Value("${value.name}")String name) {
		super(id, name);
	}
	
	

}
package com.example.democontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="man1")
public class Manager1 extends Manager{

	Manager1(@Value("${value.id}")String id, @Value("${value.name}")String name) {
		super(id, name);
	}
	
	

}

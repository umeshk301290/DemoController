package com.example.democontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	Manager manager1;
	Manager manager2;
	
	@Autowired	
	Employee(@Qualifier(value="man2") Manager man1,@Qualifier(value="man1") Manager man2){
		this.manager1=man1;
		this.manager2=man2;
	}
	
	
	
	public void getdetails() {
		System.out.println(manager1);
		System.out.println(manager1.id);
		System.out.println(manager1.name);
		System.out.println(manager2);
		System.out.println(manager2.id);
		System.out.println(manager2.name);

	}
	
	

}

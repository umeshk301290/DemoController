package com.example.democontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
	
@Autowired
Animal animal;

@Lookup
public Animal getAnimal() {
	return animal;
}

public void setAnimal(Animal animal) {
	this.animal = animal;
}

public void getdata() {
	animal=this.getAnimalBean(6,"7@");
	System.out.println(animal);
	System.out.println(animal.password);
	System.out.println(animal.id);
}

@Lookup
public Animal getAnimalBean(Integer id,String Password) {
	// TODO Auto-generated method stub
	System.out.println("in lookup");
	return null;
	
}

@Cacheable(value="animalCache",key="#id",condition="#id<4")
public List<Animal> getAnimaldata(Integer id) {
	// TODO Auto-generated method stub
	System.out.println("going to call db");
	List<Animal> li = new ArrayList();
	Animal a = new Animal(id,"4@"); 
	Animal b = new Animal(1,"6!");
	li.add(a);
	li.add(b);
	System.out.println("list is "+li);
	return li;
}

@CacheEvict(value="animalCache")
public void evictCache() {
	System.out.println();
	
}

@CachePut(value="animalCache",key="#id",condition="#id<4")
public List<Animal> getAnimaldataput(Integer id) {
	// TODO Auto-generated method stub
	System.out.println("put method is called");
	System.out.println("going to call db");
	List<Animal> li = new ArrayList();
	Animal c = new Animal(id,"8@"); 
	Animal d = new Animal(1,"9!");
	li.add(c);
	li.add(d);
	System.out.println("list is "+li);
	return li;
}
}








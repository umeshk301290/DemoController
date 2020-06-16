package com.example.democontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
	
	@Autowired
	Employee emp;
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	AnimalService service;
	
	@Value("${value.data}")
	String data;
	
	@GetMapping(value="/get/bean")
	public void getbean() {
		service.getdata();
	}

	@GetMapping(value="/get/cache")
	public List<Animal> getCache() {
		List<Animal> a = service.getAnimaldata(1);
		return a;
	}
	
	@GetMapping(value="/get/cache/put")
	public List<Animal> getCachePut() {
		List<Animal> a = service.getAnimaldataput(2);
		return a;
	}
	
	@GetMapping(value="/get/evict")
	public void evictCache() {
		service.evictCache();
	}

	
	@GetMapping(value="/get")
	public String getdetails() {
		Person p = new Person(10, "ram");
		Map<String,String> hm = new HashMap();
		hm.put("id", "10");
		String url = "http://localhost:8095/get/{id}?name='radha'";
		HttpEntity entity=new HttpEntity(p);
		 ResponseEntity<String> str=template.exchange(url, HttpMethod.PATCH, entity,String.class,hm);
		 
		return "hello google";
		
		
	}
	
	@PatchMapping(value="/get/{id}")
	public String getdetails(@PathVariable Map<String,String> hm,@RequestParam("name") String name,@RequestBody Person man) {
    String id = hm.get("id");
    return id;
		
	}
	

}
package com.akash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.service.DeptService;

@RestController
@RequestMapping("/department")
@RefreshScope
public class DepartmentApi
{
	@Autowired
	DeptService serv;
	
	@Value("${spring.jpa.show-sql}")
	private String modProp;
	
	@GetMapping(value="/{name}")
	public ResponseEntity<Boolean> getDeptDetails(@PathVariable String name) 
	{
		System.out.println(modProp);
		Boolean ans=serv.checkDetails(name);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	
}

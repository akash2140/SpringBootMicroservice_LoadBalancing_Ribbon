package com.akash.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.akash.dto.EmployeeDTO;


@RestController
@RequestMapping("/calling")
@RibbonClient(name="custribbon")
public class CallingApi 
{
	@Autowired
	RestTemplate template;
	
	@GetMapping(value="/{deptName}")
	public ResponseEntity<List<EmployeeDTO>> getEmployeeData(@PathVariable String deptName)
	{
		String url="http://custribbon/employees/"+deptName;
		@SuppressWarnings("unchecked")
		List<EmployeeDTO> dtoList=template.getForObject(url,List.class);
		
		return new ResponseEntity<>(dtoList,HttpStatus.OK);
	}
	
	
}

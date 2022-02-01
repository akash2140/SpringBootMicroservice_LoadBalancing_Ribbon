package com.akash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.dto.EmployeeDTO;
import com.akash.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@RefreshScope
public class EmployeeApi 
{
	@Autowired
	EmployeeService serv;
	
	@GetMapping(value="/{deptName}")
	public ResponseEntity<List<EmployeeDTO > > getEmployee(@PathVariable String deptName)
	{
		List<EmployeeDTO> dtoList = serv.getEmployeeByDeptName(deptName);
		return new ResponseEntity<List<EmployeeDTO>>(dtoList,HttpStatus.OK);
	}
		
	
}

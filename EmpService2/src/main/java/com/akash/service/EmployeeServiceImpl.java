package com.akash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akash.dto.EmployeeDTO;
import com.akash.entity.Employee;
import com.akash.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	EmployeeRepository repo;
	
	RestTemplate template=new RestTemplate();
	
	@Override
	public List<EmployeeDTO> getEmployeeByDeptName(String deptName)
	{
		// TODO Auto-generated method stub
		
		//check whether the deptName is valid or not using rest call
		System.out.println("From Emp service ");
		String url="http://localhost:3334/department/"+deptName;
		boolean validDept=template.getForObject(url, Boolean.class);
		
		System.out.println("Response from Department Service "+ validDept);
		
		if(validDept) {
		List<Employee> empl=repo.getEmployees(deptName);
		List<EmployeeDTO> dtoList=new ArrayList<>();
		empl.forEach((employee)->{
			EmployeeDTO dto=new EmployeeDTO();
			dto.setAge(employee.getAge());
			dto.setDeptName(employee.getDeptName());
			dto.setEmpId(employee.getEmployeeId());
			dto.setEmpName(employee.getEmpName());
			dtoList.add(dto);
		});
		return dtoList;
		}
		else
			return List.of();
	}
	
}

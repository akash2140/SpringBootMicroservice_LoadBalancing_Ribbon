package com.akash.service;

import java.util.List;

import com.akash.dto.EmployeeDTO;
import com.akash.entity.Employee;

public interface EmployeeService 
{
	List<EmployeeDTO> getEmployeeByDeptName(String deptName);
}

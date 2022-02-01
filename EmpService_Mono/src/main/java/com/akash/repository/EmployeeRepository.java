package com.akash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.akash.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{
	
	@Query(value="select c from Employee c where c.deptName= :deptName")
	List<Employee> getEmployees(@Param("deptName") String deptName);
	
}

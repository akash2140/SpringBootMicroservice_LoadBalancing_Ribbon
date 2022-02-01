package com.akash.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee 
{
	@Id
	private Integer empId;
	private String empName;
	private String deptName;
	private Integer age;
	public Integer getEmployeeId() {
		return empId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.empId = employeeId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + empId + ", empName=" + empName + ", deptName=" + deptName + ", age=" + age
				+ "]";
	}
	
	
	
}

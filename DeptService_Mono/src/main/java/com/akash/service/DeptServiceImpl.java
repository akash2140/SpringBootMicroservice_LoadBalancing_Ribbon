package com.akash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.entity.Department;
import com.akash.repository.DeptRepository;

@Service
public class DeptServiceImpl implements DeptService
{

	@Autowired
	private DeptRepository repo;
	
	@Override
	public Boolean checkDetails(String name) {
		// TODO Auto-generated method stub
		Department department=repo.getDetails(name);
		if(department!=null)
			return true;
		
		return false;
	}
	
}

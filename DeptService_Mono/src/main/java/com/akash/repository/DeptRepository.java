package com.akash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.akash.entity.Department;

public interface DeptRepository extends CrudRepository<Department, Integer> 
{
	@Query(value="select d from Department d where d.name = :name")
	Department getDetails(@Param("name") String name);
}

package com.brt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brt.model.EmployeeDtl;


@Repository
public interface EmployeeDtlRepository extends JpaRepository<EmployeeDtl, Integer>{
	

}

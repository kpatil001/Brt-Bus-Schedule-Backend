package com.brt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brt.model.LoginDtls;



public interface LoginDtlsRepository extends CrudRepository<LoginDtls, Integer> {

	LoginDtls findByEmail(String email);
}

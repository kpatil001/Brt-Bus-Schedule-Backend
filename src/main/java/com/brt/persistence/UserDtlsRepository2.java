package com.brt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brt.model.UserDtls;


@Repository
public interface UserDtlsRepository2 extends JpaRepository<UserDtls, Integer> {

}

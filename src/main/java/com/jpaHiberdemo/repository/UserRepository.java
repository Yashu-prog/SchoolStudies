package com.jpaHiberdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpaHiberdemo.bean.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer>{

}

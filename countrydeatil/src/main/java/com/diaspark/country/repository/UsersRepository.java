package com.diaspark.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diaspark.country.entity.UserEntity;
@Repository
public interface UsersRepository extends JpaRepository<UserEntity,Long>{

	UserEntity findUserDAOByUserName(String userName);
}

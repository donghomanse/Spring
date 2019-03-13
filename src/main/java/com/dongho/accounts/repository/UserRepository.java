package com.dongho.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dongho.accounts.entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
	UserInfo findByUsername(String username);
}

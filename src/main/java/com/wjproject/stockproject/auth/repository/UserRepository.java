package com.wjproject.stockproject.auth.repository;

import com.wjproject.stockproject.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
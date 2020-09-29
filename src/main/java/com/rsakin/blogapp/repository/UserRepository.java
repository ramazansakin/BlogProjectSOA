package com.rsakin.blogapp.repository;

import com.rsakin.blogapp.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends IGenericRepository<User, Long> {
    User findByUsername(String username);
}

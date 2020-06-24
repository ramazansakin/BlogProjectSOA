package com.sakinramzan.blogapp.repository;

import com.sakinramzan.blogapp.entity.User;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends IGenericRepository<User, Long> {
    User findByUsername(String username);
}

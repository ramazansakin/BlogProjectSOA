package com.sakinramzan.blogapp.repository;

import com.sakinramzan.blogapp.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenericRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}

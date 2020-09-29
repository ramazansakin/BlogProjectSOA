package com.sakinramzan.blogapp.service;

import com.sakinramzan.blogapp.exception.NotFoundException;

import java.util.List;

public interface IGenericService<T> {
    List<T> findAll();

    T save(T entity);

    T findById(long id) throws NotFoundException;

    void delete(T entity);

    boolean deleteById(long id) throws NotFoundException;

    long count();
}

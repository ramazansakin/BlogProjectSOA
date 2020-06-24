package com.sakinramzan.blogapp.service;

import java.util.List;

public interface IGenericService<T> {
    List<T> findAll();

    T save(T entity);

    T findById(long id) throws Throwable;

    void delete(T entity);

    boolean deleteById(long id) throws Throwable;

    long count();
}

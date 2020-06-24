package com.sakinramzan.blogapp.service;

import com.sakinramzan.blogapp.exception.NotFoundException;
import com.sakinramzan.blogapp.repository.IGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractGenericService<T> implements IGenericService<T> {

    private final IGenericRepository<T, Long> repository;

    @Autowired
    protected AbstractGenericService(IGenericRepository<T, Long> repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T save(T entity) {
        return (T) repository.save(entity);
    }

    public T findById(long id) throws Throwable {
        return (T) repository.findById(id).orElseThrow(() -> new NotFoundException("" + id));
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

    public boolean deleteById(long id) throws Throwable {
        findById(id);
        repository.deleteById(id);
        return true;
    }

    public long count() {
        return repository.findAll().size();
    }


}

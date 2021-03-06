package com.rsakin.blogapp.service;

import com.rsakin.blogapp.exception.NotFoundException;
import com.rsakin.blogapp.repository.IGenericRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractGenericService<T> implements IGenericService<T> {

    private final IGenericRepository<T, Long> repository;

    public List<T> findAll() {
        return repository.findAll();
    }

    public T save(T entity) {
        return (T) repository.save(entity);
    }

    public T findById(long id) throws NotFoundException {
        return (T) repository.findById(id).orElseThrow(() -> new NotFoundException("" + id));
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

    public boolean deleteById(long id) throws NotFoundException {
        findById(id);
        repository.deleteById(id);
        return true;
    }

    public long count() {
        return repository.findAll().size();
    }


}

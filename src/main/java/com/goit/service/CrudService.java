package com.goit.service;

import java.util.List;

public interface CrudService<T> {

    void create(T t);

    T getById(int id);

    T getById(String id);

    List<T> listAll();

    void update(T t);

    void delete(T t);

}

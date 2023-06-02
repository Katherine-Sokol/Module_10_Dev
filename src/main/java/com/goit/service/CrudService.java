package com.goit.service;

import java.util.List;

public interface CrudService<T> {

    void create(T t);
     T getById(int id);
    List <T> listAll();
    void deleteById(int id);

}

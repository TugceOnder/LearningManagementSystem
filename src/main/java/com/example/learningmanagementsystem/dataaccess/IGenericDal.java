package com.example.learningmanagementsystem.dataaccess;

import java.util.List;

public interface IGenericDal<T> {
    void insert(T t);
    void update(T t);
    void delete(T t);
    List<T> getList();
}

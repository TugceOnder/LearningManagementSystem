package com.example.learningmanagementsystem.service;

import java.util.List;

public interface IGenericService <T,UUID> {


        void TInsert(T t);
        void TDelete(T t);
        void TUpdate(T t);

        T TGetByID(int id);
        List<T> TGetList();

}

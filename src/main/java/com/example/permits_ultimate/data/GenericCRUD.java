package com.example.permits_ultimate.data;

import java.util.List;

public interface GenericCRUD<T, ID> {

    T save(T t);
    List<T> findAll();
    T findByUUID(ID id);
    boolean delete(ID id);


}
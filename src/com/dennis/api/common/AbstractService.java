package com.dennis.api.common;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {
    public abstract Messenger save(T t);
    public abstract List<T> findAll() throws SQLException;
    public abstract Optional<T> findById(Long id);
    public abstract Long count();
    public abstract Optional<T> getOne(String id);
    public abstract Messenger delete(T t);
    public abstract String deleteAll();
    public abstract Boolean existsById(Long id);


}
package com.progra4.proyecto1.utils.dao;

import java.util.List;

public interface DAO<K, V> {

    public List<V> listAll();

    public Boolean add(K id, V value);

    public V retrieve(K id);

    public Boolean update(K id, V value);

    public Boolean delete(K id);

}
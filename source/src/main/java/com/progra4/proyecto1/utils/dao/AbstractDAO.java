package com.progra4.proyecto1.utils.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.progra4.proyecto1.utils.dao.crud.AbstractCRUD;
import com.progra4.proyecto1.utils.db.ProyectoDAO;

public abstract class AbstractDAO<K, V> extends ProyectoDAO implements DAO<K, V> {

    public AbstractDAO(AbstractCRUD crud) {
        this.crud = crud;
    }

    @Override
    public List<V> listAll(){
        List<V> r = new ArrayList<>();
        ResultSet rs = executeQuery(getCRUD().getListAllCmd(), new ArrayList<>());
        try{
            while (rs.next()) {
                r.add(getRecord(rs));
            }
        }
        catch(SQLException ex){
            System.err.println("Error: " + ex.getLocalizedMessage());
        }
        
        return r;
    }

    @Override
    public Boolean add(K id, V value) {
        return executeUpdate(getCRUD().getAddCmd(), getAddParameters(id, value));
    }

    @Override
    public V retrieve(K id) {
        List<Object> params = new ArrayList<>();
        params.add(id);
        ResultSet rs = executeQuery(getCRUD().getRetrieveCmd(), params);
        try {
            return rs.next() ? getRecord(rs) : null;
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public Boolean update(K id, V value) {
        return executeUpdate(getCRUD().getUpdateCmd(), getUpdateParameters(id, value));
    }

    @Override
    public Boolean delete(K id) {
        List<Object> params = new ArrayList<>();
        params.add(id);
        return executeUpdate(getCRUD().getDeleteCmd(), params);
    }

    public abstract V getRecord(ResultSet rs);

    public abstract List<Object> getAddParameters(K id, V value);

    public abstract List<Object> getUpdateParameters(K id, V value);

    public AbstractCRUD getCRUD() {
        return crud;
    }

    private final AbstractCRUD crud;

}
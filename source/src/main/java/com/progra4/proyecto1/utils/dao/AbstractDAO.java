package com.progra4.proyecto1.utils.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.progra4.proyecto1.utils.dao.crud.AbstractCRUD;
import com.progra4.proyecto1.utils.db.ProyectoDAO;

public abstract class AbstractDAO<K, V> extends ProyectoDAO implements DAO<K, V> {

    public AbstractDAO(AbstractCRUD crud) {
        this.crud = crud;
    }

    @Override
    public List<V> listAll(){
        List<V> vec = new ArrayList<>();
        List<Map<String, Object>> rs = executeQuery(getCRUD().getListAllCmd(), new ArrayList<>());
        try{
            if(rs != null){
                for (Map<String,Object> val : rs) {
                    vec.add(getRecord(val));
                }
            }
        }
        catch(Exception ex){
            System.err.println("Error: " + ex.getLocalizedMessage());
        }
        
        return vec;
    }

    @Override
    public Boolean add(K id, V value) {
        return executeUpdate(getCRUD().getAddCmd(), getAddParameters(id, value));
    }

    @Override
    public V retrieve(K id) {
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<Map<String, Object>> res = executeQuery(getCRUD().getRetrieveCmd(), params);
        try {
            return res != null && res.size() > 0 ? getRecord(res.get(0)): null;
        } catch (Exception ex) {
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

    public abstract V getRecord(Map<String, Object> rs);

    public abstract List<Object> getAddParameters(K id, V value);

    public abstract List<Object> getUpdateParameters(K id, V value);

    public AbstractCRUD getCRUD() {
        return crud;
    }

    private final AbstractCRUD crud;

}
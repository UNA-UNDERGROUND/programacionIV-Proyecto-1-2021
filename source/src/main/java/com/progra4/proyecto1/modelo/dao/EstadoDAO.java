package com.progra4.proyecto1.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.progra4.proyecto1.modelo.beans.Estado;
import com.progra4.proyecto1.modelo.dao.CRUD.EstadoCRUD;
import com.progra4.proyecto1.utils.dao.AbstractDAO;

public class EstadoDAO extends AbstractDAO<Integer, Estado> {

    public EstadoDAO(){
        super(new EstadoCRUD());
    }

    @Override
    public Estado getRecord(Map<String, Object> val) {
        try {
            return new Estado(
                    (Integer)val.get("id_estado"),
                    (String)val.get("descripcion")
            );
        } catch (Exception e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Object> getAddParameters(Integer id, Estado estado) {
        List<Object> params = new ArrayList<>();
        params.add(id);
        params.add(estado.getDescripcion());
        return params;
    }

    @Override
    public List<Object> getUpdateParameters(Integer id, Estado estado) {
        List<Object> params = new ArrayList<>();
        params.add(estado.getId_estado());
        params.add(estado.getDescripcion());
        params.add(id);
        return params;
    }

}

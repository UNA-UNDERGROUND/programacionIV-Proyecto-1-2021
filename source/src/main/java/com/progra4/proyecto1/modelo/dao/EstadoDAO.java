package com.progra4.proyecto1.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.progra4.proyecto1.modelo.beans.Estado;
import com.progra4.proyecto1.modelo.dao.CRUD.EstadoCRUD;
import com.progra4.proyecto1.utils.dao.AbstractDAO;

public class EstadoDAO extends AbstractDAO<Integer, Estado> {

    public EstadoDAO(){
        super(new EstadoCRUD());
    }

    @Override
    public Estado getRecord(ResultSet rs) {
        try {
            return new Estado(
                    rs.getInt("id_estado"),
                    rs.getString("descripcion")
            );
        } catch (SQLException e) {
            System.err.println("Error: " + e.getLocalizedMessage());
            e.printStackTrace();
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

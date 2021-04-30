package com.progra4.proyecto1.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.progra4.proyecto1.modelo.beans.Administrador;
import com.progra4.proyecto1.modelo.dao.CRUD.AdministradorCRUD;
import com.progra4.proyecto1.utils.dao.AbstractDAO;

public class AdministradorDAO extends AbstractDAO<Integer, Administrador> {
    
    public AdministradorDAO(){
        super(new AdministradorCRUD());
    }

    @Override
    public Administrador getRecord(Map<String, Object> val) {
        try {
            return new Administrador(
					(Integer)val.get("id_administrador"),
					(String)val.get("usuario_id"),
					(String)val.get("apellido1"),
					(String)val.get("apellido2"),
					(String)val.get("nombre"),
					(String)val.get("telefono"),
					(String)val.get("e_mail")
            );
        } catch (Exception e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Object> getAddParameters(Integer id, Administrador estado) {
        List<Object> params = new ArrayList<>();
        params.add(id);
        params.add(estado.getUsuarioId());
        params.add(estado.getApellido1());
        params.add(estado.getApellido2());
        params.add(estado.getNombre());
        params.add(estado.getTelefono());
        params.add(estado.getEMail());
        return params;
    }

    @Override
    public List<Object> getUpdateParameters(Integer id, Administrador estado) {
        List<Object> params = new ArrayList<>();
		params.add(estado.getIdAdministrador());
        params.add(estado.getUsuarioId());
        params.add(estado.getApellido1());
        params.add(estado.getApellido2());
        params.add(estado.getNombre());
        params.add(estado.getTelefono());
        params.add(estado.getEMail());
        params.add(id);
        return params;
    }
}

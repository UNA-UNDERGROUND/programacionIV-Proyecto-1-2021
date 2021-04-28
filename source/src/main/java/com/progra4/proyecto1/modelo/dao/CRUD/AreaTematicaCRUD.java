package com.progra4.proyecto1.modelo.dao.CRUD;

import com.progra4.proyecto1.utils.dao.crud.AbstractCRUD;

public class AreaTematicaCRUD extends AbstractCRUD{
    @Override
    public String getListAllCmd() {
        return LIST_CMD;
    }

    @Override
    public String getAddCmd() {
        return ADD_CMD;
    }

    @Override
    public String getRetrieveCmd() {
        return RETRIEVE_CMD;
    }

    @Override
    public String getUpdateCmd() {
        return UPDATE_CMD;
    }

    @Override
    public String getDeleteCmd() {
        return DELETE_CMD;
    }

	protected static final String PARAMS_LIST 
		= "id_area, descripcion ";
    protected static final String TABLE_NAME
        = "area_tematica ";
    protected static final String ID_FIELD
        = "id_area ";
	protected static final String UPDATE_PARAMS
        = "id_area = ?, descripcion = ? ";
    protected static final String VALUES_STRING
        = "?, ? ";

	protected static final String LIST_CMD
		= "SELECT "
		+ PARAMS_LIST
		+ "FROM eif209_2021_01." + TABLE_NAME + " ORDER BY " + ID_FIELD +"; ";
	protected static final String ADD_CMD
		= "INSERT INTO eif209_2021_01." + TABLE_NAME
		+ "(" + PARAMS_LIST + ") "
		+ "VALUES (" + VALUES_STRING + "); ";
	protected static final String RETRIEVE_CMD
		= "SELECT "
		+ PARAMS_LIST
		+ "FROM eif209_2021_01." + TABLE_NAME + " WHERE " + ID_FIELD + " = ?; ";
	protected static final String UPDATE_CMD
		= "UPDATE eif209_2021_01." + TABLE_NAME 
		+ "SET " + UPDATE_PARAMS + " "
		+ "WHERE " + ID_FIELD +" = ?; ";
	protected static final String DELETE_CMD
		= "DELETE FROM eif209_2021_01." + TABLE_NAME
		+ "WHERE " + ID_FIELD +" = ?; ";
}

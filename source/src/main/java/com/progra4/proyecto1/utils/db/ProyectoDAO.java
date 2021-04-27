package com.progra4.proyecto1.utils.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jonathan Guzman
 */
public class ProyectoDAO {

    // <editor-fold desc="Metodos de generales" defaultstate="collapsed">
    private void setParameters(PreparedStatement stm, List<Object> params) {
        try {
            stm.clearParameters();
            for (int i = 0; i < params.size(); i++) {
                Object obj = params.get(i);
                if (obj instanceof Integer)
                    stm.setInt(i + 1, (Integer) obj);
                if (obj instanceof String)
                    stm.setString(i + 1, (String) obj);
                if (obj instanceof Boolean)
                    stm.setBoolean(i + 1, (Boolean) obj);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("error al establecer los parametros: " + ex.getLocalizedMessage(),
                    ex.getCause());
        }
    }

    protected Boolean executeUpdate(String comando, List<Object> params) {
        try (Connection cnx = obtenerConexion(); PreparedStatement stm = cnx.prepareStatement(comando)) {
            setParameters(stm, params);
            return stm.executeUpdate() == 1;
        } catch (Exception ex) {
            System.err.printf("No se pudo insertar un cliente nuevo: %s \n", ex.getMessage());
        }
        return false;
    }

    protected List<Map<String, Object>> executeQuery(String comando, List<Object> params) {
        try (Connection cnx = obtenerConexion(); PreparedStatement stm = cnx.prepareStatement(comando)) {
            setParameters(stm, params);
            try (ResultSet rs = stm.executeQuery()) {

                List<Map<String, Object>> lista = new ArrayList<>();
                if (rs != null) {
                    ResultSetMetaData md = rs.getMetaData();
                    int columnas = md.getColumnCount();
                    Map<String, Object> row = new HashMap<>(columnas);
                    while (rs.next()) {
                        for (int i = 1; i <= columnas; ++i) {
                            row.put(md.getColumnName(i), rs.getObject(i));
                        }
                    }
                    lista.add(row);
                }
                return lista;
            } catch (Exception ex) {
                System.err.println(ex.getLocalizedMessage());
            }
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
        }
        return null;
    }

    protected Connection obtenerConexion() {
        return GestorConexion.obtenerInstancia().obtenerConexion();
    }
    // </editor-fold>

}
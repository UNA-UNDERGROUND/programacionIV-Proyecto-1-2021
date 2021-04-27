package com.progra4.proyecto1.utils.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    protected ResultSet executeQuery(String comando, List<Object> params){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(comando)) {
            setParameters(stm, params);
            try (ResultSet rs = stm.executeQuery()) {
                return rs;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } catch (Exception ex) {
            String error = ex.getLocalizedMessage();
            System.err.println(error);
        }
        return null;
    }

    protected Connection obtenerConexion() {
        return GestorConexion.obtenerInstancia().obtenerConexion();
    }
    // </editor-fold>

}
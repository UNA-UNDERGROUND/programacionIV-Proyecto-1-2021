package com.progra4.proyecto1.db;


import java.sql.Connection;

/**
 *
 * @author Jonathan Guzman
 */
public class ProyectoDAO {

    //<editor-fold desc="Metodos de generales" defaultstate="collapsed">
    protected Connection obtenerConexion() {
        return GestorConexion.obtenerInstancia().obtenerConexion();
    }
    //</editor-fold>

}
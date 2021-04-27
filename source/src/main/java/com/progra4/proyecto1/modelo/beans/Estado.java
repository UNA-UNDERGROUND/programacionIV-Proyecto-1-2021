package com.progra4.proyecto1.modelo.beans;

public class Estado {
    private Integer id_estado;
    private String descripcion;

    public Estado(){

    }
    
    public Estado(Integer id, String descripcion){
        this.setId_estado(id);
        this.setDescripcion(descripcion);
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getId_estado() {
        return id_estado;
    }
    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }
}

package com.progra4.proyecto1;




/**
 *
 * @author Jonathan Guzman
 */
public class Controlador {

    private Controlador() {

    }

    


    private static Controlador instancia;

    public static Controlador getInstancia() {
        return instancia == null ? instancia = new Controlador() : instancia;
    }
    

    public void reiniciarBD(){
        
    }
}
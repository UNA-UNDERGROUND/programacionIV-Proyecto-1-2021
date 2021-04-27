package com.progra4.proyecto1.DAO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.progra4.proyecto1.Controlador;
import com.progra4.proyecto1.modelo.beans.Estado;
import com.progra4.proyecto1.modelo.dao.EstadoDAO;

public class TestEstadoDAO {
	Controlador controlador = Controlador.getInstancia();

	@Test
	public void agregarEstadoTest() {
		Boolean exitoso = false;
		Estado e = new Estado(1, "Estado de prueba");
		exitoso = new EstadoDAO().add(1, e);
		assertEquals(exitoso, true);
	}

	// Usuario creds = new Usuario(208010443, "asdf1234", false);
	// Cuenta origen = controlador.recuperarCuenta(1);
	//
	// boolean res = controlador.agregarTransferencia(origen,2, new
	// BigDecimal("1000"),"Prueba Limite Transferencia(Backend)",creds);
	//
	// if(res){
	// System.out.println("exitoso");
	// }
	// else{
	// System.out.println("fallido");
	// }

}

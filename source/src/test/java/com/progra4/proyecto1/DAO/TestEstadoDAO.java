package com.progra4.proyecto1.DAO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.progra4.proyecto1.modelo.beans.Estado;
import com.progra4.proyecto1.modelo.dao.EstadoDAO;

public class TestEstadoDAO {
	EstadoDAO dao = new EstadoDAO();
	Estado e1 = new Estado(-1, "Estado de prueba");
	Estado e2 = new Estado(-2, "Estado de prueba");
	Estado e3 = new Estado(-2, "Estado de prueba");

	@Test
	public void agregarEstadoTest() {
		Boolean exitoso = false;
		exitoso = dao.add(-1, e1);
		dao.delete(-1);
		assertTrue(exitoso);
	}

	@Test
	public void listarEstados() {
		dao.add(-2, new Estado(-2, "Estado de prueba"));
		int conteo = dao.listAll().size();
		dao.delete(-2);
		assertTrue(conteo > 0);
	}

	@Test
	public void recuperarEstadoTest() {
		dao.add(-3, new Estado(-3, "Estado de prueba"));
		Estado val = dao.retrieve(-3);
		dao.delete(-3);
		assertNotEquals(val, null);
	}

	@Test
	public void actualizarEstadoTest() {
		Estado val = new Estado(-5, "actualizado");
		dao.add(-4, val);
		dao.update(-4, val);
		val = dao.retrieve(-5);
		dao.delete(-5);
		assertTrue(!val.equals(null) && val.getDescripcion().equals("actualizado"));
	}

	@Test
	public void eliminarEstadoTest() {
		Boolean exitoso = false;
		dao.add(-6, new Estado(-6, "actualizado"));
		exitoso = dao.delete(-6);
		assertTrue(exitoso);
	}
}

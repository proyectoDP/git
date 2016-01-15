package flappyBirdTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import flappyBird.BD;

public class BDTest {
	String nombre = "nombre";
	int puntuacion=5;
	BD testBD = new BD();
	@Test
	public void testCrear() {
		testBD = new BD();
		try {
			testBD.CrearTabla(nombre, puntuacion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testRank()
	{
		testBD = new BD();
		testBD.Puntuaciones();
		
	}

}

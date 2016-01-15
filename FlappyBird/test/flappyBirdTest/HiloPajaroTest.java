package flappyBirdTest;

import static org.junit.Assert.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.Test;

import flappyBird.HiloPajaro;



public class HiloPajaroTest {

	@Test
	public void test() {
int limiteArriba=5;
		
		int posx=100;
		
		JPanel pajaro = null;
		
		int suelo=5;
		
		int controlador=1;
		int control =1;
		HiloPajaro HP = new HiloPajaro(posx, limiteArriba, pajaro, suelo, controlador, control);
	}

}

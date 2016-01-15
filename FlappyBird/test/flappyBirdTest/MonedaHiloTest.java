package flappyBirdTest;

import static org.junit.Assert.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.Test;

import flappyBird.MonedaHilo;

public class MonedaHiloTest {

	@Test
	public void test() {
		int posx=100;
		int posy=20;
		JPanel moneda = null;
		MonedaHilo mh = new MonedaHilo(posx, posy, moneda);
	}

}

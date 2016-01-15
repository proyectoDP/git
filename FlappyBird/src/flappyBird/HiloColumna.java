package flappyBird;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HiloColumna extends Thread {
	
	int posx;
	
	int posy;
	
	JPanel columna;
	
public HiloColumna (int posx, int posy, JPanel columna) 
	
	{
	
		this.posx = posx;
		this.columna = columna;
		this.posy = posy;
		
	}

	public void run ()
	
	{
		
		while (true)
			
		{
			
			
			try 
			
			{
				
				Thread.sleep(2);
				columna.setLocation(posx, posy);
				posx --;
					
			} catch (InterruptedException e) 
			
			{
			
					// TODO Auto-generated catch block
					e.printStackTrace();

			}
			
		}
				
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public JPanel getColumna() {
		return columna;
	}

	public void setColumna(JPanel columna) {
		this.columna = columna;
	}
		
}

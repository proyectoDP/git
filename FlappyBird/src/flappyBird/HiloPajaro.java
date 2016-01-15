package flappyBird;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HiloPajaro extends Thread

{

	int limiteArriba;
	
	int posx;
	
	JPanel pajaro;
	
	int suelo;
	
	int controlador;
	
	int control;
	
	
	public HiloPajaro (int posx, int limiteArriba, JPanel pajaro, int suelo, int controlador, int control) 
	
	{
		
		this.limiteArriba = limiteArriba;
		this.posx = posx;
		this.pajaro = pajaro;
		this.suelo = suelo;
		this.controlador = controlador;
		this.control = control;
		
	}

	public void run ()
	
	{
		
		int n;
		
		while (true)
			
		{
			
			if (controlador ==0)
				
			{
				
			try 
			
			{
				
				if (control ==0)
					
				{
				
					Thread.sleep(2);
					pajaro.setLocation(posx,limiteArriba);
					limiteArriba++;
					//System.out.println("PAJARO BAJA");
				
				}
				
				if (control ==1)
					
				{
					
					Thread.sleep(1,8);
					pajaro.setLocation(posx,limiteArriba);
					limiteArriba++;
					//System.out.println("PAJARO BAJA");
					
					
				}
					
			} catch (InterruptedException e) 
			
			{
			
					// TODO Auto-generated catch block
					e.printStackTrace();

			}
			
			if (controlador ==1)
			
			{
				
			try
			
			{
				
				{
					for (n =0; n <70; n++)
					
					{
						
					Thread.sleep(1);
					pajaro.setLocation(posx,limiteArriba);
					limiteArriba--;
					//System.out.println("PAJARO SUBE");
					controlador =0;
					
					}
			
					n =0;
					
				}
				
			}
			
			catch (InterruptedException e) 
			
			{
			
					// TODO Auto-generated catch block
					e.printStackTrace();

			}
			
			}
			
			if  (suelo == limiteArriba)
				
			{
				
				stop();
				
			}
			
			}
			
		}
		
	}

	public int getLimiteArriba() {
		return limiteArriba;
	}

	public void setLimiteArriba(int limiteArriba) {
		this.limiteArriba = limiteArriba;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	/*public JLabel getPajaro() {
		return pajaro;
	}*/

	/*public void setPajaro(JLabel pajaro) {
		this.pajaro = pajaro;
	}*/

	public int getControlador() {
		return controlador;
	}

	public void setControlador(int controlador) {
		this.controlador = controlador;
	}
	
	
}

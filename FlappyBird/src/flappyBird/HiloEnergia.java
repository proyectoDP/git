package flappyBird;
	
	import java.awt.Graphics;
	import java.util.Random;

	import javax.swing.JLabel;
	import javax.swing.JPanel;

	public class HiloEnergia extends Thread {
		
		int posx;
		
		int posy;
		
		JPanel energia;
		
		int movimiento;
		
		int control;
		
		int control1;
		
	public HiloEnergia (int posx, int posy, JPanel energia, int movimiento, int control, int control1) 
		
		{
		
			this.posx = posx;
			this.energia = energia;
			this.posy = posy;
			this.movimiento = movimiento;
			this.control = control;
			this.control1 = control1;
			
		}

		public void run ()
		
		{
			
			while (true)
				
			{
				
				
				try 
				
				{
					
					
					if (movimiento ==0)
						
					{
					
					Thread.sleep(2);
					energia.setLocation(posx, posy);
					posx --;
					
					}
					
					if (movimiento ==1)
						
					{
						
					Thread.sleep(2);
					energia.setLocation(posx, posy);
					posx --;
					
					if (control ==0)
						
					{
						
						posy--;
						control1 --;
						
					}
					
					if (control ==1)
						
					{
						
						posy ++;
						control1 ++;
						
					}
					
					if (control1 ==-60)
						
					{
						
						control =1;
						
					}
					
					if (control1 ==60)
						
					{
						
						control =0;
						
					}
						
					}
						
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
			
}


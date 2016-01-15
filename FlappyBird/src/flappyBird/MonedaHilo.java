package flappyBird;
	
	import java.awt.Graphics;
	import java.util.Random;

	import javax.swing.JLabel;
	import javax.swing.JPanel;

	public class MonedaHilo extends Thread {
		
		int posx;
		
		int posy;
		
		JPanel moneda;
		
	public MonedaHilo (int posx, int posy, JPanel moneda) 
		
		{
		
			this.posx = posx;
			this.moneda = moneda;
			this.posy = posy;
			
		}

		public void run ()
		
		{
			
			while (true)
				
			{
				
				
				try 
				
				{
					
					Thread.sleep(2);
					moneda.setLocation(posx, posy);
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
			
}

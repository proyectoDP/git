package flappyBird;

import java.awt.BorderLayout;


import javax.swing.Timer;

import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	
public class VentanaJuego extends JFrame
	
{
	
	public JPanel contentPane;
	
	int posx;
	
	int posy;
	
	int posxc;
	
	int posyc;
	
	int controlador =0;
	
	HiloPajaro pajaroHilo;
	
	int suelo;
	
	public Timer timer;
	
	int posxm;
	
	int posym;
	
	int anchom;
	
	int altom;
	
	int posxe;
	
	int posye;
	
	int anchoe;

	int altoe;
	
	HiloColumna hiloCol;
	
	MonedaHilo hiloMon;
	
	JPanel moneda;
	
	JLabel lblMoneda;

	private int tiempoEnMilisegundos;
	
	int ancho;
	
	int alto;
	
	int control =0;
	
	Random rand;
	
	Random rand1;
	
	Random rand2;
	
	int valorAleatorio;
	
	int valorAleatorio1;
	
	int valorAleatorio2;
	
	int monedasRecogidas;
	
	int cont;
	
	int energia =100;
	
	int contE =0;
	
	HiloEnergia hiloEnerg;
	
	JLabel energ;
	
	JPanel energ1;
	
	JLabel contador;
	
	int controlE =0;
	
	Timer timer1;
	
	Timer timer2;
	
	Timer timer3;
	
	int paraE =1;
	
	int salio =0;
	
	BD bda = new BD ();
	
	int para =0;
	
	public VentanaJuego() throws InterruptedException
	
	
	{

		//Características ventana juego
		
		suelo = 580;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 800, 700);
		contentPane = new JPanel ();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel pajaro = new JPanel();
		pajaro.setBounds(380, 400, 30, 30);
		posx = 380;//Posicion x inicial
		posy = 200;
		pajaro.setBackground(Color.GREEN);
		contentPane.setLayout(null);
		contentPane.add(pajaro);
		pajaroHilo = new HiloPajaro (posx, posy, pajaro, suelo, controlador, 0);
		pajaroHilo.start();
		
		this.getContentPane().setBackground(Color.cyan);
		
		monedasRecogidas =0;
		
		// AÑADIR SUELO
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 587, 800, 91);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//AÑADIR BOTON SALTA
		JButton Salta = new JButton("SALTA");
		Salta.setBounds(355, 6, 84, 29);
		panel.add(Salta);
		
		//AÑADIR CONTADOR
		contador = new JLabel("MONEDAS: " + monedasRecogidas);
		contador.setBounds(360, 47, 157, 16);
		panel.add(contador);
		
		//AÑADIR TECHO
		JPanel techo = new JPanel();
		techo.setBackground(Color.GREEN);
		techo.setBounds(0, 0, 800, 16);
		contentPane.add(techo);
		
		//AÑADIR MARCADOR ENERGIA
		energ = new JLabel("ENERGIA: " + energia);
		energ.setBounds(100, 6, 157, 16);
		panel.add(energ);
	
		
		
		Salta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (controlE ==0)
					
				{
				
				controlador =1;
				pajaroHilo.setControlador(controlador);
				
				}
			
			}
		});
		
		posxc = 800;
		posyc = 353;
		ancho = 20;
		alto = 700;
		
		posxm = 1200;
		posym = 311;
		anchom = 20;
		altom = 20;
		
		posxe = 1000;
		posye = 400;
		anchoe = 20;
		altoe = 20;
		
		timer2 = new Timer (10000, new ActionListener () 
		
		{ 
		
	    public void actionPerformed(ActionEvent e) 
	    
	    {

	    	rand2 = new Random ();
	    	valorAleatorio2 = rand.nextInt(400) + 100;
	    	energ1 = new JPanel();
	    	energ1.setBounds(posxe, valorAleatorio2, anchoe, altoe);
	    	energ1.setBackground(Color.BLUE);
	    	contentPane.add(energ1);
	    	hiloEnerg = new HiloEnergia (posxe, valorAleatorio2, energ1, 0, 0, 0);
	    	hiloEnerg.start();
	    	
	    	timer3 = new Timer (0, new ActionListener () 
			{ 
	    		
	    		public void actionPerformed(ActionEvent e) 
			    
			    { 
	    			
	    			if (((hiloEnerg.getPosx()+30 >= pajaroHilo.getPosx()) && (hiloEnerg.getPosx()-30 < pajaroHilo.getPosx())  && ((pajaroHilo.limiteArriba <= valorAleatorio2+30) && (pajaroHilo.limiteArriba-2 >  valorAleatorio2-30))))
	    	
	    			{
	    		

	    				energ1.show(false);
	    				contE =1;
	    		
	    			}
	    	
			     } 
			
			}); 
			
		
		timer3.start();
		
	    }
	
	    }); 
	
		timer2.start();
		
		timer1 = new Timer (2000, new ActionListener () 
		{ 
			
		    public void actionPerformed(ActionEvent e) 
		    
		    { 
		    	
		    	if (paraE ==1)
		    	
		    	{

		    	energ.hide();
				energia = energia -5;
				energ = new JLabel("ENERGIA: " + energia);
				energ.setBounds(100, 6, 157, 16);
				panel.add(energ);
		    	
		    	}
		    	
		    	// "IF" PARA VOLVER A AÑADIR VALORES SOLO SI NO SE HA "CHOCADO" 
		    	if (control ==0)
		    		
		    	{
		    	
		    	// INICIAR VALORES RANDOM
		    	rand = new Random ();
		    	rand1 = new Random ();
		    	valorAleatorio = rand.nextInt(500) + 50;
		    	valorAleatorio1 = rand1.nextInt(400) + 100;
		    	
		    	// INICIAR COLUMNAS E HILO
		    	JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.GREEN);
				panel_1.setForeground(Color.GREEN);
				panel_1.setBounds(posxc, valorAleatorio1, ancho, alto);
				contentPane.add(panel_1);
		    	hiloCol = new HiloColumna (posxc, valorAleatorio1, panel_1);
				hiloCol.start();
				
				// AÑADIR MONEDA E HILO
				moneda = new JPanel();
				moneda.setBounds(posxm, valorAleatorio, anchom, altom);
				moneda.setBackground(Color.YELLOW);
				contentPane.add(moneda);
				hiloMon = new MonedaHilo (posxm, valorAleatorio, moneda);
				hiloMon.start();
				
		    	}
		    	
		    	
		    	if (cont ==1)
					
				{
		    		
		    		contador.hide();
					monedasRecogidas ++;
					contador = new JLabel("MONEDAS: " + monedasRecogidas);
					contador.setBounds(360, 47, 157, 16);
					panel.add(contador);
		    		//System.out.println("MONEDAS" + monedasRecogidas);
					cont =0;
					
				}
		    	
		    	if (contE ==1)
		    		
		    	{
		    		
		    		energ.hide();
					energia =100;
					System.out.println("Energia aumenta");
					energ = new JLabel("ENERGIA: " + energia);
					energ.setBounds(100, 6, 157, 16);
					panel.add(energ);
					contE =0;
		    		
		    	}
		    	
		    	if (paraE ==0)
		    		
		    	{
		    		
		    		if (para ==0)
		    		
		    		{
		    			
		    		System.out.println("CREA BASE DE DATOS");
		    		System.out.println(monedasRecogidas);
		    		VentanaUsuario ventaU = new VentanaUsuario ();
		    		ventaU.SetNombre(monedasRecogidas);
		    		ventaU.setVisible(true);
		    		para =1;
		    		dispose();
		    		
		    		}
		    		
		    	}

				timer = new Timer (0, new ActionListener () 
				{ 
					
				    public void actionPerformed(ActionEvent e) 
				    
				    { 
				    	
				    	if (((hiloCol.getPosx()+30 >= pajaroHilo.getPosx()) && (hiloCol.getPosx()-30 < pajaroHilo.getPosx())  && (pajaroHilo.limiteArriba > valorAleatorio1)))
							
						{
							

				    		hiloCol.stop();
							hiloMon.stop();
							pajaroHilo.stop();
							control =1;
							paraE =0;
							
						}
				    	
				    	if (((hiloMon.getPosx()+38 >= pajaroHilo.getPosx()) && (hiloMon.getPosx()-38 < pajaroHilo.getPosx())  && ((pajaroHilo.limiteArriba <= valorAleatorio+40) && (pajaroHilo.limiteArriba >  valorAleatorio-40))))
				    		
				    	{
				    		
				    		
				    		moneda.show(false);
				    		cont =1;
				    		
				    	}
				    	
				    	if (pajaroHilo.getLimiteArriba() < 5)
				    		
				    	{				    		
				    		

							hiloCol.stop();
							hiloMon.stop();
							pajaroHilo.stop();
							control =1;
							paraE =0;
				    		
				    	}
				    	
				    	if (energia ==0)
				    		
				    	{
				    		
				    		controlE =1;
				    		
				    	}
				    	
				     } 
				}); 
				
			
			timer.start();
		    
		    }
		}); 
		
		timer1.start();

	}
	
	//fIN Características ventana juego
	
}



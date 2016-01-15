package flappyBird;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class VentanaDificultad extends JFrame {

	private JPanel contentPane;
	
	BD based = new BD ();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDificultad frame = new VentanaDificultad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaDificultad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFacil = new JButton("FACIL");
		btnFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaJuego mijuego;
				try {
					mijuego = new VentanaJuego ();
					mijuego.setVisible(true);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				
			}
		});
		btnFacil.setBounds(29, 66, 117, 29);
		contentPane.add(btnFacil);
		
		JButton btnMedio = new JButton("MEDIO");
		btnMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaJuegoM mijuego;
				try {
					mijuego = new VentanaJuegoM ();
					mijuego.setVisible(true);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnMedio.setBounds(159, 66, 117, 29);
		contentPane.add(btnMedio);
		
		JButton btnNewButton = new JButton("DIFICIL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaJuegoD mijuego;
				try {
					mijuego = new VentanaJuegoD ();
					mijuego.setVisible(true);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();					
				}
				dispose();
			}
		});
		btnNewButton.setBounds(288, 66, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblDificultad = new JLabel("DIFICULTAD");
		lblDificultad.setBounds(180, 24, 83, 16);
		contentPane.add(lblDificultad);
	}

}

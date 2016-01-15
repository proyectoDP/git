package flappyBird;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String nombre;
	BD bda = new BD();
	int jugador;
	String nivel;
	Ventana V;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaUsuario frame = new VentanaUsuario();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VentanaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBounds(79, 42, 61, 16);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(152, 37, 205, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton botton = new JButton ("ENVIAR");
		botton.setBounds(79, 70, 61, 16);
		contentPane.add(botton);
		botton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			String nombre = textField.getText();
			System.out.println("-----");
			System.out.println(nombre);
			System.out.println(jugador);
			try {
				bda.CrearTabla(nombre, jugador);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		});
		contentPane.setLayout(null);
		
		JButton botton1 = new JButton ("RECORDS");
		botton1.setBounds(150, 70, 80, 16);
		contentPane.add(botton1);
		botton1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				bda.Puntuaciones();
			
			}
		});
	
	JButton botton2 = new JButton ("VOLVER A JUGAR");
	botton2.setBounds(250, 70, 150, 16);
	contentPane.add(botton2);
	botton2.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			VentanaDificultad ventanaD = new VentanaDificultad ();
			
			ventanaD.setVisible(true);
			
			setVisible(false);
		
		}
	});
	
	
}
	
	public void SetNombre (int jugador)
	
	{
		this.jugador = jugador;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
}

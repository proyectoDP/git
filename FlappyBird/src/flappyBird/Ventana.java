package flappyBird;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Ventana extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	
	
	JTextPane textPane;
	
	private JTextField textField;
//	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PUNTUACION");
		lblNewLabel.setBounds(201, 21, 100, 16);
		contentPane.add(lblNewLabel);
		
		textPane = new JTextPane();
		textPane.setBounds(21, 53, 406, 201);
		contentPane.add(textPane);
		
	}
	
	public void Anadir (String nombre, int puntuacion)
	
	{
		
		textPane.setText("NOMBRE: " + nombre + " PUNTUACION: " + puntuacion);
		
		
	}
}

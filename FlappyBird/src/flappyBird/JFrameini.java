package flappyBird;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameini extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JFrameini() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 151);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnjugar = new JButton("JUGAR!");
		btnjugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaDificultad vd = new VentanaDificultad();
				vd.setVisible(true);
				dispose();
				
			}
		});
		btnjugar.setBounds(163, 42, 117, 29);
		contentPane.add(btnjugar);
	}
}

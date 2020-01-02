package portal;

import portal.login.*;
import portal.register.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
//import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;

public class Home {

	private JFrame frame;
	
	private static Home window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Home();
					window.frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(-10, 0, 1650, 1080);
		frame.setTitle("Home | Exam Portal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToExam = new JLabel("Welcome to Exam Portal...");
		lblWelcomeToExam.setForeground(Color.ORANGE);
		lblWelcomeToExam.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblWelcomeToExam.setBounds(529, 133, 362, 65);
		frame.getContentPane().add(lblWelcomeToExam);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setForeground(Color.BLACK);
		btnLogIn.setBackground(Color.ORANGE);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(false);
				Login.main(null);
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogIn.setBounds(607, 287, 159, 50);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setBackground(Color.ORANGE);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(false);
				Register.main(null);
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegister.setBounds(607, 380, 159, 50);
		frame.getContentPane().add(btnRegister);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit ?", "Login", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBackground(Color.ORANGE);
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBounds(607, 473, 159, 50);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 236, 1350, 2);
		frame.getContentPane().add(separator);
	}
}

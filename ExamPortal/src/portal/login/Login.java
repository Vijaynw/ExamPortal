package portal.login;

import connection.MyConnectionProvider;
import portal.*;
import portal.exam.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;

public class Login {

	private JFrame frame;
	private JTextField txtPRN;
	private JPasswordField txtPassword;

	static Connection con;
	static Statement stmt;
	static PreparedStatement ps;

	private static Login window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					con = MyConnectionProvider.getcon();
					stmt = con.createStatement();
					window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(-10, 0, 1650, 1080);
		frame.setTitle("Log In| Exam Portal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Here...");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(554, 110, 200, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPRN = new JLabel("PRN No :");
		lblPRN.setForeground(Color.ORANGE);
		lblPRN.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPRN.setBounds(474, 256, 106, 23);
		frame.getContentPane().add(lblPRN);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.ORANGE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(474, 311, 106, 23);
		frame.getContentPane().add(lblPassword);
		
		txtPRN = new JTextField();
		txtPRN.setForeground(Color.DARK_GRAY);
		txtPRN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPRN.setBounds(624, 253, 200, 32);
		frame.getContentPane().add(txtPRN);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.DARK_GRAY);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBounds(624, 307, 200, 32);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.ORANGE);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = txtPRN.getText();
				@SuppressWarnings("deprecation")
				String password = txtPassword.getText();
				String usr = null;
				String pass = null;
				
				try {
					int flag = 0;
					
					String sql = "SELECT prn, password FROM users";
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						usr = rs.getString("prn");
						pass = rs.getString("password");
						if (username.contains(usr) && password.contains(pass)) {
							flag = 1;
							txtPRN.setText(null);
							txtPassword.setText(null);
							break;
						}
					}
					if(flag == 1) {
						JOptionPane.showMessageDialog(null, "Loged In as "+username, "Success", JOptionPane.INFORMATION_MESSAGE);
						if(JOptionPane.showConfirmDialog(frame, username+", Confirm if you want to Start Exam?", "Login",
								JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
							window.frame.setVisible(false);
							Portal.main(null);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1, "Login Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(474, 408, 89, 32);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.ORANGE);
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtPRN.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(609, 408, 89, 32);
		frame.getContentPane().add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.ORANGE);
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(false);
				Home.main(null);
			}
		});
		btnBack.setBounds(735, 408, 89, 32);
		frame.getContentPane().add(btnBack);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 373, 1350, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 214, 1350, 2);
		frame.getContentPane().add(separator);
	}
}

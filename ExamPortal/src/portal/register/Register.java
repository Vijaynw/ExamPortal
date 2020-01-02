package portal.register;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import connection.MyConnectionProvider;
import portal.Home;
import portal.login.*;

import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;

public class Register {

	private JFrame frame;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtPRN;
	private JLabel lblGender;
	private ButtonGroup genderGroup = new ButtonGroup();
	private JLabel lblEmailId;
	private JTextField txtEmail;
	private JLabel lblPassword;
	private JPasswordField txtPassword;

	static Connection con;
	static Statement stmt;
	static PreparedStatement ps;
	
	private static Register window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					con = MyConnectionProvider.getcon();
					stmt = con.createStatement();
					window = new Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(-10, 0, 1650, 1080);
		frame.setTitle("Register | Exam Portal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegisterHere = new JLabel("Register Here...");
		lblRegisterHere.setForeground(Color.ORANGE);
		lblRegisterHere.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRegisterHere.setBounds(519, 42, 234, 53);
		frame.getContentPane().add(lblRegisterHere);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setForeground(Color.ORANGE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstName.setBounds(468, 164, 96, 14);
		frame.getContentPane().add(lblFirstName);
		
		txtFName = new JTextField();
		txtFName.setForeground(Color.BLACK);
		txtFName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtFName.setBounds(611, 156, 179, 31);
		frame.getContentPane().add(txtFName);
		txtFName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setForeground(Color.ORANGE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastName.setBounds(468, 213, 96, 14);
		frame.getContentPane().add(lblLastName);
		
		txtLName = new JTextField();
		txtLName.setForeground(Color.BLACK);
		txtLName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLName.setBounds(611, 204, 179, 31);
		frame.getContentPane().add(txtLName);
		txtLName.setColumns(10);
		
		JLabel lblPrn = new JLabel("PRN :");
		lblPrn.setForeground(Color.ORANGE);
		lblPrn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrn.setBounds(468, 268, 96, 14);
		frame.getContentPane().add(lblPrn);
		
		txtPRN = new JTextField();
		txtPRN.setForeground(Color.BLACK);
		txtPRN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPRN.setText("");
		txtPRN.setBounds(611, 259, 179, 31);
		frame.getContentPane().add(txtPRN);
		txtPRN.setColumns(10);
		
		lblGender = new JLabel("Gender :");
		lblGender.setForeground(Color.ORANGE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(468, 323, 96, 14);
		frame.getContentPane().add(lblGender);
		
		JRadioButton rdbtMale = new JRadioButton("Male");
		rdbtMale.setBackground(Color.DARK_GRAY);
		rdbtMale.setForeground(Color.ORANGE);
		rdbtMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtMale.setBounds(611, 319, 75, 23);
		frame.getContentPane().add(rdbtMale);
		genderGroup.add(rdbtMale);
		
		JRadioButton rdbtFemale = new JRadioButton("Female");
		rdbtFemale.setBackground(Color.DARK_GRAY);
		rdbtFemale.setForeground(Color.ORANGE);
		rdbtFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtFemale.setBounds(704, 319, 86, 23);
		frame.getContentPane().add(rdbtFemale);
		genderGroup.add(rdbtFemale);
		
		lblEmailId = new JLabel("Email ID :");
		lblEmailId.setForeground(Color.ORANGE);
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmailId.setBounds(468, 380, 96, 14);
		frame.getContentPane().add(lblEmailId);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setBounds(611, 366, 179, 31);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.ORANGE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(468, 432, 96, 14);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.BLACK);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBounds(611, 418, 179, 31);
		frame.getContentPane().add(txtPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(Color.GREEN);
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fname = txtFName.getText().trim();
				String lname = txtLName.getText().trim();
				String prn = txtPRN.getText().trim();
				String gender = null;
				if(rdbtMale.isSelected()==true)
					gender = "Male";
				else if(rdbtFemale.isSelected()==true)
					gender = "Female";
//				else
//					JOptionPane.showMessageDialog(null, "Invalid Details", "Gender Not Selected", JOptionPane.ERROR_MESSAGE);
				String email = txtEmail.getText().trim();
				@SuppressWarnings("deprecation")
				String password = txtPassword.getText();
				
				if(fname.equals("") || lname.equals("") || prn.equals("") || gender.equals("") || email.equals("") || password.equals(""))
					JOptionPane.showMessageDialog(null, "All Fileds are compulsory", "Login Error", JOptionPane.ERROR_MESSAGE);
				else {
					try {
						String sql = "insert into users values('"+fname+"','"+lname+"','"+prn+"','"+gender+"','"+email+"','"+password+"')";
						stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, prn+" Registered...Please Login now", "Success", JOptionPane.INFORMATION_MESSAGE);
						window.frame.setVisible(false);
						Login.main(null);
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Invalid Details / PRN Already Registered", "Login Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnRegister.setBounds(503, 517, 119, 36);
		frame.getContentPane().add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(false);
				Home.main(null);
			}
		});
		btnBack.setBackground(Color.BLUE);
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(793, 516, 96, 38);
		frame.getContentPane().add(btnBack);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 121, 1350, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 470, 1350, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFName.setText(null);
				txtLName.setText(null);
				txtPRN.setText(null);
				genderGroup.clearSelection();
				txtPassword.setText(null);
				txtEmail.setText(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBackground(Color.ORANGE);
		btnReset.setBounds(657, 517, 107, 36);
		frame.getContentPane().add(btnReset);
	}
}

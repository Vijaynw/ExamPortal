package portal.exam;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import connection.MyConnectionProvider;
import portal.Home;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants; 

public class Portal {
	private JFrame frame;
	
	static Connection con;
	static Statement stmt;
	static PreparedStatement ps;
	static ResultSet rs;

	static Portal window;
	
	String temp[] = new String[11];
	String ans[] = new String[11];
	static int count = 1;
	
	JButton btnPrevious;
	JButton btnNext;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					con = MyConnectionProvider.getcon();
					stmt = con.createStatement();
					window = new Portal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Hi"+e, "Login Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	String no = null;
	String a = null;
	String que = null;
	String b = null;
	String c = null;
	String d = null;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();
	private final ButtonGroup buttonGroup_7 = new ButtonGroup();
	private final ButtonGroup buttonGroup_8 = new ButtonGroup();
	private final ButtonGroup buttonGroup_9 = new ButtonGroup();
	private final ButtonGroup buttonGroup_10 = new ButtonGroup();
	
	public Portal() {
		String sql = "SELECT * FROM QA";
		try {
			rs = stmt.executeQuery(sql);
			rs.absolute(count++);
			no = rs.getString("srno");
			que = rs.getString("que");
			a = rs.getString("a");
			b = rs.getString("b");
			c = rs.getString("c");
			d = rs.getString("d");

			for(int i = 1; i < 11; i++) {
				rs.absolute(i);
				ans[i] = rs.getString("ans");
			}
			
			initialize(no, que, a, b, c, d);
			count-=1;
			btnPrevious.setEnabled(false);
			btnNext.setEnabled(true);
			
			JSeparator separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(1006, 0, 2, 749);
			frame.getContentPane().add(separator);
			
			JLabel lblAnswerSheet = new JLabel("Answer Sheet");
			lblAnswerSheet.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
			lblAnswerSheet.setForeground(Color.ORANGE);
			lblAnswerSheet.setBounds(1098, 23, 194, 31);
			frame.getContentPane().add(lblAnswerSheet);
			
			JLabel lblQuestionNo_1 = new JLabel("Question No.          A          B          C          D");
			lblQuestionNo_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblQuestionNo_1.setForeground(Color.WHITE);
			lblQuestionNo_1.setBounds(1018, 97, 342, 31);
			frame.getContentPane().add(lblQuestionNo_1);
			
			JLabel lblQ_1 = new JLabel("Q. 1");
			lblQ_1.setForeground(Color.WHITE);
			lblQ_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
			lblQ_1.setBounds(1040, 150, 37, 19);
			frame.getContentPane().add(lblQ_1);
			
			JLabel lblQ_2 = new JLabel("Q. 2");
			lblQ_2.setForeground(Color.WHITE);
			lblQ_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
			lblQ_2.setBounds(1040, 200, 37, 19);
			frame.getContentPane().add(lblQ_2);
			
			JLabel lblQ_3 = new JLabel("Q. 3");
			lblQ_3.setForeground(Color.WHITE);
			lblQ_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
			lblQ_3.setBounds(1040, 250, 37, 19);
			frame.getContentPane().add(lblQ_3);
			
			JLabel lblQ_4 = new JLabel("Q. 4");
			lblQ_4.setForeground(Color.WHITE);
			lblQ_4.setFont(new Font("Tahoma", Font.ITALIC, 15));
			lblQ_4.setBounds(1040, 300, 37, 19);
			frame.getContentPane().add(lblQ_4);
			
			JLabel lblQ_5 = new JLabel("Q. 5");
			lblQ_5.setForeground(Color.WHITE);
			lblQ_5.setFont(new Font("Tahoma", Font.ITALIC, 15));
			lblQ_5.setBounds(1040, 350, 37, 19);
			frame.getContentPane().add(lblQ_5);
			
			JLabel lblQ_6 = new JLabel("Q. 6");
			lblQ_6.setForeground(Color.WHITE);
			lblQ_6.setFont(new Font("Tahoma", Font.ITALIC, 15));
			lblQ_6.setBounds(1040, 400, 37, 19);
			frame.getContentPane().add(lblQ_6);
			
			JLabel lblQ_7 = new JLabel("Q. 7");
			lblQ_7.setForeground(Color.WHITE);
			lblQ_7.setFont(new Font("Tahoma", Font.ITALIC, 15));
			lblQ_7.setBounds(1040, 450, 37, 19);
			frame.getContentPane().add(lblQ_7);
			
			JLabel lblQ_8 = new JLabel("Q. 8");
			lblQ_8.setForeground(Color.WHITE);
			lblQ_8.setFont(new Font("Tahoma", Font.ITALIC, 15));
			lblQ_8.setBounds(1040, 500, 37, 19);
			frame.getContentPane().add(lblQ_8);
			
			JLabel lblQ_9 = new JLabel("Q. 9");
			lblQ_9.setForeground(Color.WHITE);
			lblQ_9.setFont(new Font("Tahoma", Font.ITALIC, 15));
			lblQ_9.setBounds(1040, 550, 37, 19);
			frame.getContentPane().add(lblQ_9);
			
			JLabel lblQ_10 = new JLabel("Q. 10");
			lblQ_10.setForeground(Color.WHITE);
			lblQ_10.setFont(new Font("Tahoma", Font.ITALIC, 15));
			lblQ_10.setBounds(1040, 600, 48, 19);
			frame.getContentPane().add(lblQ_10);
			
			JRadioButton rbtQ_1A = new JRadioButton("");
			rbtQ_1A.setActionCommand("A");
			buttonGroup_1.add(rbtQ_1A);
			rbtQ_1A.setBounds(1150, 150, 21, 23);
			frame.getContentPane().add(rbtQ_1A);
			
			JRadioButton rbtQ_1B = new JRadioButton("");
			rbtQ_1B.setActionCommand("B");
			buttonGroup_1.add(rbtQ_1B);
			rbtQ_1B.setBounds(1200, 150, 21, 23);
			frame.getContentPane().add(rbtQ_1B);
			
			JRadioButton rbtQ_1C = new JRadioButton("");
			rbtQ_1C.setActionCommand("C");
			buttonGroup_1.add(rbtQ_1C);
			rbtQ_1C.setBounds(1251, 150, 21, 23);
			frame.getContentPane().add(rbtQ_1C);
			
			JRadioButton rbtQ_1D = new JRadioButton("");
			rbtQ_1D.setActionCommand("D");
			buttonGroup_1.add(rbtQ_1D);
			rbtQ_1D.setBounds(1300, 150, 21, 23);
			frame.getContentPane().add(rbtQ_1D);
			
			JRadioButton rbtQ_2A = new JRadioButton("");
			rbtQ_2A.setActionCommand("A");
			buttonGroup_2.add(rbtQ_2A);
			rbtQ_2A.setBounds(1150, 196, 21, 23);
			frame.getContentPane().add(rbtQ_2A);
			
			JRadioButton rbtQ_2B = new JRadioButton("");
			rbtQ_2B.setActionCommand("B");
			buttonGroup_2.add(rbtQ_2B);
			rbtQ_2B.setBounds(1200, 196, 21, 23);
			frame.getContentPane().add(rbtQ_2B);
			
			JRadioButton rbtQ_2C = new JRadioButton("");
			rbtQ_2C.setActionCommand("C");
			buttonGroup_2.add(rbtQ_2C);
			rbtQ_2C.setBounds(1251, 196, 21, 23);
			frame.getContentPane().add(rbtQ_2C);

			JRadioButton rbtQ_2D = new JRadioButton("");
			rbtQ_2D.setActionCommand("D");
			buttonGroup_2.add(rbtQ_2D);
			rbtQ_2D.setBounds(1300, 196, 21, 23);
			frame.getContentPane().add(rbtQ_2D);
			
			JRadioButton rbtQ_3A = new JRadioButton("");
			rbtQ_3A.setActionCommand("A");
			buttonGroup_3.add(rbtQ_3A);
			rbtQ_3A.setBounds(1150, 246, 21, 23);
			frame.getContentPane().add(rbtQ_3A);
			
			JRadioButton rbtQ_3B = new JRadioButton("");
			rbtQ_3B.setActionCommand("B");
			buttonGroup_3.add(rbtQ_3B);
			rbtQ_3B.setBounds(1200, 246, 21, 23);
			frame.getContentPane().add(rbtQ_3B);
			
			JRadioButton rbtQ_3C = new JRadioButton("");
			rbtQ_3C.setActionCommand("C");
			buttonGroup_3.add(rbtQ_3C);
			rbtQ_3C.setBounds(1251, 246, 21, 23);
			frame.getContentPane().add(rbtQ_3C);

			JRadioButton rbtQ_3D = new JRadioButton("");
			rbtQ_3D.setActionCommand("D");
			buttonGroup_3.add(rbtQ_3D);
			rbtQ_3D.setBounds(1300, 246, 21, 23);
			frame.getContentPane().add(rbtQ_3D);
			
			JRadioButton rbtQ_4A = new JRadioButton("");
			rbtQ_4A.setActionCommand("A");
			buttonGroup_4.add(rbtQ_4A);
			rbtQ_4A.setBounds(1150, 296, 21, 23);
			frame.getContentPane().add(rbtQ_4A);
			
			JRadioButton rbtQ_4B = new JRadioButton("");
			rbtQ_4B.setActionCommand("B");
			buttonGroup_4.add(rbtQ_4B);
			rbtQ_4B.setBounds(1200, 296, 21, 23);
			frame.getContentPane().add(rbtQ_4B);
			
			JRadioButton rbtQ_4C = new JRadioButton("");
			rbtQ_4C.setActionCommand("C");
			buttonGroup_4.add(rbtQ_4C);
			rbtQ_4C.setBounds(1251, 296, 21, 23);
			frame.getContentPane().add(rbtQ_4C);

			JRadioButton rbtQ_4D = new JRadioButton("");
			rbtQ_4D.setActionCommand("D");
			buttonGroup_4.add(rbtQ_4D);
			rbtQ_4D.setBounds(1300, 296, 21, 23);
			frame.getContentPane().add(rbtQ_4D);
			
			JRadioButton rbtQ_5A = new JRadioButton("");
			rbtQ_5A.setActionCommand("A");
			buttonGroup_5.add(rbtQ_5A);
			rbtQ_5A.setBounds(1150, 346, 21, 23);
			frame.getContentPane().add(rbtQ_5A);
			
			JRadioButton rbtQ_5B = new JRadioButton("");
			rbtQ_5B.setActionCommand("B");
			buttonGroup_5.add(rbtQ_5B);
			rbtQ_5B.setBounds(1200, 346, 21, 23);
			frame.getContentPane().add(rbtQ_5B);
			
			JRadioButton rbtQ_5C = new JRadioButton("");
			rbtQ_5C.setActionCommand("C");
			buttonGroup_5.add(rbtQ_5C);
			rbtQ_5C.setBounds(1251, 346, 21, 23);
			frame.getContentPane().add(rbtQ_5C);

			JRadioButton rbtQ_5D = new JRadioButton("");
			rbtQ_5D.setActionCommand("D");
			buttonGroup_5.add(rbtQ_5D);
			rbtQ_5D.setBounds(1300, 346, 21, 23);
			frame.getContentPane().add(rbtQ_5D);
			
			JRadioButton rbtQ_6A = new JRadioButton("");
			rbtQ_6A.setActionCommand("A");
			buttonGroup_6.add(rbtQ_6A);
			rbtQ_6A.setBounds(1150, 396, 21, 23);
			frame.getContentPane().add(rbtQ_6A);
			
			JRadioButton rbtQ_6B = new JRadioButton("");
			rbtQ_6B.setActionCommand("B");
			buttonGroup_6.add(rbtQ_6B);
			rbtQ_6B.setBounds(1200, 396, 21, 23);
			frame.getContentPane().add(rbtQ_6B);
			
			JRadioButton rbtQ_6C = new JRadioButton("");
			rbtQ_6C.setActionCommand("C");
			buttonGroup_6.add(rbtQ_6C);
			rbtQ_6C.setBounds(1251, 396, 21, 23);
			frame.getContentPane().add(rbtQ_6C);

			JRadioButton rbtQ_6D = new JRadioButton("");
			rbtQ_6D.setActionCommand("D");
			buttonGroup_6.add(rbtQ_6D);
			rbtQ_6D.setBounds(1300, 396, 21, 23);
			frame.getContentPane().add(rbtQ_6D);
			
			JRadioButton rbtQ_7A = new JRadioButton("");
			rbtQ_7A.setActionCommand("A");
			buttonGroup_7.add(rbtQ_7A);
			rbtQ_7A.setBounds(1150, 450, 21, 23);
			frame.getContentPane().add(rbtQ_7A);
			
			JRadioButton rbtQ_7B = new JRadioButton("");
			rbtQ_7B.setActionCommand("B");
			buttonGroup_7.add(rbtQ_7B);
			rbtQ_7B.setBounds(1200, 450, 21, 23);
			frame.getContentPane().add(rbtQ_7B);
			
			JRadioButton rbtQ_7C = new JRadioButton("");
			rbtQ_7C.setActionCommand("C");
			buttonGroup_7.add(rbtQ_7C);
			rbtQ_7C.setBounds(1251, 450, 21, 23);
			frame.getContentPane().add(rbtQ_7C);

			JRadioButton rbtQ_7D = new JRadioButton("");
			rbtQ_7D.setActionCommand("D");
			buttonGroup_7.add(rbtQ_7D);
			rbtQ_7D.setBounds(1300, 450, 21, 23);
			frame.getContentPane().add(rbtQ_7D);
			
			JRadioButton rbtQ_8A = new JRadioButton("");
			rbtQ_8A.setActionCommand("A");
			buttonGroup_8.add(rbtQ_8A);
			rbtQ_8A.setBounds(1150, 500, 21, 23);
			frame.getContentPane().add(rbtQ_8A);
			
			JRadioButton rbtQ_8B = new JRadioButton("");
			rbtQ_8B.setActionCommand("B");
			buttonGroup_8.add(rbtQ_8B);
			rbtQ_8B.setBounds(1200, 500, 21, 23);
			frame.getContentPane().add(rbtQ_8B);
			
			JRadioButton rbtQ_8C = new JRadioButton("");
			rbtQ_8C.setActionCommand("C");
			buttonGroup_8.add(rbtQ_8C);
			rbtQ_8C.setBounds(1251, 500, 21, 23);
			frame.getContentPane().add(rbtQ_8C);

			JRadioButton rbtQ_8D = new JRadioButton("");
			rbtQ_8D.setActionCommand("D");
			buttonGroup_8.add(rbtQ_8D);
			rbtQ_8D.setBounds(1300, 500, 21, 23);
			frame.getContentPane().add(rbtQ_8D);
			
			JRadioButton rbtQ_9A = new JRadioButton("");
			rbtQ_9A.setActionCommand("A");
			buttonGroup_9.add(rbtQ_9A);
			rbtQ_9A.setBounds(1150, 550, 21, 23);
			frame.getContentPane().add(rbtQ_9A);
			
			JRadioButton rbtQ_9B = new JRadioButton("");
			rbtQ_9B.setActionCommand("B");
			buttonGroup_9.add(rbtQ_9B);
			rbtQ_9B.setBounds(1200, 550, 21, 23);
			frame.getContentPane().add(rbtQ_9B);
			
			JRadioButton rbtQ_9C = new JRadioButton("");
			rbtQ_9C.setActionCommand("C");
			buttonGroup_9.add(rbtQ_9C);
			rbtQ_9C.setBounds(1251, 550, 21, 23);
			frame.getContentPane().add(rbtQ_9C);

			JRadioButton rbtQ_9D = new JRadioButton("");
			rbtQ_9D.setActionCommand("D");
			buttonGroup_9.add(rbtQ_9D);
			rbtQ_9D.setBounds(1300, 550, 21, 23);
			frame.getContentPane().add(rbtQ_9D);
			
			JRadioButton rbtQ_10A = new JRadioButton("");
			rbtQ_10A.setActionCommand("A");
			buttonGroup_10.add(rbtQ_10A);
			rbtQ_10A.setBounds(1150, 600, 21, 23);
			frame.getContentPane().add(rbtQ_10A);
			
			JRadioButton rbtQ_10B = new JRadioButton("");
			rbtQ_10B.setActionCommand("B");
			buttonGroup_10.add(rbtQ_10B);
			rbtQ_10B.setBounds(1200, 600, 21, 23);
			frame.getContentPane().add(rbtQ_10B);
			
			JRadioButton rbtQ_10C = new JRadioButton("");
			rbtQ_10C.setActionCommand("C");
			buttonGroup_10.add(rbtQ_10C);
			rbtQ_10C.setBounds(1251, 600, 21, 23);
			frame.getContentPane().add(rbtQ_10C);

			JRadioButton rbtQ_10D = new JRadioButton("");
			rbtQ_10D.setActionCommand("D");
			buttonGroup_10.add(rbtQ_10D);
			rbtQ_10D.setBounds(1300, 600, 21, 23);
			frame.getContentPane().add(rbtQ_10D);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e, "Login Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @param D 
	 * @param C 
	 * @param B 
	 * @param A 
	 * @param Que 
	 * @param No 
	 */
	public void initialize(String No, String Que, String A, String B, String C, String D) {
				
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(-10, 0, 1650, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblQuestionNo = new JLabel("Question No.");
		lblQuestionNo.setForeground(Color.ORANGE);
		lblQuestionNo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQuestionNo.setBounds(293, 11, 220, 56);
		frame.getContentPane().add(lblQuestionNo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 97, 1370, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNo = new JLabel(No);
		lblNo.setForeground(Color.ORANGE);
		lblNo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNo.setBounds(523, 11, 82, 56);
		frame.getContentPane().add(lblNo);
		
		JLabel lblQue = new JLabel("Que :"+Que);
		lblQue.setForeground(Color.ORANGE);
		lblQue.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQue.setBounds(79, 144, 823, 92);
		frame.getContentPane().add(lblQue);

		JLabel lblA = new JLabel("A. "+A);
		lblA.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblA.setForeground(new Color(255, 255, 255));
		lblA.setBounds(51, 316, 443, 62);
		frame.getContentPane().add(lblA);
		
		JLabel lblB = new JLabel("B. "+B);
		lblB.setForeground(Color.WHITE);
		lblB.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblB.setBounds(517, 316, 443, 62);
		frame.getContentPane().add(lblB);
		
		JLabel lblC = new JLabel("C. "+C);
		lblC.setForeground(Color.WHITE);
		lblC.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblC.setBounds(51, 425, 443, 56);
		frame.getContentPane().add(lblC);
		
		JLabel lblD = new JLabel("D. "+D);
		lblD.setForeground(Color.WHITE);
		lblD.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblD.setBounds(517, 425, 443, 56);
		frame.getContentPane().add(lblD);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.setBackground(Color.ORANGE);
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnNext.setEnabled(true);
					rs.absolute(--count);
					no = rs.getString("srno");
					que = rs.getString("que");
					a = rs.getString("a");
					b = rs.getString("b");
					c = rs.getString("c");
					d = rs.getString("d");
					lblNo.setText(no);
					lblQue.setText("Que : "+que);
					lblA.setText("A. "+a);
					lblB.setText("B. "+b);
					lblC.setText("C. "+c);
					lblD.setText("D. "+d);
					if(count <= 1) {
						btnPrevious.setEnabled(false);
						btnNext.setEnabled(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "This is the first Question...", "Login Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPrevious.setBounds(199, 587, 138, 42);
		frame.getContentPane().add(btnPrevious);
		
		btnNext = new JButton("Next");
		btnNext.setBackground(Color.ORANGE);
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnPrevious.setEnabled(true);
					rs.absolute(++count);
					no = rs.getString("srno");
					que = rs.getString("que");
					a = rs.getString("a");
					b = rs.getString("b");
					c = rs.getString("c");
					d = rs.getString("d");
					lblNo.setText(no);
					lblQue.setText("Que : "+que);
					lblA.setText("A. "+a);
					lblB.setText("B. "+b);
					lblC.setText("C. "+c);
					lblD.setText("D. "+d);
					if(count >= 10) {
						count = 10;
						btnPrevious.setEnabled(true);
						btnNext.setEnabled(false);
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "This is the last Question...", "Login Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNext.setBounds(437, 587, 138, 42);
		frame.getContentPane().add(btnNext);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int score = 0;
					if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to Submit ?", "Submit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
						temp[1] = buttonGroup_1.getSelection().getActionCommand();
						temp[2] = buttonGroup_2.getSelection().getActionCommand();
						temp[3] = buttonGroup_3.getSelection().getActionCommand();
						temp[4] = buttonGroup_4.getSelection().getActionCommand();
						temp[5] = buttonGroup_5.getSelection().getActionCommand();
						temp[6] = buttonGroup_6.getSelection().getActionCommand();
						temp[7] = buttonGroup_7.getSelection().getActionCommand();
						temp[8] = buttonGroup_8.getSelection().getActionCommand();
						temp[9] = buttonGroup_9.getSelection().getActionCommand();
						temp[10] = buttonGroup_10.getSelection().getActionCommand();
						
						for(int i=1;i<11;i++) {
							if(ans[i].equals(temp[i]))
								score+=1;
						}
						JOptionPane.showMessageDialog(null, "Congratulation...!!!\nYour Score :- "+score+"\nWelcome Back...", "Congratulation", JOptionPane.INFORMATION_MESSAGE);
				        window.frame.setVisible(false);
						Home.main(null);
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "There is no Negative Marking \nSo, Please attempt all Questions... :)", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSubmit.setBackground(Color.ORANGE);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSubmit.setBounds(663, 587, 138, 42);
		frame.getContentPane().add(btnSubmit);
	}
}

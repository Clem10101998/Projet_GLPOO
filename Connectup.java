package connect;

import java.sql.*;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Connectup extends JFrame {

	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField_1;

	public static void main(String[] args) {
		
				try {
					Connectup window = new Connectup();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}

	public Connectup() {
		initialize();
	}

	private void initialize() {
		this.getContentPane().setBackground(new Color(255, 200, 0));
		this.setBounds(100, 100, 576, 340);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setTitle("Sign Up");
		
		JLabel lblNewLabel = new JLabel("Create your account");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(209, 33, 158, 16);
		this.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(220, 93, 130, 26);
		this.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(220, 129, 130, 26);
		this.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(220, 167, 130, 26);
		this.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Firstname");
		lblNewLabel_1.setBounds(157, 98, 67, 16);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lastname");
		lblNewLabel_2.setBounds(157, 134, 61, 16);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("username");
		lblNewLabel_3.setBounds(157, 172, 61, 16);
		this.getContentPane().add(lblNewLabel_3);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(220, 205, 130, 26);
		this.getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(157, 210, 61, 16);
		this.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Create account");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.setBounds(209, 260, 147, 29);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				
				//String sql ="Insert into client" + " (id, firstname, lastname, username, password) VALUES" +
				//" (?, ?, ?, ?, ?);";
				String Firstname = textField_1.getText();
				String Lastname = textField_2.getText();
				String Username = textField_3.getText();
				String Password = passwordField_1.getText();
				
				
				try {
					//Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Connection?useSSL=false&serverTimezone=UTC", "root", "Clement1998");
					String sql= "Insert into client (firstname, lastname, username, password) values('" + Firstname + "','" + Lastname + "','" + Username + "','" + Password + "')";
					Statement myStmt = myConn.createStatement();
					//Statement myStmt = myConn.createStatement();
					//ResultSet myRs = myStmt.executeQuery("select * from client");
					//?useSSL=false&serverTimezone=UTC
					//String sql= "Insert into client (firstname, lastname, username, password) values('" + Firstname + "','" + Lastname + "','" + Username + "','" + Password + "')";
					int myRs = myStmt.executeUpdate(sql);
					if(myRs==1) {
						
					JOptionPane.showMessageDialog(null, "Welcome, Account created");
					}else {
						JOptionPane.showMessageDialog(null, "This account has ever been created");
					}
					myConn.close();
				}catch (Exception exc) {
					exc.printStackTrace();
				}
			}
        });
		
		
		this.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("<--");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_1.setBounds(0, 6, 98, 29);
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
			dispose();
			Connectin ne = new Connectin();
			ne.setVisible(true);
	     }
        });
		this.getContentPane().add(btnNewButton_1);
		
		
		
		
}
}


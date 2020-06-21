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

	private JPasswordField passwordField;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField username;
	
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
		
		JLabel account = new JLabel("Create your account");
		account.setForeground(Color.BLUE);
		account.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		account.setBounds(209, 33, 158, 16);
		this.getContentPane().add(account);
		
		firstname = new JTextField();
		firstname.setBounds(220, 93, 130, 26);
		this.getContentPane().add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setBounds(220, 129, 130, 26);
		this.getContentPane().add(lastname);
		lastname.setColumns(10);
		
		username = new JTextField();
		username.setBounds(220, 167, 130, 26);
		this.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel first = new JLabel("Firstname");
		first.setBounds(157, 98, 67, 16);
		this.getContentPane().add(first);
		
		JLabel last = new JLabel("Lastname");
		last.setBounds(157, 134, 61, 16);
		this.getContentPane().add(last);
		
		JLabel user = new JLabel("user");
		user.setBounds(157, 172, 61, 16);
		this.getContentPane().add(user);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 205, 130, 26);
		this.getContentPane().add(passwordField);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(157, 210, 61, 16);
		this.getContentPane().add(pass);
		
		JButton create = new JButton("Create account");
		create.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		create.setBounds(209, 260, 147, 29);
		create.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				
				String Firstname = firstname.getText();
				String Lastname = lastname.getText();
				String Username = username.getText();
				String Password = passwordField.getText();
				
				if(Firstname.equals("")) {
					JOptionPane.showMessageDialog(null, "Please write your Firstname");
				}else if(Lastname.equals("")) {
					JOptionPane.showMessageDialog(null, "Please write your Lastname");
				}else if(Username.equals("")) {
					JOptionPane.showMessageDialog(null, "Please write your Username");
				}else if (Password.equals("")) {
					JOptionPane.showMessageDialog(null, "Please write your Password");
				}else {
				
				try {
					Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sign?useSSL=false&serverTimezone=UTC", "root", "Clement1998");
					String sql= "Insert into connection (firstname, lastname, username, password) values('" + Firstname + "','" 
					+ Lastname + "','" + Username + "','" + Password + "')";
					Statement Stmt = Conn.createStatement();
					int Rs = Stmt.executeUpdate(sql);
				
					if(Rs==1) {
					JOptionPane.showMessageDialog(null, "Welcome, Account created");
					}else {
					JOptionPane.showMessageDialog(null, "This account has ever been created");
					}
					Conn.close();
					}catch (Exception exc) {
					exc.printStackTrace();
					}
				}
			}
		});
		this.getContentPane().add(create);

		JButton getback = new JButton("<--");
		getback.setForeground(Color.RED);
		getback.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		getback.setBounds(0, 6, 98, 29);
		getback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
			dispose();
			Connectin ne = new Connectin();
			ne.setVisible(true);
			}
        });
		this.getContentPane().add(getback);
		}
	}


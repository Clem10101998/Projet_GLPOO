package connect;

import java.sql.*;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
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

public class Connectin extends JFrame {

	private JTextField textField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		
				try {
					Connectin window = new Connectin();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	public Connectin() {
		initialize();
	}

	private void initialize() {
		this.getContentPane().setBackground(new Color(255, 200, 0));
		this.setBounds(100, 100, 576, 340);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setTitle("Sign In");
		
		textField = new JTextField();
		textField.setBounds(232, 114, 130, 26);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel welcome = new JLabel("Welcome on our chat application");
		welcome.setForeground(Color.BLUE);
		welcome.setBackground(Color.BLACK);
		welcome.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		welcome.setBounds(176, 27, 246, 32);
		this.getContentPane().add(welcome);
		
		JLabel username = new JLabel("username");
		username.setBounds(167, 119, 71, 16);
		this.getContentPane().add(username);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(232, 164, 130, 26);
		this.getContentPane().add(passwordField);
		
		JLabel password = new JLabel("password");
		password.setBounds(167, 169, 61, 16);
		this.getContentPane().add(password);
		
		JButton signup = new JButton("Sign Up");
		signup.setBounds(121, 248, 117, 29);
		signup.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
			dispose();
			Connectup ne = new Connectup();
			ne.setVisible(true);
	     }
        });
		this.getContentPane().add(signup);
		
		JButton signin = new JButton("Sign In");
		signin.setBounds(357, 248, 117, 29);
		signin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				
				String Username = textField.getText();
				String Password = passwordField.getText();
				if(Username.equals("")) {
					JOptionPane.showMessageDialog(null, "Please write your username");
				}else if(Password.equals("")) {
					JOptionPane.showMessageDialog(null, "Please write your password");
				}else {
				
				try {
					Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sign?useSSL=false&serverTimezone=UTC", "root", "Clement1998");
					Statement Stmt = Conn.createStatement();
					String sql= "Select * from connection where username='"+textField.getText()+"' and password='"+passwordField.getText().toString()+"'";
					ResultSet Rs = Stmt.executeQuery(sql);
					
					if(Rs.next()) {
						JOptionPane.showMessageDialog(null, "Successfull connection for :"+" "+textField.getText());
						Server me = new Server();
						me.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Unknown User");}
					Conn.close();
				}catch (Exception exc) {
					System.out.print(exc);;
				}
			}
		}
    });
		this.getContentPane().add(signin);
		
	}
}
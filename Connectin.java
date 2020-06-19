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

	private JFrame frame;
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
		
		JLabel lblNewLabel = new JLabel("Welcome on our chat application");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(176, 27, 246, 32);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setBounds(167, 119, 71, 16);
		this.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(232, 164, 130, 26);
		this.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setBounds(167, 169, 61, 16);
		this.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setBounds(121, 248, 117, 29);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
			dispose();
			Connectup ne = new Connectup();
			ne.setVisible(true);
	     }
        });
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign In");
		btnNewButton_1.setBounds(357, 248, 117, 29);
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
			
				
				try {
					//Class.forName("com.mysql.cj.jdbc.Driver");
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Connection?useSSL=false&serverTimezone=UTC", "root", "Clement1998");
					Statement myStmt = myConn.createStatement();
					//ResultSet myRs = myStmt.executeQuery("select * from client");
					//?useSSL=false&serverTimezone=UTC
					String sql= "Select * from client where username='"+textField.getText()+"' and password='"+passwordField.getText().toString()+"'";
					ResultSet myRs = myStmt.executeQuery(sql);
					if(myRs.next())
						JOptionPane.showMessageDialog(null, "Successfull connection for :"+" "+textField.getText());
					else
						JOptionPane.showMessageDialog(null, "Unknown User");
					myConn.close();
				}catch (Exception exc) {
					System.out.print(exc);;
				}
				
				
	     }
        });
		this.getContentPane().add(btnNewButton_1);
		
		
}
}
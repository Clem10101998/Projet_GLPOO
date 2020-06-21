package connect;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.io.*;  
import java.net.*; 
import java.sql.*;

public class Client extends JFrame {

	private JTextField textField;
	static JTextArea textArea;
	static ServerSocket ss;
	static Socket socket;
	static DataInputStream input;
	static DataOutputStream output;
	private JTextField textField_1;
	private JButton btnNewButton_1;

	public static void main(String[] args) {
		Client window = new Client();
		window.setVisible(true);
			
				String ip = "localhost";
				int port = 6666;
				
				try {
					
					//Message sent = new Message();
					socket = new Socket(ip, port);
					input = new DataInputStream(socket.getInputStream());
					output = new DataOutputStream(socket.getOutputStream());
					String msg = "";
					msg = input.readUTF();
					textArea.setText(textArea.getText()+"\n"+msg);
					ss.close();
					socket.close();
					
					}catch(Exception se) {
					
				}
			}

	public Client() {
		initialize();
	}

	private void initialize() {
		this.getContentPane().setBackground(Color.GREEN);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(190, 276, 189, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.setBounds(384, 271, 69, 39);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				
				try {
				//String message = "";
				String message = textField.getText();
				Message test = new Message();
				//textArea.setText(textArea.getText()+message);
				output.writeUTF(message);
				}catch(Exception ec) {
					
				}
	     }
        });
		getContentPane().add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(190, 6, 246, 258);
		getContentPane().add(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(6, 6, 172, 258);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton_1 = new JButton("contact");
		btnNewButton_1.setBounds(35, 271, 117, 29);
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				
				try {
					
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Connect?useSSL=false&serverTimezone=UTC", "root", "Clement1998");
					Statement myStmt = myConn.createStatement();
					ResultSet myRs = myStmt.executeQuery("select * from connection");
					//?useSSL=false&serverTimezone=UTC
					while (myRs.next()) {
						//System.out.println(myRs.getString("firstname") + " " + myRs.getString("username"));
						textField_1.setText(myRs.getString("firstname") + " "+ myRs.getString("lastname"));
						textField_1.setText("hello");
					}
					
				}catch (Exception exc) {
					exc.printStackTrace();
				}
	     }
        });
		getContentPane().add(btnNewButton_1);
		
		
		this.setBounds(100, 100, 453, 340);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocationRelativeTo(null);
		this.setTitle("Client");
		
	}
}
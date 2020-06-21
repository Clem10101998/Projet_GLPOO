package connect;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;  
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Server extends JFrame {

	private JTextField textField;
	static JTextArea textArea;
	static ServerSocket ss;
	static Socket socket;
	static DataInputStream input;
	static DataOutputStream output;
	private JButton btnNewButton_1;
	private JComboBox comboBox;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_1;
	

	public static void main(String[] args) {
		
					Server window = new Server();
					window.setVisible(true);
					int port = 6666;
					String msg = "";
					
				try {
					
					ss = new ServerSocket(port);
					socket = ss.accept();
					input = new DataInputStream(socket.getInputStream());
					output = new DataOutputStream(socket.getOutputStream());
					msg = input.readUTF();
					textArea.setText(textArea.getText()+"\n"+msg);
					ss.close();
					socket.close();
					
					}catch(Exception se) {
				}
			}

	public Server() {
		initialize();
	}

	private void initialize() {
		this.getContentPane().setBackground(Color.GREEN);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(206, 276, 189, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(210, 6, 246, 258);
		getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.setBounds(393, 271, 69, 39);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				try {
				String message = "";
				message = textField.getText();
				//Message test = new Message();
				textArea.setText(textArea.getText()+"Serveur:"+" "+message);
				output.writeUTF("Server:"+" "+message);
				textField.setText("");
				}catch(Exception ec) {
					
				}
	     }
        });
		getContentPane().add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setBounds(6, 40, 172, 26);
		
		try {
			
			Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sign?useSSL=false&serverTimezone=UTC", "root", "Clement1998");
			Statement Stmt = Conn.createStatement();
			ResultSet Rs = Stmt.executeQuery("select * from connection");
			//?useSSL=false&serverTimezone=UTC
			while (Rs.next()) {
				comboBox.addItem(Rs.getString("firstname") + " " + Rs.getString("lastname"));
			}
		}catch (Exception exc) {
			exc.printStackTrace();
		}
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Check the list of contacts");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(6, 12, 172, 16);
		getContentPane().add(lblNewLabel);
		
		btnNewButton_2 = new JButton("Contact");
		btnNewButton_2.setBounds(48, 169, 93, 34);
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Client ne = new Client();
				ne.setVisible(true);
				}
        	});
		getContentPane().add(btnNewButton_2);
		
		lblNewLabel_1 = new JLabel("Click here for contacting");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(15, 131, 163, 26);
		getContentPane().add(lblNewLabel_1);
		
		this.setBounds(100, 100, 462, 340);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocationRelativeTo(null);
		this.setTitle("Server");
		
	}
}
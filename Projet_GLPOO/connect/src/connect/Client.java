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
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class Client extends JFrame {

	private JTextField textField;
	static JTextArea textArea;
	static ServerSocket ss;
	static Socket socket;
	static DataInputStream input;
	static DataOutputStream output;
	private JComboBox comboBox;
	
	
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
				String message = "";
				message = textField.getText();
				Message test = new Message();
				textArea.setText(textArea.getText()+"Client:"+" "+message+"\n");
				output.writeUTF("Client:"+" "+message);
				textField.setText("");
				}catch(Exception ec) {
					
				}
			}
        });
		getContentPane().add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(190, 6, 246, 258);
		getContentPane().add(textArea);
		
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
		
		btnNewButton_1 = new JButton("contact");
		btnNewButton_1.setBounds(35, 271, 117, 29);
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				
			}
        });
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Check the list of contacts");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(6, 12, 172, 16);
		getContentPane().add(lblNewLabel);
		
		this.setBounds(100, 100, 453, 340);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocationRelativeTo(null);
		this.setTitle("Client");
		
	}
}
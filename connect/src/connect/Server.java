package connect;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;  
import java.net.*; 
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Server extends JFrame {

	private JTextField textField;
	static JTextArea textArea;
	static ServerSocket ss;
	static Socket socket;
	static DataInputStream input;
	static DataOutputStream output;
	private JButton btnNewButton_1;
	

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
		textField.setBounds(41, 276, 189, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(31, 6, 246, 258);
		getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.setBounds(229, 271, 69, 39);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				try {
				//String message = "";
				 String message = textField.getText();
				//Message test = new Message();
				//textArea.setText(textArea.getText()+message);
				output.writeUTF(message);
				textField.setText("");
				}catch(Exception ec) {
					
				}
	     }
        });
		getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Discussion");
		btnNewButton_1.setBounds(306, 121, 114, 29);
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Client ne = new Client();
				ne.setVisible(true);
	     }
        });
		getContentPane().add(btnNewButton_1);
		
		this.setBounds(100, 100, 462, 340);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocationRelativeTo(null);
		this.setTitle("Server");
		
	}
}
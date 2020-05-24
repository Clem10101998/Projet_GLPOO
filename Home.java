import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;



public class Home extends JFrame{

private ImageIcon icone;
private Window fen;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;



	public static void main(String[] args) {
		
					Home window = new Home();
					window.setVisible(true);
				
	}

	public Home() {
		initialize();
	}
	
	private void initialize() {
		
	this.setResizable(false);
		this.setTitle("Sign");
		this.setBounds(100, 100, 700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 363, 478);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(icone);
		icone = new ImageIcon("files/cybersecurite.png");
		lblNewLabel_1.setIcon(icone);
		lblNewLabel_1.setBounds(6, 6, 351, 466);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(361, 0, 339, 478);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fisrtname");
		lblNewLabel.setBounds(64, 47, 107, 24);
		panel_1.add(lblNewLabel);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(64, 134, 107, 24);
		panel_1.add(lblSurname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(64, 229, 107, 24);
		panel_1.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(64, 83, 203, 32);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(64, 175, 203, 32);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(64, 275, 203, 32);
		panel_1.add(textField_2);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(64, 335, 107, 24);
		panel_1.add(lblPassword);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(64, 384, 203, 32);
		panel_1.add(textField_3);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			OptionPane.showMessageDialog(null,"Please fill the blank", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(117, 449, 117, 29);
		panel_1.add(btnNewButton);
}
}

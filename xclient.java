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

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Xclient extends JFrame {


	private JList<String>list_client = new JList<String>();
	private DefaultListModel<String>data = new DefaultListModel<String>();

	public static void main(String[] args) {
	
			Xclient window = new Xclient();
			window.setVisible(true);
			
		}

	public Xclient() {
		initialize();
	}

	private void initialize() {
		
		this.getContentPane().setBackground(Color.ORANGE);
		this.setBounds(100, 100, 576, 340);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setTitle("Client");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(130, 58, 330, 193);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		//list_client.setBounds(90, 34, 153, 128);
		//panel.add(list_client);

		data = new DefaultListModel<String>();
		list_client = new JList<String>(data);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 37, 201, 119);
		panel.add(scrollPane);
		scrollPane.setViewportView(list_client);
		
		JLabel lblNewLabel = new JLabel("List of clients");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(243, 17, 86, 29);
		this.getContentPane().add(lblNewLabel);
		

		JButton btnNewButton = new JButton("Check the list");
		btnNewButton.setBounds(239, 263, 117, 29);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
			addElementToScrollClients ("client", data);
			list_client.setModel(data);
	     }
        });
		this.getContentPane().add(btnNewButton);


	}

		void addElementToScrollClients (String TagName, DefaultListModel<String>data){
			try {
				String info=" ";
   				 File fXmlFile = new File("files/clients.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    				Document doc = dBuilder.parse(fXmlFile);
    				doc.getDocumentElement().normalize();
	 			NodeList nList = doc.getElementsByTagName(TagName);
    				
    				for (int temp = 0; temp < nList.getLength(); temp++) {
        				Node nNode = nList.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            					Element eElement = (Element) nNode;
            					info = eElement.getElementsByTagName("firstname").item(0).getTextContent() +" "+ eElement.getElementsByTagName("lastname").item(0).getTextContent();
					data.addElement(info);
					
 			       		}
					}
    					} catch (Exception e) {
    					e.printStackTrace();
    					}	
					}
				}

package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Desktop;
import java.io.*;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.swing.SwingConstants;

public class Doctor_Dashboard extends JFrame {

	/**
	 * 
	 */
	
	private JPanel contentPane;
	private JTextField textField;
	public String s = "Undefined User";
	private JTable table;
    public static String user;
    int count1=0;
    int count2=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_Dashboard frame = new Doctor_Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Doctor_Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(26, 157, 120));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(18, 109, 84));
		panel.setForeground(new Color(0, 153, 76));
		panel.setBounds(0, 0, 1920, 90);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("WellBiing Healthcare");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Leelawadee UI", Font.BOLD, 25));
		lblNewLabel_2.setBounds(560, 0, 400, 90);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(1407, 33, 107, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Hello, User");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Leelawadee UI", Font.BOLD, 25));
		lblNewLabel_3.setBounds(90, 0, 129, 90);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Doctor_Dashboard.class.getResource("/img/male_user_50px.png")));
		lblNewLabel_4.setBounds(30, 0, 50, 90);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("Data Visualization");
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(1199, 34, 189, 23);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(26, 157, 120));
		panel_1.setBounds(660, 200, 400, 475);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Patient's Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Leelawadee UI", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 114, 400, 40);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(101, 164, 206, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Dashboard");
		chckbxNewCheckBox.setFont(new Font("Leelawadee UI", Font.BOLD, 20));
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setBackground(new Color(18, 109, 84));
		chckbxNewCheckBox.setBounds(44, 226, 150, 40);
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Data Entry");
		chckbxNewCheckBox_1.setFont(new Font("Leelawadee UI", Font.BOLD, 20));
		chckbxNewCheckBox_1.setForeground(Color.WHITE);
		chckbxNewCheckBox_1.setBackground(new Color(18, 109, 84));
		chckbxNewCheckBox_1.setBounds(219, 226, 150, 40);
		panel_1.add(chckbxNewCheckBox_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Leelawadee UI", Font.PLAIN, 20));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(154, 317, 100, 30);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBackground(new Color(15, 94, 72));
		lblNewLabel_9.setIcon(new ImageIcon(Doctor_Dashboard.class.getResource("/img/teal_rounded_rect.png")));
		lblNewLabel_9.setBounds(0, 0, 400, 475);
		panel_1.add(lblNewLabel_9);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 150, 449, 552);
		contentPane.add(scrollPane);
		
		try{
			
			Get_Records jp = new Get_Records();
		
		jp.StartParsing();
		String data[][] = {};
		String col[] = {"RFID", "Temperature", "Heart Rate", "SpO2"};
		Set<String> UserSet = new HashSet<String>();
		DefaultTableModel model = new DefaultTableModel(data, col);
		for(int i=1;i<50;i++) {
			String[] values = jp.ReadValues(i);
			model.insertRow(i-1, new Object[] {values[0],values[1], values[2], values[3]});
			count1 = count1+1;
			
			UserSet.add(values[0]);

			table = new JTable();
			table.setModel(model);
		
		}
		scrollPane.setViewportView(table);
		
		UserSet.remove("0");
		UserSet.remove(null);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(26, 157, 120));
		panel_2.setBounds(1200, 220, 200, 200);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Total Entries");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Leelawadee UI", Font.BOLD, 25));
		lblNewLabel_6.setBounds(0, 58, 200, 27);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(Long.toString(JSON_Parser.lastentry));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Leelawadee UI", Font.BOLD, 25));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(68, 82, 70, 62);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(0, 0, 200, 200);
		panel_2.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon(Doctor_Dashboard.class.getResource("/img/blue 200x200.png")));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(26, 157, 120));
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(1200, 445, 200, 200);
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Number of Users");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Leelawadee UI", Font.BOLD, 25));
		lblNewLabel_6_1.setBounds(0, 62, 200, 27);
		panel_2_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel(Integer.toString(UserSet.size()));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Leelawadee UI", Font.BOLD, 25));
		lblNewLabel_7_1.setBounds(70, 91, 70, 62);
		panel_2_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setIcon(new ImageIcon(Doctor_Dashboard.class.getResource("/img/green 200x200.png")));
		lblNewLabel_8_1.setBounds(0, 0, 200, 200);
		panel_2_1.add(lblNewLabel_8_1);
		}
		catch(Exception e) {
		
		}
		
		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	  s = textField.getText();
            	   user = s;
            	  
            	  
            	if (s.equals("Undefined User")) {
            		JOptionPane.showMessageDialog(null, "Invalid Patient name");
            	}
            	else {
            		if(chckbxNewCheckBox_1.isSelected() && chckbxNewCheckBox.isSelected() ) {
            			JOptionPane.showMessageDialog(null, "Select only one checkbox");
            		}
            		else if(chckbxNewCheckBox.isSelected()) {
            			Patient_Dashboard d = new Patient_Dashboard();
            			d.main(null);
            			setVisible(false);
            		}
            		else if(chckbxNewCheckBox_1.isSelected()) {
            			
            				Record_Entry e = new Record_Entry(s);
                			e.main(null);
                			setVisible(false);
            			
            			
            		}
            		else {
            			 JOptionPane.showMessageDialog(null, "Select the checkbox");
            		}
            	}
            		
            		
              }
        });
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	Login_Page l = new Login_Page();
                l.main(null);
                setVisible(false);
              }
        });
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					HTML_writer obj = new HTML_writer();
					obj.Write_html();
				
					String url = "Data_visual.html";
					File file = new File(url);
					
					try {
						
						Desktop.getDesktop().browse(file.toURI());
					} catch (IOException e1) {
					
						e1.printStackTrace();
					}
			}
			
		});
	}
}


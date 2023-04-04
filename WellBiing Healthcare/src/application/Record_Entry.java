package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Record_Entry extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					String user1 = Doctor_Dashboard.user;
					System.out.println(user1);
					Record_Entry frame = new Record_Entry(user1);
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
	public Record_Entry(String user) {
		System.out.println(user);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1930,1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(26, 157, 120));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.BLUE);
		panel_2.setBackground(new Color(18, 109, 84));
		panel_2.setBounds(0, 0, 1920, 90);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("WellBiing Healthcare");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Leelawadee UI", Font.BOLD, 25));
		lblNewLabel_7.setBounds(560, 0, 400, 90);
		panel_2.add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(1411, 34, 97, 23);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(Record_Entry.class.getResource("/img/male_user_50px.png")));
		lblNewLabel_9.setBounds(30, 0, 70, 90);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_7_1 = new JLabel("Hello, User");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Leelawadee UI", Font.BOLD, 25));
		lblNewLabel_7_1.setBounds(94, 0, 149, 90);
		panel_2.add(lblNewLabel_7_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(560, 200, 400, 475);
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(26, 157, 120));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Temperature");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Leelawadee UI", Font.BOLD, 24));
		lblNewLabel_2.setBounds(0, 120, 400, 30);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(100, 160, 200, 20);
		
		
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("SpO2");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Leelawadee UI", Font.BOLD, 24));
		lblNewLabel_3.setBounds(0, 200, 400, 30);
		panel_1.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 240, 200, 20);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_4 = new JLabel("Heart Rate");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Leelawadee UI", Font.BOLD, 24));
		lblNewLabel_4.setBounds(0, 280, 400, 30);
		panel_1.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 320, 200, 20);
		panel_1.add(textField_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(150, 380, 100, 25);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Patient Name :");
		lblNewLabel.setBounds(40, 40, 200, 50);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Leelawadee UI", Font.BOLD, 24));
		
		JLabel lblNewLabel_1 = new JLabel(user);
		lblNewLabel_1.setBounds(240, 40, 140, 50);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Leelawadee UI", Font.BOLD, 24));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Record_Entry.class.getResource("/img/teal_rounded_rect.png")));
		lblNewLabel_5.setBounds(0, 0, 400, 475);
		panel_1.add(lblNewLabel_5);
		
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				
				String temp = textField.getText();
				
				String SpO2 = textField_1.getText();
				
				String HR = textField_2.getText();
				System.out.println(temp);
				String RFID = "0";
				
				System.out.println(user+"TEST");
				if (user.equals("user1")) {
					RFID = "1";
				}
				if (user.equals("user2")) {
					RFID = "2";
				}
				System.out.println(RFID);
				try {
				String cmnd = "https://api.thingspeak.com/update.json?api_key=G71SDBACFUCGUBCM&field1="+RFID+"&field2="+HR+"&field3="+SpO2+"&field4="+temp;
				URL obj = new URL(cmnd);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				int responseCode = con.getResponseCode();
				System.out.println("GET Response Code :: " + responseCode);
				if (responseCode == HttpURLConnection.HTTP_OK) { // success
					BufferedReader in = new BufferedReader(new InputStreamReader(
							con.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					// print result
					System.out.println(response.toString());
				} else {
					System.out.println("GET request did not work");
				}
				}
				catch(Exception ex){
					ex.getStackTrace();
				}
				
				try {
					Thread.sleep(5500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Entries have been saved.");
				
				Doctor_Dashboard d;
				d = new Doctor_Dashboard();
				d.main(null);
				setVisible(false);
			
		}
			
		});
		
		btnNewButton_1.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Logout Successful!");
				Login_Page l = new Login_Page();
                l.main(null);
                setVisible(false);
			}
			
			
		});
		
	}
}

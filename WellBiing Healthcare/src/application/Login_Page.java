package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Login_Page extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRdr;
	 JButton btnNewButton; 
	 private JPasswordField passwordField;
	 String userValue;
	 static String name;
	 

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 
					Login_Page frame = new Login_Page();
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
	public Login_Page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setBounds(0,0,1920,1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(26, 157, 120));
		panel_2.setBounds(0, 0, 1920, 1080);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("WellBiing Healthcare");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(560, 200, 400, 48);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Leelawadee UI", Font.BOLD, 30));
		lblNewLabel_3.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_3_1 = new JLabel("Management System");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(560, 242, 400, 60);
		panel_2.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Leelawadee UI", Font.BOLD, 30));
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(618, 354, 103, 25);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Leelawadee UI", Font.PLAIN, 23));
		
		txtRdr = new JTextField();
		txtRdr.setBounds(746, 360, 163, 20);
		panel_2.add(txtRdr);
		txtRdr.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(746, 405, 163, 20);
		panel_2.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(618, 397, 116, 33);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("", Font.PLAIN, 23));
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setBounds(700, 491, 130, 35);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Leelawadee UI", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Login_Page.class.getResource("/img/teal_rounded_rect.png")));
		lblNewLabel.setBounds(560, 150, 400, 475);
		panel_2.add(lblNewLabel);
		btnNewButton_1.addActionListener(this);
		setTitle("WellBiing Healthcare Management System");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		userValue = txtRdr.getText();        
        String passValue = passwordField.getText();  
        name = userValue;
         
        if (userValue.equals("user1") && passValue.equals("user1")) {  
        	 System.out.println(userValue +" Welcome to WellBiing Healthcare"); 
        	 JOptionPane.showMessageDialog(null, "Welcome to WellBiing Healthcare");
        	 Patient_Dashboard d = new Patient_Dashboard();
        	 
        	 d.main(null);
        	 setVisible(false);
        	 
        
        	 
        } 
        else if(userValue.equals("user2") && passValue.equals("user2")){
        	System.out.println(userValue +" Welcome to WellBiing Healthcare");
        	JOptionPane.showMessageDialog(null, "Welcome to WellBiing Healthcare");
        	Patient_Dashboard d = new Patient_Dashboard();
       	    d.main(null);
       	    setVisible(false);
       	    
        }
        
        else if(userValue.equals("Doctor") && passValue.equals("Doctor")){
        	System.out.println(userValue +" Welcome to WellBiing Healthcare");
        	JOptionPane.showMessageDialog(null, "Welcome to WellBiing Healthcare");
        	Doctor_Dashboard d;
			d = new Doctor_Dashboard();
			d.main(null);
			
			setVisible(false);
			
			} 
        
        else{  
              
            System.out.println("Please enter a valid username and password"); 
            JOptionPane.showMessageDialog(null, "Invalid Login Credentials");
            }
	}
}



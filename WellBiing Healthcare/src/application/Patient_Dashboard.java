package application;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Cursor;



public class Patient_Dashboard extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String user;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Patient_Dashboard frame = new Patient_Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//private JTable table;
	private JPanel contentPane;
		JButton btnNewButton; 
		//private JTable table_1;
		JButton btnNewButton_1;
		private JTable table;
		String temper;
		String Heart;
		String SPO2;
		String[] values;
		String id;
		JFreeChart chart;
		
		
	
		public Patient_Dashboard() {
			user = Login_Page.name;
			if(user.equals("Doctor")) {
				user = Doctor_Dashboard.user;
			}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(26, 157, 120));
		panel.setForeground(Color.BLACK);
		contentPane.add(panel, "name_980601932358600");
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(18, 109, 84));
		panel_1.setBounds(0, 0, 1920, 80);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblHelloAdmin = new JLabel("");
		lblHelloAdmin.setForeground(new Color(255, 255, 255));
		lblHelloAdmin.setIcon(new ImageIcon(Patient_Dashboard.class.getResource("/img/male_user_50px.png")));
		lblHelloAdmin.setBounds(48, 0, 56, 78);
		panel_1.add(lblHelloAdmin);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Patient_Dashboard.class.getResource("/img/group_message_26px.png")));
		lblNewLabel_3.setBounds(1262, 0, 34, 78);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setBounds(231, 11, 34, 39);
		panel_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_1 = new JLabel("WellBiing Healthcare");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Leelawadee UI", Font.BOLD, 25));
		lblNewLabel_1.setBounds(560, 0, 400, 78);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton(" Logout");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(1374, 25, 113, 25);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(1306, 0, 34, 78);
		panel_1.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setIcon(new ImageIcon(Patient_Dashboard.class.getResource("/img/bell_26px.png")));
		
		JLabel lblNewLabel_1_1 = new JLabel("Hello, User");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Leelawadee UI", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(108, 0, 142, 78);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Latest Health Parameters");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Leelawadee UI", Font.BOLD, 30));
		lblNewLabel_2.setBounds(795, 99, 700, 52);
		panel.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(26, 157, 120));
		panel_2.setBounds(795, 161, 200, 200);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Spo2");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Leelawadee UI", Font.BOLD, 24));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 11, 200, 47);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_3 = new JLabel("%");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_3.setForeground(Color.WHITE);
		lblNewLabel_4_3.setFont(new Font("Leelawadee UI", Font.BOLD, 24));
		lblNewLabel_4_3.setBounds(86, 143, 21, 47);
		panel_2.add(lblNewLabel_4_3);
		
		
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(26, 157, 120));
		panel_2_1.setBounds(1046, 161, 200, 200);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("Heart Rate");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Leelawadee UI", Font.BOLD, 24));
		lblNewLabel_4_1.setBounds(0, 11, 200, 47);
		panel_2_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("BPM");
		lblNewLabel_4_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3_1.setForeground(Color.WHITE);
		lblNewLabel_4_3_1.setFont(new Font("Leelawadee UI", Font.BOLD, 24));
		lblNewLabel_4_3_1.setBounds(71, 143, 59, 47);
		panel_2_1.add(lblNewLabel_4_3_1);
		
		
		Graph_Creator gc = new Graph_Creator();
		
		
		
		
		int cond = 1;
		XYDataset tempdataset = gc.createDataset(user, cond);
        JFreeChart tempchart = gc.createChart(tempdataset, cond);
        
        cond = 2;
		XYDataset Heartdataset = gc.createDataset(user, cond);
        JFreeChart Heartchart = gc.createChart(Heartdataset, cond);
        
        cond = 3;
		XYDataset SpO2dataset = gc.createDataset(user, cond);
        JFreeChart SpO2chart = gc.createChart(SpO2dataset, cond);
        
        

        ChartPanel tempchartPanel = new ChartPanel(tempchart);
        tempchartPanel.setBounds(90, 99,600, 300);
        panel.add(tempchartPanel);
        
        ChartPanel HeartchartPanel = new ChartPanel(Heartchart);
        HeartchartPanel.setBounds(90,419,600, 300);
        panel.add(HeartchartPanel);
        
        ChartPanel SpO2chartPanel = new ChartPanel(SpO2chart);
        SpO2chartPanel.setBounds(840,420,600, 300);
        panel.add(SpO2chartPanel);
        
//        try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		JLabel lblNewLabel_5_1 = new JLabel((Double.toString(Graph_Creator.FinalHR)));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 60));
		lblNewLabel_5_1.setBounds(0, 68, 200, 67);
		panel_2_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBackground(new Color(26, 157, 120));
		lblNewLabel_7.setIcon(new ImageIcon(Patient_Dashboard.class.getResource("/img/green 200x200.png")));
		lblNewLabel_7.setBounds(0, 0, 200, 200);
		panel_2_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5 = new JLabel((Double.toString(Graph_Creator.FinalSpO2)));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 60));
		lblNewLabel_5.setBounds(0, 68, 200, 67);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBackground(new Color(26, 157, 120));
		lblNewLabel_6.setIcon(new ImageIcon(Patient_Dashboard.class.getResource("/img/red 200x200.png")));
		lblNewLabel_6.setBounds(0, 0, 200, 200);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4_3_1_1 = new JLabel("F");
		lblNewLabel_4_3_1_1.setBounds(1385, 304, 21, 47);
		panel.add(lblNewLabel_4_3_1_1);
		lblNewLabel_4_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_3_1_1.setFont(new Font("Leelawadee UI", Font.BOLD, 24));
		
		JLabel lblNewLabel_5_2 = new JLabel((Double.toString(Graph_Creator.Finaltemp)));
		lblNewLabel_5_2.setBounds(1295, 229, 200, 67);
		panel.add(lblNewLabel_5_2);
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setForeground(Color.WHITE);
		lblNewLabel_5_2.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 60));
		
		JLabel lblNewLabel_4_2 = new JLabel("Temperature");
		lblNewLabel_4_2.setBounds(1295, 172, 200, 47);
		panel.add(lblNewLabel_4_2);
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Leelawadee UI", Font.BOLD, 24));
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(1295, 161, 200, 200);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon(Patient_Dashboard.class.getResource("/img/blue 200x200.png")));
        
        
        //pack();
        setTitle("Patient Dashboard");
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	Login_Page l = new Login_Page();
                l.main(null);
                setVisible(false);
                
                
                	
               
            }
        });

		
	}
}

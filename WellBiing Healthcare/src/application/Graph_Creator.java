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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
  
  
class Graph_Creator extends JFrame {  
     
	static double Finaltemp;
	static double FinalSpO2;
	static double FinalHR;
	
	 public XYDataset createDataset(String user,int cond) {
		 if (cond==1) {
		 int j = 1;
		 var series = new XYSeries("Temp");
		 List l = new ArrayList();
		 	Get_Records jp = new Get_Records();
		 	try {
		 		jp.StartParsing();
		 		for(int i=0;i<40;i++) {
					String[] values = jp.ReadValues(i+1);
					String id = values[0];
					if (user.equals("user1")) {
						if(id.equals("1")) {
							l.add(Double.parseDouble(values[1]));
							j++;
						}
					}
					else if (user.equals("user2")) {
						if(id.equals("2")) {
							l.add(Double.parseDouble(values[1]));
							j++;
						}
					}
		 		}
			} catch (Exception e) {
				e.printStackTrace();
			}
		 	
		 	
		 	Collections.reverse(l);
		 	j = 1;
		 	for (Object i:l.toArray()) {
				series.add(j, (double) i);
				j++;
			}
		 	
		 	
	        var dataset = new XYSeriesCollection();
	        dataset.addSeries(series);
	        
	        Finaltemp = (double) series.getY(j-2);
	        System.out.println(Finaltemp);
	        
	        return dataset;
		 }
		 else if (cond==2) {
		 int j = 1;
		 var series = new XYSeries("HeartRate");
		 List l = new ArrayList();
		 	Get_Records jp = new Get_Records();
		 	try {
		 		jp.StartParsing();
		 		for(int i=0;i<40;i++) {
					String[] values = jp.ReadValues(i+1);
					String id = values[0];
					if (user.equals("user1")) {
						if(id.equals("1")) {
							l.add(Double.parseDouble(values[2]));
							j++;
						}
					}
					else if (user.equals("user2")) {
						if(id.equals("2")) {
							l.add(Double.parseDouble(values[2]));
							j++;
						}
					}
		 		}
			} catch (Exception e) {
				e.printStackTrace();
			}
		 	
		 	
		 	Collections.reverse(l);
		 	j = 1;
		 	for (Object i:l.toArray()) {
				series.add(j, (double) i);
				j++;
			}
		 	
		 	
	        var dataset = new XYSeriesCollection();
	        dataset.addSeries(series);
	        FinalHR = (double) series.getY(j-2);
	        System.out.println(FinalHR);
	        return dataset;
		 }
		 if (cond==3) {
			 int j = 1;
			 var series = new XYSeries("SpO2");
			 List l = new ArrayList();
			 	Get_Records jp = new Get_Records();
			 	try {
			 		jp.StartParsing();
			 		for(int i=0;i<40;i++) {
						String[] values = jp.ReadValues(i+1);
						String id = values[0];
						if (user.equals("user1")) {
							if(id.equals("1")) {
								l.add(Double.parseDouble(values[3]));
								j++;
							}
						}
						else if (user.equals("user2")) {
							if(id.equals("2")) {
								l.add(Double.parseDouble(values[3]));
								j++;
							}
						}
			 		}
				} catch (Exception e) {
					e.printStackTrace();
				}
			 	
			 	
			 	Collections.reverse(l);
			 	j = 1;
			 	for (Object i:l.toArray()) {
					series.add(j, (double) i);
					j++;
				}
			 	
			 	
		        var dataset = new XYSeriesCollection();
		        dataset.addSeries(series);
		        FinalSpO2 = (double) series.getY(j-2);
		        System.out.println(FinalSpO2);
		        return dataset;
			 }
		 
		return null;
		
		 
	 }
	 public JFreeChart createChart(XYDataset dataset, int cond) {
		 if (cond==1) {
		 JFreeChart chart = ChartFactory.createXYLineChart(
	                "Temperature",
	                "Temp(in F)",
	                "EntryNumber",
	                dataset,
	                PlotOrientation.VERTICAL,
	                true,
	                true,
	                false
	        );

	        XYPlot plot = chart.getXYPlot();

	        var renderer = new XYLineAndShapeRenderer();
	   
	        renderer.setSeriesPaint(0, Color.getHSBColor(0.54f, 1.00f, 0.40f));
	        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
	        plot.setRenderer(renderer);
	        
	        
	        plot.setBackgroundPaint(Color.white);
	        NumberAxis xAxis = new NumberAxis();
	        xAxis.setTickUnit(new NumberTickUnit(1));
	        NumberAxis yAxis = new NumberAxis();
	        yAxis.setTickUnit(new NumberTickUnit(2));
	        
	        plot.setDomainAxis(xAxis);
	        plot.setRangeAxis(yAxis);
	        
	        yAxis.setAutoRangeIncludesZero(false);
	        
	        plot.setRangeGridlinesVisible(true);
	        plot.setRangeGridlinePaint(Color.BLACK);

	        plot.setDomainGridlinesVisible(true);
	        plot.setDomainGridlinePaint(Color.BLACK);

	        chart.getLegend().setFrame(BlockBorder.NONE);
	        
//	        chart.setTitle(new TextTitle("Average Salary per Age",
//	                        new Font("Serif", java.awt.Font.BOLD, 18)
//	                )
//	        );

	        return chart;
		 }
		 if (cond==2) {
			 JFreeChart chart = ChartFactory.createXYLineChart(
		                "HeartRate",
		                "HeartRate",
		                "EntryNumber",
		                dataset,
		                PlotOrientation.VERTICAL,
		                true,
		                true,
		                false
		        );

		        XYPlot plot = chart.getXYPlot();

		        var renderer = new XYLineAndShapeRenderer();
		   
		        renderer.setSeriesPaint(0, Color.getHSBColor(0.37f, 0.50f, 0.51f));
		        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
		        plot.setRenderer(renderer);
		        
		        
		        plot.setBackgroundPaint(Color.white);
		        NumberAxis xAxis = new NumberAxis();
		        xAxis.setTickUnit(new NumberTickUnit(1));
		        NumberAxis yAxis = new NumberAxis();
		        yAxis.setTickUnit(new NumberTickUnit(10));
		        
		        plot.setDomainAxis(xAxis);
		        plot.setRangeAxis(yAxis);
		        
		        yAxis.setAutoRangeIncludesZero(false);
		        
		        plot.setRangeGridlinesVisible(true);
		        plot.setRangeGridlinePaint(Color.BLACK);

		        plot.setDomainGridlinesVisible(true);
		        plot.setDomainGridlinePaint(Color.BLACK);

		        chart.getLegend().setFrame(BlockBorder.NONE);
		        
//		        chart.setTitle(new TextTitle("Average Salary per Age",
//		                        new Font("Serif", java.awt.Font.BOLD, 18)
//		                )
//		        );

		        return chart;
			 }
		 if (cond==3) {
			 JFreeChart chart = ChartFactory.createXYLineChart(
		                "SpO2",
		                "SpO2",
		                "EntryNumber",
		                dataset,
		                PlotOrientation.VERTICAL,
		                true,
		                true,
		                false
		        );

		        XYPlot plot = chart.getXYPlot();

		        var renderer = new XYLineAndShapeRenderer();
		   
		        renderer.setSeriesPaint(0, Color.getHSBColor(0.99f, 0.59f, 0.51f));
		        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
		        plot.setRenderer(renderer);
		        
		        
		        plot.setBackgroundPaint(Color.white);
		        NumberAxis xAxis = new NumberAxis();
		        xAxis.setTickUnit(new NumberTickUnit(1));
		        NumberAxis yAxis = new NumberAxis();
		        yAxis.setTickUnit(new NumberTickUnit(2));
		        
		        plot.setDomainAxis(xAxis);
		        plot.setRangeAxis(yAxis);
		        
		        yAxis.setAutoRangeIncludesZero(false);
		        
		        plot.setRangeGridlinesVisible(true);
		        plot.setRangeGridlinePaint(Color.BLACK);

		        plot.setDomainGridlinesVisible(true);
		        plot.setDomainGridlinePaint(Color.BLACK);

		        chart.getLegend().setFrame(BlockBorder.NONE);
		        
//		        chart.setTitle(new TextTitle("Average Salary per Age",
//		                        new Font("Serif", java.awt.Font.BOLD, 18)
//		                )
//		        );

		        return chart;
			 }
		return null;
	 }
}
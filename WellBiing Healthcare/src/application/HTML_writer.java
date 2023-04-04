package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTML_writer {
	public void Write_html() {
		String code="<html>\r\n"
				+ "<head>\r\n"
				+ "<title>Data Visiualization Dashboard</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<table border=2 bordercolor=\"#000000\">\r\n"
				+ "<tr><td colspan=\"2\">\r\n"
				+ "<h1 align=\"center\" color=\"#00FFFF\">RFID, Heart Rate, Spo2, Temperature Data Monitoring </h1>\r\n"
				+ "</td></tr>\r\n"
				+ "<tr><td>\r\n"
				+"<center>"
				+ "<iframe width=\"450\" height=\"260\" style=\"border: 1px solid #cccccc;\" src=\"https://thingspeak.com/channels/1898562/charts/1?bgcolor=%23ffffff&color=%2309387f&dynamic=true&results=25&type=step&update=15\"></iframe>\r"
				+ "<iframe width=\"450\" height=\"260\" style=\"border: 1px solid #cccccc;\" src=\"https://thingspeak.com/channels/1898562/charts/2?bgcolor=%23ffffff&color=%23008000&dynamic=true&results=25&type=spline&update=15\"></iframe>\r\n"
				+ "<iframe width=\"450\" height=\"260\" style=\"border: 1px solid #cccccc;\" src=\"https://thingspeak.com/channels/1898562/charts/3?bgcolor=%23ffffff&color=%23d03248&dynamic=true&results=25&type=spline&update=15\"></iframe>\r"
				+ "<iframe width=\"450\" height=\"260\" style=\"border: 1px solid #cccccc;\" src=\"https://thingspeak.com/channels/1898562/charts/4?bgcolor=%23ffffff&color=%2300176c&dynamic=true&results=25&type=spline&update=15\"></iframe>\r\n"
				+"</center>"
				+ "</td>\r\n"
				+ "</html>";
		
		
		File f = new File("Data_visual.html");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(code);
			bw.close();
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	
	

}
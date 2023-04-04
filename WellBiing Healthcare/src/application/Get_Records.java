package application;



import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;


class Get_Records
{
	StringBuffer response = new StringBuffer();
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception
    {
    }
    	@SuppressWarnings("deprecation")
		public void StartParsing() throws Exception {
    		String cmnd = "http://api.thingspeak.com/channels/1898562/feed.json";
    		URL obj = new URL(cmnd);
    		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    		con.setRequestMethod("GET");
    		int responseCode = con.getResponseCode();
    		System.out.println("GET Response Code :: " + responseCode);
    		if (responseCode == HttpURLConnection.HTTP_OK) { // success
    			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    			String inputLine;
    			response = new StringBuffer();

    			while ((inputLine = in.readLine()) != null) {
    				response.append(inputLine);
    			}
    			in.close();
    			File f = new File("output.txt");
    			FileWriter fw = new FileWriter("output.txt");
    			fw.write(response.toString());
    			// print result
    			//System.out.println(response.toString());
    			
    		} else {
    			System.out.println("GET request not worked");
    		}
    	}
    	
        public String[] ReadValues(int i) throws Exception {
	        String txt = response.toString();
	        JSON_Parser p = new JSON_Parser();
	        String[] values = p.jsonparse(txt, i);
			return values;
        }
			
		public String[] ReadUserValues(String user,int i) throws Exception {
	        String txt = response.toString();
	        JSON_Parser p = new JSON_Parser();
	        String[] values = p.jsonparseUser(user, txt, i);
			return values;	
        }
        
        
    }




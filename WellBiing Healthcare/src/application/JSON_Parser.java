package application;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON_Parser {
	String RFID;
	String temp;
	String SpO2;
	String HR;
	long lastid;
	static long lastentry;
	
	public String[] jsonparse(String str,int i)
    {   
		String[] values = new String[4];
        Object obj = null;
        
		obj = new JSONValue().parse(str);
          
        // typecasting obj to JSONObject
        
        JSONObject jo = (JSONObject) obj;
        @SuppressWarnings("unchecked")
		Map<String, String> ch = ((Map<String, String>)jo.get("channel"));
        Iterator<Map.Entry<String, String>> itr1 = ch.entrySet().iterator();
        
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            if (pair.getKey().equals("last_entry_id")) {
            	this.lastid = (long) pair.getValue();
            }
            //System.out.println(pair.getKey() + " : " + pair.getValue());
        lastentry = lastid;
            
        }
        JSONArray feeds = (JSONArray)(jo.get("feeds"));
    
         		
        
        if(feeds.toString().contains("\"entry_id\":"+String.valueOf(lastid-i)))
        {
        	Iterator<JSONObject> it = feeds.iterator();
        	while (it.hasNext()) {
        	JSONObject j = it.next();
        	if (j.get("entry_id").equals(lastid-i+1)) {	
        	try {
    			RFID = (String) j.get("field1");
    			
    			SpO2 = (String) j.get("field2");
    			
    			HR = (String) j.get("field3");
    			
    			temp = (String) j.get("field4");
    		}
    		catch(NoSuchElementException e) {
    			continue;
    		}
        	}
        }
        	
        	
        }
        values = new String[]{RFID,temp, SpO2, HR };
		return values;
        
        
    }
	
	public String[] jsonparseUser(String user,String str,int i)
    {   
		String[] values = new String[4];
        Object obj = null;
        
		obj = new JSONValue().parse(str);
          
        // typecasting obj to JSONObject
        
        JSONObject jo = (JSONObject) obj;
        @SuppressWarnings("unchecked")
		Map<String, String> ch = ((Map<String, String>)jo.get("channel"));
        Iterator<Map.Entry<String, String>> itr1 = ch.entrySet().iterator();
        
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            if (pair.getKey().equals("last_entry_id")) {
            	this.lastid = (long) pair.getValue();
            }
            //System.out.println(pair.getKey() + " : " + pair.getValue());
            
        }
        JSONArray feeds = (JSONArray)(jo.get("feeds"));
    
         		
        
        if(feeds.toString().contains("\"entry_id\":"+String.valueOf(lastid-i)))
        {
        	Iterator<JSONObject> it = feeds.iterator();
        	while (it.hasNext()) {
        	JSONObject j = it.next();
        	System.out.println(user);
        	if(j.get("field1") != null) {
        	if (j.get("field1").equals("1")) {
        	if (j.get("entry_id").equals(lastid-i)) {	
        	try {
    			RFID = (String) j.get("field1");
    			
    			SpO2 = (String) j.get("field2");
    			
    			HR = (String) j.get("field3");
    			
    			temp = (String) j.get("field4");
    		}
    		catch(Exception e) {
    			continue;
    		}
        	}
        }
        }
        	else {
        		continue;
        	}
        	
        }
        }
        values = new String[]{RFID,temp, SpO2, HR };
		return values;
        
        
    }
}    
        
  



package DIY2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraping {
	
	public static  ArrayList<String> Region=new ArrayList<String>();  
	public static  ArrayList<String> Date=new ArrayList<String>();  
	
public static ArrayList<String> fanhui() throws IOException {
	
	
	for(int i = 1; i < 11; i++){
        Document doc =Jsoup.connect("https://www.emsc-csem.org/Earthquake/?view=" + i).get();
       

        Elements tables = doc.select("table");
    
        
        
        Elements tbody=tables.select("tbody tr");
        
       for(int j=10;j<tbody.size();j++)
       { 
    	   if(!(tbody.get(j).className().equals("autour")||
    			   tbody.get(j).className().equals("black")))
    	 //if(!tbody.get(j).id().substring(0, 1).equals("tr"))
    	   
    	   { 
    		 
    		   Region.add(tbody.get(j).select("td.tb_region").text());
    		   Date.add(tbody.get(j).select("td.tabev6").text().substring(10, 14)
    		  +tbody.get(j).select("td.tabev6").text().substring(15, 17)
    		  +tbody.get(j).select("td.tabev6").text().substring(18, 20)
    		  +tbody.get(j).select("td.tabev6").text().substring(21, 23)
    		  +tbody.get(j).select("td.tabev6").text().substring(24, 26)
    		  +tbody.get(j).select("td.tabev6").text().substring(27, 29)
    		  +tbody.get(j).select("td.tabev6").text().substring(30, 31)
    				  );
    	   }
        
       }
       
	}
	return Region;
	}
}
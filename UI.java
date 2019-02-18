package DIY2;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class UI implements Initializable  {

	
	
	@FXML
	private TableView<Person> table;
	@FXML
	private TableColumn<Person, String> ageCol;
	@FXML
	private TableColumn<Person, String> nameCol;
	@FXML 
	private ComboBox<String> cb; 
	@FXML 
	private DatePicker dp1; 
	@FXML 
	private DatePicker dp2; 
	
	@FXML 
	private  CategoryAxis xAxis ;
	@FXML 
    private  NumberAxis yAxis;
	
	@FXML 
	private BarChart<String,Number> bc; 
	
	private String[] plates = {"World-Wide", "NEVADA", "FRANCE", "KANSAS", "Arabian",
             "Cocos","Eurasian","Indian", "Australian", "Juan de Fuca",
             "Caribbean", "North-American", "Nazca"," Pacific", "Filipino", "South-American"};   
	
	
	ObservableList<Person> cellData = FXCollections.observableArrayList();
	
	//  XYChart.Series series1 = new XYChart.Series();
	  
	XYChart.Series series1 = new XYChart.Series();
	//XYChart.Series series2 = new XYChart.Series();
	
	//ObservableList<Series<String, Number>> series2 =FXCollections.observableArrayList()  ;
	ObservableList<Person> newcellData = FXCollections.observableArrayList();
	
	ObservableList<String> choices = FXCollections.observableArrayList(plates);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		   
	
		try {
			WebScraping.fanhui();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		for(int i=0;i<WebScraping.Region.size();i++)
		{
			//if(WebScraping.Region.get(i).length()!=0)
			cellData.add(new Person(WebScraping.Date.get(i),WebScraping.Region.get(i)));
		}
		ageCol.setCellValueFactory(cellData -> cellData.getValue().getDate());
		nameCol.setCellValueFactory(cellData -> cellData.getValue().getRegion());
		 
		//（3）为 TableView 添加数据
		table.setItems(cellData);

      cb.getItems().addAll(choices);
      
      
   
      cb.getSelectionModel().select(0); // [0, options.size())
      
      
      
      
      
      
      
      
      
      
      
      
      
     
      dp1.setValue(LocalDate.now());
      dp2.setValue(LocalDate.now());
      
      
      
      
      bc.setTitle("Country Summary");
      
      
      
      
      xAxis.setLabel("Region");       
      yAxis.setLabel("Number");
      
      
      
      
      
      
      series1.setName("All");
      series1.getData().addAll(new XYChart.Data<String,Number>("All",cellData.size()));  
	  bc.getData().add(series1);
	 // series1 = new XYChart.Series();
	  //bc.getData().add(series1);
      
      
	}
	
	
	
	public String getregion() {
	
		 return cb.getValue();
	}
	
	
	
	
	public LocalDate getdate1() {
		
		 return dp1.getValue();
	}
	
	
	public LocalDate getdate2() {
		
		 return dp2.getValue();
	}
	
	
	
	public void search() 
	
	{
		
		
		
	//	if(cb.getValue()!=null)
		
		{
		//ArrayList<Integer> numberbyplate=new ArrayList<Integer>();  
		
		
		Hashtable<String,Integer> numberbyplate=new Hashtable<String,Integer>();  
		
		
		
		
		
		
		int sumofthisregion=0;
		
		
		table.getItems().clear();

		bc.getData().clear();
		
		 LocalDate date1 = dp1.getValue();
		 LocalDate date2 = dp2.getValue();
		 
	/*	for(int k=Integer.parseInt(date1.toString().substring(0, 4)+date1.toString().substring(5, 7)+date1.toString().substring(8, 10));
				 k<=Integer.parseInt(date2.toString().substring(0, 4)+date2.toString().substring(5, 7)+date2.toString().substring(8, 10));
				 k++)
		 {
			 
			// numberbyplate.add(String.valueOf(k));
			 
			 
			 
			 
			 numberbyplate.put(String.valueOf(k), 0);
		 } 
		 
		 
		 */
		 
		 
		
	/*	System.out.print(date1.toString().substring(0, 4)+date1.toString().substring(5, 7)+date1.toString().substring(8, 10)
				+" "+    date2.toString().substring(0, 4)+date2.toString().substring(5, 7)+date2.toString().substring(8, 10));
		
	*/	
		
		
		
		
		WebScraping.Region=new ArrayList<String>();  
		
		try {
			WebScraping.fanhui();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		for(int i=0;i<WebScraping.Region.size();i++)
		{	
			
			if(Integer.parseInt(WebScraping.Date.get(i).substring(0, 8))
		>=Integer.parseInt(date1.toString().substring(0, 4)+date1.toString().substring(5, 7)+date1.toString().substring(8, 10))
		&&Integer.parseInt(WebScraping.Date.get(i).substring(0, 8))
		<=Integer.parseInt(date2.toString().substring(0, 4)+date2.toString().substring(5, 7)+date2.toString().substring(8, 10))) 
			{
			
			if(WebScraping.Region.get(i).toString().equals(getregion()))
			{
				
				newcellData.add(new Person(WebScraping.Date.get(i),WebScraping.Region.get(i)));
			sumofthisregion++;
			
			//for(int k=0;k<numberbyplate.size();k++)
			
		//	{
				
				
		/*		if(numberbyplate.containsKey(WebScraping.Date.get(i).substring(0, 8)))
			
				
				{
					
					//int num=numberbyplate.get(Integer.parseInt(WebScraping.Date.get(i).substring(0, 8)));
					//numberbyplate.set(Integer.parseInt(WebScraping.Date.get(i).substring(0, 8)), num+1);
					
					System.out.println(WebScraping.Date.get(i).substring(0, 8)+" ");
					
					
					//numberbyplate.numberbyplate.get(WebScraping.Date.get(i).substring(0, 8))+1;
				}
				
				
				*/
				
				
		//	}
				if(numberbyplate.containsKey(WebScraping.Date.get(i).substring(0, 8)))
						{
						int a=numberbyplate.get(WebScraping.Date.get(i).substring(0, 8));
						a=a+1;
						numberbyplate.put(WebScraping.Date.get(i).substring(0, 8), a);
						}
				else
						{
						numberbyplate.put(WebScraping.Date.get(i).substring(0, 8), 1);
						}
				
				
			}
			
			
			}
		
		}
		
		ageCol.setCellValueFactory(newcellData -> newcellData.getValue().getDate());
		nameCol.setCellValueFactory(newcellData -> newcellData.getValue().getRegion());
		 
		//（3）为 TableView 添加数据
		table.setItems(newcellData);
		
		
		
		
		 XYChart.Series<String, Number> series2 = new XYChart.Series<>();
		
		
		 
	    //  series2.setName(getregion());
	      
	      
	    //  System.out.print("之前"+series2.getData()+" ");
	   //   series2.getData().addAll(new XYChart.Data<String,Number>(getregion(),newcellData.size()));  
	      
		 
		 
		
	      for(Iterator<String> iterator=numberbyplate.keySet().iterator();iterator.hasNext();)
	      
	      
	      
	      	  {
	    	  
	    	  String key=iterator.next();
	    	  //series2.getData().addAll(new XYChart.Data<String,Number>(key,numberbyplate.get(key))); 
	    	  //series2.getData().add(new XYChart.Data(key,numberbyplate.get(key)));
	    	  
	    	  series2.getData().add(new XYChart.Data<String, Number>(key,numberbyplate.get(key)));
	    	 // System.out.println("key-----"+key);
	    	 // System.out.println("value--------"+numberbyplate.get(key));
	    	  
	      	  }
	      
	     // series2.getData().addAll(numberbyplate.,);  
	      
	  //    System.out.println("之后"+series2.getData());
	      
	      bc.setAnimated(false);

	      bc.getData().addAll(series2);
	      
	      
	   
	      //bc.setBarGap(300);
	     // bc.setCategoryGap(800);
	     // bc.getData().setAll(series2);
	     //bc.getData().set(0, series2);
		
	
		
	    //  bc.setBarGap(3);
	      //bc.setCategoryGap(20);
	       
	//  System.out.println(numberbyplate.toString());
	       
	       
		
		
	}
	}
}

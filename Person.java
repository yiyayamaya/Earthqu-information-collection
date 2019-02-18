package DIY2;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	private StringProperty date;
	private StringProperty region;
			
	public Person(String date, String region) {
		super();
		this.date = new SimpleStringProperty(date);
		this.region = new SimpleStringProperty(region);
	}
			
	public StringProperty getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = new SimpleStringProperty(date);
	}
	public StringProperty getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = new SimpleStringProperty(region);
	}
}
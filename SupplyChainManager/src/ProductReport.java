import java.time.Duration;
import java.util.ArrayList;

public class ProductReport extends DataBaseObject{

	private Product product;
	private Duration duration;
	private ArrayList<Person> persons = new ArrayList<>();
	private String suggestions;
	
	public ProductReport(Product product, Duration duration, ArrayList<Person> persons, String suggestions) {
		this.product = product;
		this.duration = duration;
		this.persons = persons;
		this.suggestions = suggestions;
	}
	
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public ArrayList<Person> getPersons() {
		return persons;
	}
	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}
	public String getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}
	
	@Override
	public void save() {
		DataBase.getDB().addProductReport(this);
		
	}

}

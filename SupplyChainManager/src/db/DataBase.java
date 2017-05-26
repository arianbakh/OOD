package db;

import java.util.ArrayList;

public class DataBase {
	private static DataBase db = null;
	
	private ArrayList<Product> products = new ArrayList<>();

	private ArrayList<ProductOrder> productOrders = new ArrayList<>();
	private ArrayList<CustomerOrder> customerOrders = new ArrayList<>();
	private ArrayList<Component> components = new ArrayList<>();
	private ArrayList<Supplier> suppliers = new ArrayList<>();
	private ArrayList<Deliverer> deliverers = new ArrayList<>();
	private ArrayList<ProductReport> productReports = new ArrayList<>();
	private ArrayList<Person> persons = new ArrayList<>();
	 
	private DataBase(){
		
	}
	
	public static DataBase getDB(){
		if (db == null)
			db = new DataBase();
		return db;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public ArrayList<ProductOrder> getProductOrders() {
		return productOrders;
	}
	
	public ArrayList<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}
	
	public ArrayList<Component> getComponents() {
		return components;
	}
	
	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}
	
	public ArrayList<Deliverer> getDeliverers() {
		return deliverers;
	}
	
	public ArrayList<ProductReport> getProductReports() {
		return productReports;
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void addProduct(Product product){
		this.products.add(product);
	}

	public void addProductOrder(ProductOrder productOrder){
		this.productOrders.add(productOrder);
	}
	
	public void addCustomerOrder(CustomerOrder customerOrder){
		this.customerOrders.add(customerOrder);
	}
	
	public void addComponent(Component component){
		this.components.add(component);
	}
	
	public void addSupplier(Supplier supplier){
		this.suppliers.add(supplier);
	}
	
	public void addDeliverer(Deliverer deliverer){
		this.deliverers.add(deliverer);
	}
	
	public void addProductReport(ProductReport productReport){
		this.productReports.add(productReport);
	}
	
	public void addPerson(Person person){
		this.persons.add(person);
	}
	
}

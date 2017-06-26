package database;

import java.util.ArrayList;

import model.Supplier;
import model.customerOrder.CustomerOrder;
import model.customerOrder.Deliverer;
import model.order.Person;
import model.product.Component;
import model.product.Product;
import model.productOrder.ProductOrder;
import model.productOrder.ProductOrderReport;

public class DataBase {
	private static DataBase db = null;
	
	private ArrayList<Product> products = new ArrayList<>();

	private ArrayList<ProductOrder> productOrders = new ArrayList<>();
	private ArrayList<CustomerOrder> customerOrders = new ArrayList<>();
	private ArrayList<Component> components = new ArrayList<>();
	private ArrayList<Supplier> suppliers = new ArrayList<>();
	private ArrayList<Deliverer> deliverers = new ArrayList<>();
	private ArrayList<ProductOrderReport> productOrderReports = new ArrayList<>();
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
	
	public ArrayList<ProductOrderReport> getProductOrderReports() {
		return productOrderReports;
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
	
	public void addProductOrderReport(ProductOrderReport productReport){
		this.productOrderReports.add(productReport);
	}
	
	public void addPerson(Person person){
		this.persons.add(person);
	}
	
}

import java.util.ArrayList;

public class Product extends DataBaseObject {

	private ArrayList<Component> components = new ArrayList<>();
	private int stock = 0;
	private int minStock;
	private int maxStock;
	
	public Product(ArrayList<Component> components, int minStock, int maxStock){
		this.components = components;
		this.stock = 0;
		this.minStock = minStock;
		this.maxStock = maxStock;
	}
	
	public int getMinStock() {
		return minStock;
	}
	
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	
	public int getMaxStock() {
		return maxStock;
	}
	
	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}
	
	public ArrayList<Component> getComponents() {
		return components;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void decreaseStock() throws Exception{
		if (stock > 0){
			stock--;
			if (stock < minStock) {
				ProductOrder po = new ProductOrder(this); 
				po.save();
			}
		} else {
			throw new Exception();
		}
	}
	
	public void increaseStock(int num) {
		stock += num;
	}


	@Override
	public void save() {
		DataBase.getDB().addProduct(this);
		
	}
	
}

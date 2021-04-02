public class Product { 
	private String name;
	private String type;
	private double price;
	private int quantity;

	public Product(String name, String type, double price, int quantity) { 
	    this.name = name;
	    this.type = type;
	    this.price = price;
	    this.quantity = quantity;
	}

	//getters and setters 
	public String getName() { 
	    return this.name;
	}

	public void setName(String name) { 
	    this.name = name;
	}	    

	public String getType() { 
	    return this.type;
	}

	public void setType(String type) { 
	    this.type = type;
	}

	public double getPrice() { 
		return price;
	}
	
	public void setPrice(double price) { 
	    this.price = price;
	}

	public int getQuantity() { 
	    return quantity;
	}

	public void setQuantity(int quantity) { 
	    this.quantity = quantity;
	}

	@Override
	public String toString() { 
	    return name + "," + type + "," + price + "," + quantity;
	}

}

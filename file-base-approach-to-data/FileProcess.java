import java.util.*;
import java.io.*;

public class FileProcess { 
	
	public static void main(String[] args) throws IOException{
	
		File productFile = new File("Inventory.csv");
		Scanner input = new Scanner(productFile);
		//reading and storing data
		ArrayList<Product> products = new ArrayList<>();
		String header =	input.nextLine(); // skipping first line
		while(input.hasNext()) { 
		   String line = input.nextLine();
		   String[] row = line.split(","); // name , type, price, quantity
		   Product temp = new Product(row[0], row[1], Double.valueOf(row[2]), Integer.valueOf(row[3]));
		   products.add(temp);
		}

		//processsing data
		//Change the price of an item, for example increase the price of Snickers to 2.25	
		for(Product product : products) { 
		    if(product.getName().equals("Snickers"))
			product.setPrice(2.25);	
		}
		//Change the quantity of an item, for example, a customer purchases 2
		//Coca Colas so we should reduce the number in quantity
		for(Product product : products) { 
		    if(product.getName().equals("Coca Cola"))
			product.setQuantity(product.getQuantity() - 1);	
		}
		//add an item, for example we need to add an item for "Dogadan Yesil Cay" with the type being "Coffee and Tea".
		Product cay = new Product("Dogadan Yesil Cay",  "Coffee and Tea", 6.49, 10);
		products.add(cay);

		// creating and writing new products to new file 	
		File updatedProductFile = new File("output.csv");
		PrintWriter output = new PrintWriter(updatedProductFile); 
		output.println(header);//write headers
		for(Product product : products)
		    output.println(product);
		output.close();

		//deteting inital file
		if(productFile.delete())
		    System.out.println("File deleted: " + productFile.getName());
		else
		    throw new IOException("file couldn't deleted");
		//rename updated file
		File inventoryFile = new File("Inventory.csv");
		if(inventoryFile.exists())
		    throw new IOException("file couldn't deleted" + updatedProductFile);
	        if(!updatedProductFile.renameTo(inventoryFile))
		    throw new IOException("file coulnt't renamed" + updatedProductFile);



	}

}




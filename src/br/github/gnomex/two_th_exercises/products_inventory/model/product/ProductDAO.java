package br.github.gnomex.two_th_exercises.products_inventory.model.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.github.gnomex.two_th_exercises.products_inventory.model.Product;
import static br.github.gnomex.two_th_exercises.products_inventory.common.DatabaseDefinitions.*;

public class ProductDAO implements IProductDAO{

	private File file = new File(PRODUCTSFILENAME);
	
	private FileOutputStream out;
	private FileInputStream in;
	
	public ProductDAO() {
		try {
			this.out = new FileOutputStream(file);
			this.in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void writeOnFile( Product dm )	{

		ObjectOutputStream os = null;

		try {

			os = new ObjectOutputStream(out);
			os.writeObject(dm);

			os.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private List<Product> readFromFile(){

		ObjectInputStream oi = null;
		
		ArrayList<Product> records = new ArrayList<Product>();
		
		try {
			
			oi = new ObjectInputStream(in);
			
			while (true){
				
				Product record = (Product) oi.readObject();
				records.add(record);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		
		try {
			
			oi.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return records;
	}
	
	
	@Override
	public List<Product> getAll() {
		return this.readFromFile();
	}

	@Override
	public Boolean saveAll(List<Product> products) {
		try {
			
			for( Product pd : products )	{
				this.writeOnFile(pd);
			}
			
			return Boolean.TRUE;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return Boolean.FALSE;
	}

}

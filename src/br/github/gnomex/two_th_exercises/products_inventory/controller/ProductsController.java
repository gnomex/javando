package br.github.gnomex.two_th_exercises.products_inventory.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.github.gnomex.two_th_exercises.products_inventory.model.Product;
import br.github.gnomex.two_th_exercises.products_inventory.model.product.ProductDAO;


public class ProductsController implements IProductsController{

	private ArrayList<Product> products;
	private ProductDAO productDAO;
	
	public ProductsController()	{
		productDAO = new ProductDAO();
		
		this.products = (ArrayList<Product>) productDAO.getAll();
		makeSort();
	}
	
	@Override
	public Product createProduct(Product product) {
		
		if ( validadeProduct(product) ) {
			
			product.setID(getANewID());
			products.add(product);
			
			return product;
		}
		
		//@Fix-Later!!!
		return null;
	}

	
	/**
	 * Only the first instance!!!
	 * */
	@Override
	public Product findByName(Product product) {
		
		Product target = null;
		
		for( Product pd : products)	{
			if ( pd.getName() == product.getName() ) {
				target = pd;
			}
		}
		
		return target;
	}

	/**
	 * Only the first instance!!!
	 * */
	@Override
	public Product findByID(Product product) {
		
		Product target = null;
		
		for( Product pd : products)	{
			if ( pd.getID() == product.getID() ) {
				target = pd;
			}
		}
		
		return target;
	}

	@Override
	public Product updateProduct(Product product) {
		Product target = null;
		
		for( Product pd : products)	{
			if ( pd.getID() == product.getID() ) {
				target = pd;
			}
		}
		
		products.remove(target);
		
		return this.createProduct(product);
	}

	@Override
	public Boolean deleteProduct(Product product) {
		Product target = null;
		
		for( Product pd : products)	{
			if ( pd.getID() == product.getID() ) {
				target = pd;
			}
		}
		
		return products.remove(target);
	}

	@Override
	public List<Product> getAll() {
		makeSort();
		return this.products;
	}

	@Override
	public Boolean saveAll(List<Product> products) {
		makeSort();
		
		return this.productDAO.saveAll(products);
	}

	private Boolean validadeProduct(Product product)	{
		return product.isValid();
	}
	
	private Integer getANewID()	{
		return this.products.size() + 1;
	}
	
	private void makeSort()	{
		try {
			Collections.sort(this.products);
		} catch (Exception e) {
			System.out.println("Cannot sort the array, see yourself: " + e.getMessage() + "\n\n");
			e.printStackTrace();
		}
	}
	
}

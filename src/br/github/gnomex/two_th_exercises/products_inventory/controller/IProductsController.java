package br.github.gnomex.two_th_exercises.products_inventory.controller;

import java.util.List;

import br.github.gnomex.two_th_exercises.products_inventory.model.Product;


public interface IProductsController {

	public Product createProduct( Product product );
	
	public Product findByName( Product product );
	public Product findByID( Product product );
	
	public Product updateProduct( Product product );
	
	public Boolean deleteProduct( Product product );
	
	public List<Product> getAll();
	public Boolean saveAll( List<Product> products );
	
}

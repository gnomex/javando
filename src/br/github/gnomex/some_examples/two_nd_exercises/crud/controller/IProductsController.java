package br.github.gnomex.some_examples.two_nd_exercises.crud.controller;

import java.util.List;

import br.github.gnomex.some_examples.two_nd_exercises.crud.model.Product;

public interface IProductsController {

	public Product createProduct( Product product );
	
	public Product findByName( Product product );
	public Product findByID( Product product );
	
	public Product updateProduct( Product product );
	
	public Boolean deleteProduct( Product product );
	
	public List<Product> getAll();
	public Boolean saveAll( List<Product> products );
	
}

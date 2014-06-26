package br.github.gnomex.two_th_exercises.products_inventory.model.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import br.github.gnomex.two_th_exercises.products_inventory.model.order.item.Item;


public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date orderDate;
	private Float price;
	
	private ArrayList<Item> items;
	
}

package br.github.gnomex.some_examples.two_nd_exercises.crud.model.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import br.github.gnomex.some_examples.two_nd_exercises.crud.model.order.item.Item;

public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date orderDate;
	private Float price;
	
	private ArrayList<Item> items;
	
}

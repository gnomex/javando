package br.github.gnomex.some_examples.two_nd_exercises.crud.model.order;

import java.util.ArrayList;
import java.util.Date;

import br.github.gnomex.some_examples.two_nd_exercises.crud.model.order.item.Item;

public class Sell {
	private static final long serialVersionUID = 1L;

	private Date buyingDate;
	private Float totalPrice = new Float(0);
	private Float discountPrice = new Float(0);
	
	private ArrayList<Item> items;
	
}

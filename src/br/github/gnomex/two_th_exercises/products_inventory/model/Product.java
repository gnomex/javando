package br.github.gnomex.two_th_exercises.products_inventory.model;

import java.io.Serializable;

public class Product implements Serializable, Comparable<Product>{

	private static final long serialVersionUID = 1L;
	
	private Integer ID;
	private String name;
	private Integer stock;
	private Float custPrice;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result
				+ ((custPrice == null) ? 0 : custPrice.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((stock == null) ? 0 : stock.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (custPrice == null) {
			if (other.custPrice != null)
				return false;
		} else if (!custPrice.equals(other.custPrice))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Product other) {
		if ( this.ID < other.getID() )	{
			return -1;
		}
		if (this.ID > other.getID() )	{
			return 1;
		}
		return 0;
	}
	
	//	setters and getter
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return stock;
	}
	public void setQuantity(Integer quantity) {
		this.stock = quantity;
	}
	public Float getCustPrice() {
		return custPrice;
	}
	public void setCustPrice(Float custPrice) {
		this.custPrice = custPrice;
	}

	public Boolean isValid() {
		if ( !this.name.isEmpty() && 
			  this.stock >= 0 && 
			  this.custPrice >= 0 
			) {
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}
}

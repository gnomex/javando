package br.github.gnomex.lists;

import java.io.Serializable;

public class Node<T extends Comparable<T>> implements Serializable, Comparable<Node>{

	private static final long serialVersionUID = 1L;
	
	private Node<T> next = null;	//Next node
	private Node<T> previous = null;	//Previous node
	private T something;	//The data
		
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public Node<T> getPrevious() {
		return previous;
	}
	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}
	
	public T getContent()	{
		return this.something;
	}
	
	public void setSomething(T something) {
		this.something = something;
	}
	
	@Override
	public String toString() {
		return "Node [content= " + something + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result
				+ ((previous == null) ? 0 : previous.hashCode());
		result = prime * result
				+ ((something == null) ? 0 : something.hashCode());
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node<T> other = (Node<T>) obj;
		if (something == null) {
			if (other.something != null)
				return false;
		} else if (!something.equals(other.something))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Node o) {
	   return something.compareTo((T) o.getContent());
	}
}

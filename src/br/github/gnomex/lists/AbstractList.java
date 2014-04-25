package br.github.gnomex.lists;

import java.io.Serializable;
import java.util.Iterator;

import br.github.gnomex.sort.Sort;

public abstract class AbstractList<T> implements Serializable, Sort{

	private static final long serialVersionUID = 1L;

	private Node<T> head = null;
	private Node<T> tail = null;
	private Integer size = new Integer(0);
	
	public int size() {
		return this.size();
	}

	public boolean isEmpty() {
		return (this.head != null) && (size == 0);
	}
	
	public boolean contains(T o) {
		return (indexOf(o) != -1);
	}

	public abstract Iterator<T> iterator();

	public abstract boolean add(T t);	//Append element
	public abstract boolean add(Node<T> t);	//Append element
	public abstract boolean add(int index, T element);	//Insert on index if it is possible or append

	public abstract boolean remove(T t);	//Only remove the element
	public abstract boolean remove(Node<T> t);	//Only remove the element	
	public abstract Node<T> remove(int index);	//Remove and return the element

	public Node<T> getFirst()	{
		if ( head != null )	{
			return head;
		}	else 
			return null;
	}
	
	public Node<T> getTail()	{
		if ( tail != null )	{
			return tail;
		}	else 
			return null;
	}
	
	public abstract Node<T> get(int index);

	public abstract int indexOf(T t);
	public abstract int indexOf(Node<T> t);

	public abstract int lastIndexOf(T t);
	public abstract int lastIndexOf(Node<T> t);
	
}

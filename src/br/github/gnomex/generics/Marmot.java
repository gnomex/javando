package br.github.gnomex.generics;

import java.util.ArrayList;

import br.github.gnomex.generics.exceptions.MarmotException;

public class Marmot<T> {

	private ArrayList<T> marmots = new ArrayList<T>();
	
	public void push(T something)	{
		marmots.add(something);
	}
	
	public T pop()	throws MarmotException{
		try {
			
			T lol = marmots.get(0);
			marmots.remove(0);
			
			return lol;
			
		} catch (Exception e) {
			throw new MarmotException("Não funfou!!!  " + e.getMessage());
		}
	}
	
	public Integer lenght()	{
		return marmots.size();
	}
	
}

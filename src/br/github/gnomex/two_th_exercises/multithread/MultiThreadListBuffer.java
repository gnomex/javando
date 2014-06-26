package br.github.gnomex.two_th_exercises.multithread;

import java.util.concurrent.ArrayBlockingQueue;

public class MultiThreadListBuffer {

	private ArrayBlockingQueue<Integer> list;
	
	public MultiThreadListBuffer()	{
		list = new ArrayBlockingQueue<>(100);
	}
	
	public synchronized void set( Integer value ) throws Exception	{
		list.put(value);
		System.out.println("Producer puts: " + value + ". List cells: " + list.size());
	}
	
	public synchronized Integer get() throws Exception	{
		Integer value = list.take();
		System.out.println(" Somewhere gets: " + value + " from list");
		return value;
	}
	
}

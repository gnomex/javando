package br.github.gnomex.two_th_exercises.multithread;

import java.util.concurrent.ArrayBlockingQueue;

public class MultiThreadListBuffer {

	private ArrayBlockingQueue<Integer> list;
	private Boolean occuped = Boolean.FALSE;
	
	public MultiThreadListBuffer()	{
		list = new ArrayBlockingQueue<>(100);
	}
	
	public synchronized void set( Integer value ) throws Exception	{
		while(occuped)	{
			System.out.println("Whait, bro.");
			wait();
		}
		
		occuped = Boolean.TRUE;
		
		list.put(value);
		System.out.println("Producer puts: " + value + ". List cells: " + list.size());
		notifyAll();
	}
	
	public synchronized Integer get() throws Exception	{
		while (!occuped){
			wait();
		}
		
		occuped = Boolean.FALSE;
		
		Integer value = list.take();
		System.out.println(" Somewhere gets: " + value + " from list");
		
		notifyAll();
		
		return value;
	}
	
}

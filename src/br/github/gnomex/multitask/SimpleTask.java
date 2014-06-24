package br.github.gnomex.multitask;

import java.util.Random;

public class SimpleTask implements Runnable {

	private int time;
	private int ttl = 10;
	private String name;
	private static Random rand = new Random();
	
	public SimpleTask(String message)	{
		name = message;
		this.getTime();
	}
	
	private void getTime()	{
		time = rand.nextInt(2000);
	}
	
	@Override
	public void run() {
		try	{
			
			while (ttl > 0)	{
				System.out.println( name + " says: Hey, I'll sleep for " + time + " miliseconds!!!");
				Thread.sleep(time);
				
				this.ttl--;
				this.getTime();
			}
			
			System.out.println( name + " says: my ttl is zero. Good bye! ");
			
		} catch (Exception e)	{
			e.printStackTrace();
		}
	}
	
}

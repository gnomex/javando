package br.github.gnomex.multitask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleTaskExecutor {


	public static void main(String[] args) {
		SimpleTask t1 = new SimpleTask("One");
		SimpleTask t2 = new SimpleTask("Two");
		SimpleTask t3 = new SimpleTask("Three");
		
		ExecutorService slave = Executors.newFixedThreadPool(3);
		
		slave.execute(t1);
		slave.execute(t3);
		slave.execute(t2);
		slave.shutdown();
		
		System.out.println("The show will starts now!!!");	
	}
	
}

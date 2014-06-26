package br.github.gnomex.two_th_exercises.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SlaveExecutor {

	public static void main(String[] args) {
		
		MultiThreadListBuffer buffer = new MultiThreadListBuffer();
		
		Consumer c1 = new Consumer(buffer);
		Consumer c2 = new Consumer(buffer);
		Consumer c3 = new Consumer(buffer);
		Consumer c4 = new Consumer(buffer);
		
		Producer p1 = new Producer(buffer);
		Producer p2 = new Producer(buffer);
		
		System.out.println("LOL");
		
		ExecutorService slave = Executors.newFixedThreadPool(6);
		slave.execute(p1);
		slave.execute(p2);
		slave.execute(c1);
		slave.execute(c2);
		slave.execute(c3);
		slave.execute(c4);
		slave.shutdown();
	}
	
}

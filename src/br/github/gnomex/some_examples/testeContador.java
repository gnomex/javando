package br.github.gnomex.some_examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

import br.github.gnomex.multitask.SimpleTask;

public class testeContador {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Contador());
		frame.setSize(200, 75);
		frame.setVisible(true);
		
		
	    Contador tc1 = new Contador();

	    Counter tc2 = new Counter();
	    
	    SimpleTask task = new SimpleTask("Marco Véio");
		
	    
		ExecutorService slave = Executors.newFixedThreadPool(3);
		
		slave.execute(tc1);
		slave.execute(tc2);
		slave.execute(task);
		slave.shutdown();
		
	}

}
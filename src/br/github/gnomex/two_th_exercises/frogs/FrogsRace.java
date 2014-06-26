package br.github.gnomex.two_th_exercises.frogs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FrogsRace {

	private Scenario scenario = new Scenario();
	
	public void doATestRace()	{
		Frog f1 = new Frog("Crazy Frog", 1, 3, 5, 300L , scenario);
		Frog f2 = new Frog("Crazy Frog", 2, 4, 3, 400L , scenario);
		Frog f3 = new Frog("Crazy Frog", 3, 5, 2, 350L , scenario);
		Frog f4 = new Frog("Crazy Frog", 4, 3, 8, 800L , scenario);
		
		System.out.println("Começando a corrida!!!");
		
		ExecutorService slave = Executors.newFixedThreadPool(4);
		slave.execute(f1);
		slave.execute(f2);
		slave.execute(f3);
		slave.execute(f4);
		slave.shutdown();
		
		System.out.println("Terminando a corrida!!!");
		
	}
	
	public static void main(String[] args) {
		FrogsRace fr = new FrogsRace();
		fr.doATestRace();
	}
	
}

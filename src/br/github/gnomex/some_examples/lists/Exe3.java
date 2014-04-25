package br.github.gnomex.some_examples.lists;

import java.util.Random;

import br.github.gnomex.lists.SimpleLinkedList;

	/**
	 * Modificar a classe ListaDupEnc incluindo um método de ordenação
	 * que ao ser chamado coloca os elementos da lista em ordem crescente
	 * ou decrescente
	 * */

public class Exe3 {

	private SimpleLinkedList<String> list = new SimpleLinkedList<String>();
	
	public void populeteWithDummieStubs()	{
		
		Random rand = new Random(1000);
		
		for (int i = 0; i < 100; i++) {
			list.add("Marmot " + i + rand.nextInt());
		}
	}
	
	public void showMarmots()	{
		for (String no : list) {
			System.out.println(" -" + no);
		}
	}
	
	public void doSort()	{
		
	}
	
	public static void main(String[] args) {
		Exe3 exe3 = new Exe3();
		
		try {
			
			exe3.populeteWithDummieStubs();
			exe3.showMarmots();
			exe3.doSort();
			
			System.out.println(" #=> Ordened");
			
			exe3.showMarmots();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}

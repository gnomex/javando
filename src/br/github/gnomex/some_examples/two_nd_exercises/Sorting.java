package br.github.gnomex.some_examples.two_nd_exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import br.github.gnomex.lists.Node;

public class Sorting {

	private ArrayList<Node<Integer>> aList;
	private LinkedList<Node<Integer>> lList;
	
	public Sorting()	{
		aList = new ArrayList<>();
		lList = new LinkedList<>();
	}
	
	public void sort()	{
		Collections.sort(aList);
		Collections.sort(lList);
	}
	
	public void fillLists()	{
		Random rand = new Random();
		
		for (int i = 0; i < 100; i++) {
			int  n = rand.nextInt(500) + 1;
			Node<Integer>  node = new Node<>();
			node.setSomething( n );
			aList.add(node);
		}
		for (int i = 0; i < 100; i++) {
			int  n = rand.nextInt(1000) + 1;
			Node<Integer>  node = new Node<>();
			node.setSomething( n );
			lList.add(node);
		}
		
	}
	
	public void printArrays()	{
		System.out.println("ArrayList");
		for (Node<Integer> nd : aList ) {
			System.out.println(nd.toString());
		}
		System.out.println("LinkedList");
		for (Node<Integer> nl : lList)	{
			System.out.println(nl.toString());
		}
	}
	
	public static void main(String[] args) {
		
		Sorting sorting = new Sorting();
		sorting.fillLists();
		sorting.printArrays();
		sorting.sort();
		System.out.println("Seee:");
		sorting.printArrays();
		
	}
	
}

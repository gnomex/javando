package br.github.gnomex.two_th_exercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import br.github.gnomex.lists.Node;
import br.github.gnomex.sort.SortingStrategyPattern;
import br.github.gnomex.sort.algorithms.Magic;

public class Strategifi {

	private ArrayList<Node<String>> aList;
	private LinkedList<Node<String>> lList;
	
	private SortingStrategyPattern sorting = new Magic();
	
	public Strategifi()	{
		aList = new ArrayList<>();
		lList = new LinkedList<>();
	}
	
	public void sort()	{
		aList = (ArrayList<Node<String>>) sorting.sort(aList);
		lList = (LinkedList<Node<String>>) sorting.sort(lList);
	}
	
	public void fillLists()	{
		Random rand = new Random();
		
		for (int i = 0; i < 10; i++) {
			int  n = rand.nextInt(500) + 1;
			Node<String>  node = new Node<>();
			node.setSomething(Integer.toString(i + n));
			aList.add(node);
		}
		for (int i = 0; i < 10; i++) {
			int  n = rand.nextInt(1000) + 1;
			Node<String>  node = new Node<>();
			node.setSomething(Integer.toString(i + n));
			lList.add(node);
		}
		
	}
	
	public void printArrays()	{
		System.out.println("ArrayList");
		for (Node<String> nd : aList ) {
			System.out.println(nd.toString());
		}
		System.out.println("LinkedList");
		for (Node<String> nl : lList)	{
			System.out.println(nl.toString());
		}
	}
	
	public static void main(String[] args) {
		
		Strategifi sorting = new Strategifi();
		sorting.fillLists();
		sorting.printArrays();
		sorting.sort();
		System.out.println("Seee:");
		sorting.printArrays();
		
	}
	
}

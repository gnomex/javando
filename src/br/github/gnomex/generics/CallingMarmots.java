package br.github.gnomex.generics;

import br.github.gnomex.generics.exceptions.MarmotException;

public class CallingMarmots {

	public static void MarmotsWithString()	{
		Marmot<String> marmotas = new Marmot<String>();

		for (int i = 0; i < 100; i++) {
			marmotas.push("Marmota " + i );			
		}

		System.out.println("Have " + marmotas.lenght() + " marmotas");

		try {
			System.out.println(marmotas.pop() + " Killed!!!");
		} catch (MarmotException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			System.out.println("More Marmots");

			for (int i = 0; i < 50 ; i++) {

				System.out.println(marmotas.pop() + " Killed!!!");

			}

			System.out.println("Have yet " + marmotas.lenght() + " marmotas");

		} catch (MarmotException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			System.out.println("Lets kill!!!");

			for (int i = 0; i < marmotas.lenght(); i++) {

				System.out.println(marmotas.pop() + " Killed!!!");

			}

		} catch (MarmotException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void MarmotsWithInteger()	{
		Marmot<Integer> marmotas = new Marmot<Integer>();

		for (int i = 0; i < 100; i++) {
			marmotas.push(new Integer(i));			
		}

		System.out.println("Have " + marmotas.lenght() + " marmotas");

		try {
			System.out.println(marmotas.pop() + " Killed!!!");
		} catch (MarmotException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			System.out.println("More Marmots");

			for (int i = 0; i < 50 ; i++) {

				System.out.println(marmotas.pop() + " Killed!!!");

			}

			System.out.println("Have yet " + marmotas.lenght() + " marmotas");

		} catch (MarmotException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			System.out.println("Lets kill!!!");

			for (int i = 0; i < marmotas.lenght(); i++) {

				System.out.println(marmotas.pop() + " Killed!!!");

			}

		} catch (MarmotException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		CallingMarmots.MarmotsWithString();
		
		CallingMarmots.MarmotsWithInteger();
		
	}

}

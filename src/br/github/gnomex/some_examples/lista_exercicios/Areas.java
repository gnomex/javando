package br.github.gnomex.some_examples.lista_exercicios;

import java.util.Scanner;

public class Areas {

	public static void analyze()	{

		int counter =1;
		int areas;

		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com o numero de areas");
		areas = sc.nextInt();

		if (areas <= 0 && areas <= 10000)
			return;

		int x1 = -10000;
		int y1 = 10000;
		int x2 = 10000;
		int y2 = -10000;

		int increaser = 1;

		int x, y, u, v;

		while (areas > 0)	{

			System.out.print("Area ");
			System.out.print(increaser);
			System.out.println("Entre com a coordenada X");
			x = sc.nextInt();
			System.out.println("Entre com a coordenada Y");
			y = sc.nextInt();
			System.out.println("Entre com a coordenada U");
			u = sc.nextInt();
			System.out.println("Entre com a coordenada V");
			v = sc.nextInt();

			if (x > x1)	{
				x1 = x;
			}
			if (y < y1)	{
				y1 = y;
			}
			if (u < x2)	{
				x2 = u;
			}
			if (v > y2)	{
				y2 = v;
			}

			areas--;
			increaser++;
		}

		if (x2 < x1 || y1 < y2)	{
			System.out.print("não há local ideal nas regioes apresentadas!");
			System.out.println();
		}else	{
			System.out.print(x1);
			System.out.print(" ");
			System.out.print(y1);
			System.out.print(" ");
			System.out.print(x2);
			System.out.print(" ");
			System.out.print(y2);
			System.out.println();
		}
		System.out.println("FIM!!!");

		counter++;

	}

	public static void main(String[] args){
		Areas.analyze();
	}
}
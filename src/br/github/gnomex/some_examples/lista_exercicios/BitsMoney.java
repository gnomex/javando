package br.github.gnomex.some_examples.lista_exercicios;

	/**
	 * Exercicío 4 da lista de projetos de software II - Bits Trocados
	 * Moeda bit, valores disponíveis, inteiros apenas
	 * 	50
	 * 	10
	 * 	5
	 * 	1
	 * Programação de caixas automáticos
	 * # Dado um valor inteiro, retorne o número de cada nota necessária para totalizar este valor.
	 * */


public class BitsMoney {

	
	public static int[] parse( Integer amount)	{
		int[] notas = new int[4];
		notas[0] = notas[1] = notas[2] = notas[3] = 0;	
		
		if ( amount < 1) {
			return notas;
		}
		
		notas[0] = amount / 50;
		amount %= 50;
		notas[1] = amount / 10;
		amount %= 10;
		notas[2] = amount / 5;
		amount %= 5;
		notas[3] = amount;
		return notas;		
	}
	
	public static void main(String[] args) {
		System.out.println(BitsMoney.parse(72));
	}
	
}

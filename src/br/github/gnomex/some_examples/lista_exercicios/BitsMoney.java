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

	
	public static String[] parse( Integer amount)	{
		String[] notas = new String[4];
		notas[0] = notas[1] = notas[2] = notas[3] = "";	
		
		if ( amount < 1) {
			return notas;
		}
		
		notas[0] = "R$50: " + amount / 50;
		amount %= 50;
		notas[1] = "R$10: " +amount / 10;
		amount %= 10;
		notas[2] = "R$5: " +amount / 5;
		amount %= 5;
		notas[3] = "R$1: " +amount;
		return notas;		
	}
	
	public static void main(String[] args) {
		
		String[] notas = BitsMoney.parse(72);
		for (int i = 0; i < notas.length; i++) {
			System.out.println(notas[i]);
		}
		
	}
	
}

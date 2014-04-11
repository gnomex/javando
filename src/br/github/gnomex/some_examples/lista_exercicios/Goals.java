package br.github.gnomex.some_examples.lista_exercicios;

import java.util.Scanner;

public class Goals {
	public static void main(String[] args) {
		int counter = 1;
		
		while (true)	{
			Scanner sc = new Scanner(System.in);
			int partidas;
			System.out.println("Entre com o numero de partidas");
			partidas = sc.nextInt();
			if (partidas == 0)
				break;

			int melhor_soma = -1;
			int melhor_de=1;
			int melhor_ate=1;
			int de = 1;
			int soma = 0;
			
			for (int partida = 1 ; partida <= partidas; partida++)	{
				int favor;
				int contra;

				System.out.print("Partida ");
				System.out.println(partida);
				System.out.print("GOL do Time do Hipólito: ");
				favor= sc.nextInt();
				System.out.print("GOL do Adversario: ");
				contra = sc.nextInt();
				soma += favor - contra;
				if (soma < 0)
				{
					de = partida + 1;
					soma = 0;
				}
				else if (soma > 0 && (soma > melhor_soma || (soma == melhor_soma && partida - de >= melhor_ate - melhor_de)))
				{
					melhor_soma = soma;
					melhor_de = de;
					melhor_ate = partida;
				}
			}

			// imprime solução
			if (melhor_soma == -1)
			{
				System.out.print("Não houve melhor partida!");
			}else	{
				System.out.println("*Resultado*");
				System.out.print("Primeira partida que venceu: ");
				System.out.print(melhor_de);
				System.out.println();
				System.out.print("Ultima Partida que não perdeu: ");
				System.out.print(melhor_ate);
				System.out.print("\n");
			}
			counter++;
		}
	}
}

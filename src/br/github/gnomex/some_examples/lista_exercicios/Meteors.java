package br.github.gnomex.some_examples.lista_exercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Meteors {

	public static void main(String[] args) {
		int num;
		int x;
		int y;
		int x1;
		int y1;
		int x2;
		int y2;
		int i;
		int total=0;
		int n = 1;
		int p;
		Scanner input = new Scanner(System.in);
		JFileChooser chooser = new JFileChooser();
		while (true){


			System.out.println("Coordenada x1 do Canto Superior");
			x1 = input.nextInt();
			System.out.println("Coordenada y1 do Canto Superior");
			y1 = input.nextInt();
			System.out.println("Coordenada x2 do Canto Inferior");
			x2 = input.nextInt();
			System.out.println("Coordenada y2 do Canto Inferior");
			y2 = input.nextInt();

			if (x1 == 0 && y1 == 0)
				break;
			System.out.println("Entre com o numero de meteoritos");
			num = input.nextInt();
			int a = 1;
			for (i = 0; i < num; i++) 
			{
				System.out.printf("Coordenada x do meteorito %d\n",a);
				x = input.nextInt();
				System.out.printf("Coordenada y do metorito  %d\n",a);
				y = input.nextInt();
				a++;
				if (x >= x1 && x <= x2 && y <= y1 && y >= y2)
				{
					total++;
				}
			}
			System.out.printf("Teste %d\n", n);
			System.out.printf("Número de meteoritos na fazenda: %d \n\n",total);
			System.out.println("Deseja Salvar no Arquivo?Digite 1 ou 0 para sair");
			p = input.nextInt();

			if(p==1){
				int returnVal = chooser.showSaveDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					File f = chooser.getSelectedFile();
					try {

						FileWriter fw = new FileWriter(f,true);
						//pega o texto do TextArea e envia pra stream no arquivo
						//A função write escreve uma string para o arquivo. Existem outras opções
						//a função write pode gerar IOException
						String str1 = ""+ n++;
						fw.write("Teste "+str1+"\r\n");

						String str = "" + total;
						fw.write("Numero de meteoritos na fazenda: "+str+"\r\n\r\n");
						fw.close();
						
					} catch (FileNotFoundException e) { 
						e.printStackTrace();
					} catch (IOException e) { 
						e.printStackTrace();
					}
				}

				System.out.println();
			}else{
				System.exit(0);
			}
		} // while
		return;
	}

}

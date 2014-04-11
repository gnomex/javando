package br.github.gnomex.some_examples.lista_exercicios;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileContents {
	public static void main(String[] args) {
		String nome;
		int a=3;
		int d=0;
		int x=0;
		try {

			
			nome = JOptionPane.showInputDialog(null,
					"Entre com o nome do arquivo");
	    
		    byte[] b = new byte[1024];  
		    int i = 0;  
		    FileInputStream fi = new FileInputStream(nome);
		    System.out.printf("Indice| Conteúdo do Arquivo");
		    System.out.println();
		    
		    
		    while ((i=fi.read(b)) > -1) {  
		       for (int j = 0; j < i; j++) {
		    	   if(j==d){
		    	   
		    	   System.out.printf("#00" + j+" | ");
		    	   String s1 = String.format("%8s", Integer.toBinaryString(b[x] & 0xFF)).replace(' ', '0');
		    	   System.out.printf(" %s",Integer.toHexString(Integer.parseInt(s1,2)));
		    	   x++;
		    	   
		    	   String s2 = String.format("%8s", Integer.toBinaryString(b[x] & 0xFF)).replace(' ', '0');
		    	   System.out.printf(" %s",Integer.toHexString(Integer.parseInt(s2,2)));
		    	   x++;
		    	   
		    	   String s3 = String.format("%8s", Integer.toBinaryString(b[x] & 0xFF)).replace(' ', '0');
		    	   System.out.printf(" %s",Integer.toHexString(Integer.parseInt(s3,2)));
		    	   x++;
		    	   
		    	   String s4 = String.format("%8s", Integer.toBinaryString(b[x] & 0xFF)).replace(' ', '0');
		    	   System.out.printf(" %s",Integer.toHexString(Integer.parseInt(s4,2)));
		    	   x++;
		    	   
		    	   d= d+4;
		    	   }
				   
		    	   
		    	   if(j == a)
		    	   {
		    		   
		    		   a = a + 4;
		    		   System.out.println(); 
		    	   }		    
		      }  
		   }  
		    fi.close();
		    
			BufferedReader br = new BufferedReader(new FileReader(nome));

			while (br.ready()) {
				String linha = br.readLine();
				System.out.println(linha);
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		

	}
}

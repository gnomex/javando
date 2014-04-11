package br.github.gnomex.some_examples.lista_exercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class ApprovingStudents {

	public static void main(String[] args) {
	      String conteudo = "";  
	        String linha = "";  
	        BufferedReader leitor;  
	       FileReader reader;
	       int i=0;
	       int y =0;
	       int aux = 0;
	       int aux2=0;
	       int max=0;
	       int min=0;
	                int cont = 0;  
	                float media = 0;  
	                int somaTotal = 0;
	                JFileChooser chooser = new JFileChooser();
	                int returnVal = chooser.showOpenDialog(null);
					if (returnVal == JFileChooser.APPROVE_OPTION) {

						File f = chooser.getSelectedFile();
						BufferedReader br = null;
						try {
							br = new BufferedReader(new FileReader(f));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						try {  						     				  
				            while ((linha = br.readLine()) != null) {  
				                conteudo += linha;  
				                			
				                                int intConteudo = Integer.parseInt(conteudo); 
				                                int conteudo2;
				                                conteudo2 = intConteudo;
				                                
				                                if(conteudo2 < intConteudo){
				                                	max= conteudo2;}
				                                else{
				                                	min = intConteudo;
				                                }
				                                if(intConteudo >= 70){  
				                                        aux=+aux;;
				                                        i++;
				                                  }else{  
				                                        aux2=+aux2; 
				                                 }  	
				  
                          
				                          }  

				    
				                        System.out.println("Total de alunos Aprovados: " + aux);  
				                        System.out.println("Total de alunos Reprovados: " + aux2);
				                        System.out.println("Nota maxima: "+max);
				                        System.out.println("Nota minima: "+min);
				                         
				                        
				              
				            return;  
						 } catch (FileNotFoundException e) {  
				            e.printStackTrace();  
				            return;  
				        } catch (IOException e) {  
				            e.printStackTrace();  
				            return;  
				        }

					}
 
	    }  
	

}

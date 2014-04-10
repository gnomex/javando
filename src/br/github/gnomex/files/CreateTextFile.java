package br.github.gnomex.files;

import java.io.FileWriter;
import java.util.Scanner;

public class CreateTextFile {

	private FileWriter output;
	
	public void openFile()	{
		try{
			
			output = new FileWriter("clients.txt");
			
			
		}catch(Exception e)	{
			e.printStackTrace();
		}
	}
	
	public void AddRecord()	{
		AccountRecord record = new AccountRecord();
		Scanner input = new Scanner( System.in );
		System.out.println("Lol");
		System.out.printf("%s\n%s", "?");
		
		while( input.hasNext())	{
			try{
				int val = input.nextInt();
				if ( val <= 0 ) break;
				
				record.setAccount( val );
				record.setFirstName( input.next() );
				record.setLastName( input.next() );
				record.setBalance( input.nextDouble() );
				
			}catch ( Exception e ) {
				e.printStackTrace();
			}
			input.nextLine();
		}
	}
	
	public void closeFile()	{
		if( output != null )	{
			try{
				
				output.close();
				
			} catch (Exception e)	{
				e.printStackTrace();
			}
		}
	}
	
}

package br.github.gnomex.files;

import java.util.Formatter;
import java.util.Scanner;

public class CreateTextFileFormatter {

	private Formatter output;
	
	public void openFile()	{
		try{
			
			output = new Formatter("clients.txt");
			
			
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
				
				if (record.getAccount() > 0 ) {
					output.format("%d %s %s %.2f\n",
							record.getAccount(),
							record.getFirstName(),
							record.getLastName(),
							record.getBalance()
						);
				}
				
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

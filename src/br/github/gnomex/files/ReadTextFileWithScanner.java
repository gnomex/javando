package br.github.gnomex.files;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static br.github.gnomex.files.common.FilesDefinitions.FILETEXTNAME;

/***
 * @author gnomex
 *	Comments in portuguese...
 *
 *	Java 6. Forma depreciada no java 7
 *
 */

public class ReadTextFileWithScanner {

	private Scanner input;
	
	private File file = new File(FILETEXTNAME);
	
	private ArrayList<DummieRecord> records = new ArrayList<DummieRecord>();

	public void openFile()	{

		try{
			
			input = new Scanner(file);

		}catch(Exception e)	{
			e.printStackTrace();
		}
	}

	public void readRecords()	{
			
		try {
			while (input.hasNext())	{
				DummieRecord data = new DummieRecord();
				
				data.setSomething(input.next());
				data.setSomebody(input.next());
				data.setaNumber(input.nextInt());
				data.setbNumber(input.nextDouble());
				
				records.add(data);
			}
			
		} catch (Exception e)	{
			e.printStackTrace();
		}

	}

	public void showRecord()	{
		
		if (records != null && !records.isEmpty())	{
			for (DummieRecord dr : records){
				System.out.println(dr.toString());
			}
		}else	{
			System.out.println("Ohh shit, nothing found !!!");
		}
	}
	
	public void closeFile()	{
		if( input != null )	{
			try{

				input.close();

			} catch (Exception e)	{
				e.printStackTrace();
			}
		}
	}

}

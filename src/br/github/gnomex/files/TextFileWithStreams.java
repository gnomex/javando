package br.github.gnomex.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static br.github.gnomex.files.common.FilesDefinitions.FILETEXT;

	/***
	 * @author gnomex
	 *	Comments in portuguese...
	 *
	 *	Nova forma de trabalhar com arquivos no java 7
	 *		FileWriter e FileReader são classes que extendem as classes InputStream e OutputStream
	 *		PrintWriter e BufferedReader tratam o fluxo e limpam os buffers.
	 *	Classe apenas de exemplo!
	 */


public class TextFileWithStreams {

	private File file = new File(FILETEXT);
	
	private FileWriter writer;
	private FileReader reader;
	
	public void writeOnFile(DummieRecord dummy)	{
		
		try	{
			
			writer = new FileWriter(file, true); //True is to append on file
			PrintWriter printer = new PrintWriter(writer);
			
			printer.println(dummy.toTags());
			
			printer.close();
			writer.close();
			
		} catch (FileNotFoundException fn)	{
			fn.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<DummieRecord> readFromFile() {
		
		ArrayList<DummieRecord> records = new ArrayList<DummieRecord>();

		try {
			reader = new FileReader(file);
			
			BufferedReader bfreader = new BufferedReader(reader);

			String line = null;
			
			while((line = bfreader.readLine()) != null)	{
				
				DummieRecord dm = new DummieRecord();
				dm.unTag(line);

				records.add(dm);	
			}
			
			bfreader.close();
			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return records;
		
	}
	
	public static void main(String[] args) {
		TextFileWithStreams file = new TextFileWithStreams();
		file.writeOnFile(new DummieRecord().getStub());
		
		ArrayList<DummieRecord> dummies = (ArrayList<DummieRecord>) file.readFromFile();
		
		if ( dummies != null && !dummies.isEmpty())	{
			for ( DummieRecord dm : dummies )	{
				System.out.println(dm);
			}
		} else {
			System.out.println("Nothing, sorry :(");
		}
		
	}
	
}

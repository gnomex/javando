package br.github.gnomex.files;

/***
 * @author gnomex
 *	Comments in portuguese...
 *
 *	Java 6. Forma depreciada no java 7
 *
 */

public class SequencialTextFileWithFormatterAndScanner {

	private CreateTextFileWithFormatter textWriter;
	private ReadTextFileWithScanner textReader;

	public SequencialTextFileWithFormatterAndScanner()	{
		textWriter = new CreateTextFileWithFormatter();
		textReader = new ReadTextFileWithScanner();
	}
	
	public void doWriteSomething()	{
		
		textWriter.openFile();
		textWriter.AddRecord();
		textWriter.closeFile();		
	}
	
	public void doReadSomething()	{
		
		textReader.openFile();
		textReader.readRecords();
		textReader.showRecord();
		textReader.closeFile();
	}
	
	public static void main(String[] args) {
		
		System.out.println("Hey!!! This methods are deprecated on java7 ;)\n\n");
		
		SequencialTextFileWithFormatterAndScanner scText = new SequencialTextFileWithFormatterAndScanner();
		
		scText.doWriteSomething();
		scText.doReadSomething();
		
	}
	
}

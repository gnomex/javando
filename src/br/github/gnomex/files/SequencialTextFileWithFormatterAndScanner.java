package br.github.gnomex.files;

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
		SequencialTextFileWithFormatterAndScanner scText = new SequencialTextFileWithFormatterAndScanner();
		
		scText.doWriteSomething();
		scText.doReadSomething();
		
	}
	
}

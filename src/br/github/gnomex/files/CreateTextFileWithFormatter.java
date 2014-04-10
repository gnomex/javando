package br.github.gnomex.files;

import java.util.Formatter;
import static br.github.gnomex.files.common.FilesDefinitions.FILETEXTNAME;

public class CreateTextFileWithFormatter {

	private Formatter output;

	private DummieRecord data = DummieRecord.getStub();

	public void openFile()	{

		try{

			output = new Formatter(FILETEXTNAME);

		}catch(Exception e)	{
			e.printStackTrace();
		}
	}

	public void AddRecord()	{

		try {
			output.format("%s %s %d %.2f\n",
					data.getSomething(),
					data.getSomebody(),
					data.getaNumber(),
					data.getbNumber()
					);

		} catch (Exception e)	{
			e.printStackTrace();
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

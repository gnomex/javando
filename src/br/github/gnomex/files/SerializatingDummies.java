package br.github.gnomex.files;

import static br.github.gnomex.files.common.FilesDefinitions.FILEBINNAME;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializatingDummies {

	private File file = new File(FILEBINNAME);

	private FileOutputStream out;
	private FileInputStream in;

	public SerializatingDummies() {
		try {
			this.out = new FileOutputStream(file);
			this.in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeOnFile( DummieRecord dm)	{

		ObjectOutputStream os = null;

		try {

			os = new ObjectOutputStream(out);
			os.writeObject(dm);

			os.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public List<DummieRecord> readFromFile(){

		ObjectInputStream oi = null;
		
		ArrayList<DummieRecord> records = new ArrayList<DummieRecord>();
		
		try {
			
			oi = new ObjectInputStream(in);
			
			while (true){
				
				DummieRecord record = (DummieRecord) oi.readObject();
				records.add(record);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		
		try {
			
			oi.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return records;
	}


	public static void main(String[] args) {

		SerializatingDummies sd = new SerializatingDummies();
		sd.writeOnFile(new DummieRecord().getStub());
		
		ArrayList<DummieRecord> dr = (ArrayList<DummieRecord>) sd.readFromFile();
		
		for (DummieRecord dm : dr )	{
			System.out.println(dm);
		}
	}
}

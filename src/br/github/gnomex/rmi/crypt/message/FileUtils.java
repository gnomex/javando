package br.github.gnomex.rmi.crypt.message;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import br.github.gnomex.rmi.crypt.ShellCommand;

public class FileUtils {
	public static final String CRYPT_FILE = "to_crypt";
	public static final String PGP_FILE = "to_crypt.asc";
	public static final String OUTPUT_FILE = "batman_tanananananannnnnn";

	private FileWriter writer;
	private FileReader reader;

	public void write(String str, String filename) {
		File file = new File(filename);

		try {
			writer = new FileWriter(file, false);
			PrintWriter printer = new PrintWriter(writer);

			printer.println(str);

			printer.close();
			writer.close();

		} catch (IOException fn) {
			fn.printStackTrace();
		}
	}

	public EncryptedMessage read(String filename) throws Exception {
		File file = new File(filename);

		ArrayList<String> rows = new ArrayList<String>();

		try {
			reader = new FileReader(file);

			BufferedReader bfreader = new BufferedReader(reader);

			String line = null;

			while ((line = bfreader.readLine()) != null) {
				rows.add(line + "\n"); // readline removes \n and I need it!
			}

			bfreader.close();
			reader.close();
			
			return new EncryptedMessage(rows);
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e.getCause());
		}
	}

	public static void main(String[] args) {
		FileUtils fu = new FileUtils();

		fu.write("gnomos!", CRYPT_FILE);

		ShellCommand sh = new ShellCommand();
		try {
			sh.crypt(CRYPT_FILE);

//			EncryptedMessage em = fu.read(PGP_FILE);
//			System.out.println(em.getPgpContent());

			if (sh.decrypt(PGP_FILE, OUTPUT_FILE)) {
				EncryptedMessage em = fu.read(OUTPUT_FILE);

				System.out.println("Mensagem: " + em.getPgpContent());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

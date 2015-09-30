package br.github.gnomex.rmi.crypt;

import java.io.File;

public class ShellCommand {

	private final String pubkey_for = "john@doe.foo";

	public Boolean crypt(String filename) throws Exception {
		try {
			ProcessBuilder pb = new ProcessBuilder("gpg", "--encrypt",
					"--armor", "--recipient", pubkey_for, filename);

			Process p = pb.start();
			p.waitFor();

			return p.exitValue() == 0 ? Boolean.TRUE : Boolean.FALSE;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Can't eval shell code: " + e.getCause());
		}
	}

	public Boolean decrypt(String filename, String outputFilename)
			throws Exception {
		File file = new File(filename);
		try {

			ProcessBuilder pb = new ProcessBuilder("gpg", "--yes", "--batch",
					"--passphrase=[batatas]", "--output", outputFilename,
					"--decrypt", filename);

			Process p = pb.start();
			p.waitFor();

			file.delete();
			
			return p.exitValue() == 0 ? Boolean.TRUE : Boolean.FALSE;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Can't eval shell code: " + e.getCause());
		}
	}

	public static void main(String[] args) {
		// try {
		// ProcessBuilder pb = new ProcessBuilder("gpg", "--list-keys");
		//
		// Process p = pb.start();
		// p.waitFor();
		// System.out.println("Works? " + p.exitValue());
		//
		// InputStream is = p.getInputStream();
		// BufferedReader br = new BufferedReader(new InputStreamReader(is));
		//
		// String s = "";
		// while ((s = br.readLine()) != null) {
		// System.out.println(s);
		// }
		// is.close();
		//
		// } catch (Exception e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// }

	}
}

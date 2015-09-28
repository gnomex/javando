package br.github.gnomex.rmi.crypt;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ShellCommand {
		
	private final String pubkey_for = "john@doe.foo";
	private final String encrypt_command = "gpg --encrypt --recipient";
	private final String dencrypt_command = "gpg --decrypt --passphrase-file .phrase";
	
	public Boolean crypt()	{
		return Boolean.FALSE;
	}
	
	public Boolean decrypt()	{
		return Boolean.FALSE;
	}
	
	public static void main(String[] args) {
		try {
			ProcessBuilder pb = new ProcessBuilder("gpg", "--list-keys");
			 			 
			Process p = pb.start();
			p.waitFor();
			System.out.println("Works? " + p.exitValue());
			
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
	        String s = "";
	        while ((s = br.readLine()) != null) {
	            System.out.println(s);
	        }
	        is.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

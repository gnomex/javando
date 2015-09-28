package br.github.gnomex.rmi.examples;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ShellCommand {
	
	private String my_secret = "Gnomos, everywhere!";
	
	private final String encrypt_command = "";
	
	
	

	public static void main(String[] args) {
		try {
			ProcessBuilder pb = new ProcessBuilder("gpg", "--list-keys");
			 			 
			Process p = pb.start();
			p.waitFor();
			System.out.println("Lol" + p.exitValue());
			
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

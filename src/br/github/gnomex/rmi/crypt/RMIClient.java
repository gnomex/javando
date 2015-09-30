package br.github.gnomex.rmi.crypt;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.github.gnomex.rmi.crypt.message.EncryptedMessage;
import br.github.gnomex.rmi.crypt.message.FileUtils;

public class RMIClient {

	public static void main(String[] args) {
		IRMIServer s = null;
		
		try {
			Registry r = LocateRegistry.getRegistry("127.0.0.1", 3000);
			
			s = (IRMIServer) r.lookup("rmi-server");
			
			FileUtils fu = new FileUtils();
			
			fu.write(s.getMessage(), FileUtils.PGP_FILE);			
			
			System.out.println(s.getMessage());
			
			ShellCommand sh = new ShellCommand();
			
			if (sh.decrypt(FileUtils.PGP_FILE, FileUtils.OUTPUT_FILE)) {
				
				EncryptedMessage em = fu.read(FileUtils.OUTPUT_FILE);
				
				System.out.println("Mensagem: " + em.getPgpContent());
			}
			
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

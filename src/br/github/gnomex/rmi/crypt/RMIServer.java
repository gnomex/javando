package br.github.gnomex.rmi.crypt;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.github.gnomex.rmi.crypt.message.EncryptedMessage;
import br.github.gnomex.rmi.crypt.message.FileUtils;

public class RMIServer extends UnicastRemoteObject implements IRMIServer {
	private static final long serialVersionUID = -8838817796625037939L;

	protected RMIServer() throws RemoteException {
		super();
	}

	@Override
	public String getMessage() throws Exception {
		FileUtils fu = new FileUtils();

		fu.write("Exemplo da aula", FileUtils.CRYPT_FILE);

		ShellCommand sh = new ShellCommand();

		try {
			sh.crypt(FileUtils.CRYPT_FILE);

			EncryptedMessage em = fu.read(FileUtils.PGP_FILE);

			return em.getPgpContent();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getCause());
		}
	}

	public static void main(String[] args) {

		try {
			Registry r = LocateRegistry.createRegistry(3000);

			r.rebind("rmi-server", new RMIServer());

			System.out.println("RMI Server ruuning at 3000");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("Deu problema no RMI Server");
		}

	}

}

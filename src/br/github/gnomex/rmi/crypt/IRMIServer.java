package br.github.gnomex.rmi.crypt;

import java.rmi.Remote;

public interface IRMIServer extends Remote {

	public abstract String getMessage() throws Exception;

}
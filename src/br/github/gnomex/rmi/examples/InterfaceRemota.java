package br.github.gnomex.rmi.examples;

/*
 * 
 InterfaceRemota.java
 *
 * Created on 29 de Maio de 2006, 22:40
 *
 * Defini��o da interface remota da classe de objetos servidores.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRemota extends Remote {
	String digaAlo() throws RemoteException;
}

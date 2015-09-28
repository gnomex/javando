/*
 * AloImpl.java
 *
 * Created on 29 de Maio de 2006, 22:40
 *
 * Defini��o da interface remota, ou seja, dos metodos do
 * servico Alo que podem ser invocados remotamente 
 */

package br.github.gnomex.rmi.examples.ex2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AloInt extends Remote {
    String digaAlo() throws RemoteException;
}
 
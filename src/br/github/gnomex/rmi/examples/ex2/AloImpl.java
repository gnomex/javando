/*
 * AloImpl.java
 *
 * Created on 29 de Maio de 2006, 22:43
 *
 * Implementa a interface AloInt. Executa efetivamente o
 * metodo digaAlo()
 */

package br.github.gnomex.rmi.examples.ex2;

import java.io.IOException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

public class AloImpl implements AloInt {
    
    public AloImpl() {}
    
    // Implementacao do metodo que pode ser invocado remotamente
    public String digaAlo() {
        String cliente=null;
        try {
            // obtem nome do cliente
            cliente = UnicastRemoteObject.getClientHost(); 
        } catch (ServerNotActiveException e) {
        }
        System.out.println("* Recebi chamada remota de " + cliente);
        
        Process proc;
		try {
			proc = Runtime.getRuntime().exec("ls -alh /home/gnomex/");
			System.out.println(proc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        return "Alo, mundo!";
    }
    
    public static void main(String args[]) {
        try {
            AloImpl alo = new AloImpl();
            // Exporta o objeto remoto colocando-o em listening para receber
            // request numa porta anonima TCP - retorna o stub do objeto servidor
            
            // *** Importante: nao tirar o segundo argumento do metodo exportObject (o zero) 
            // se nao a JVM nao gera o stub automaticamente e buscara um Servidor_stub.class
            // em tempo de execucao. Se o zero for retirado, o retorno do metodo sera diferente.
            // Maiores detalhes em http://java.sun.com/j2se/1.5.0/docs/guide/rmi/relnotes.html ou
            // http://forum.java.sun.com/thread.jspa?threadID=5150623&messageID=9564591
            
            AloInt aloStub = (AloInt)UnicastRemoteObject.exportObject(alo, 0);
            String refRemota = aloStub.toString();
            System.out.println("* Stub gerado: " + refRemota.substring(refRemota.indexOf("endpoint")));
            
            // Tenta localizar o rmiregistry no host local e na porta default (1099)
            // Caso nao encontre, retorna erro: RemoteException 
            Registry registro = LocateRegistry.getRegistry();
            refRemota = registro.toString();
            System.out.println("* Registro: " + refRemota.substring(refRemota.indexOf("endpoint")));
           
            // Registra o objeto servidor atraves de um nome "Alo" e de sua interface "stub"
            // Se o string alo ja estiver associado a outro objeto remoto, ocorre uma excecao
            registro.rebind("Alo", aloStub);
            System.out.println("* Servidor pronto");
        } catch (Exception e) {
            System.out.println("! Erro no servidor: " + e.getMessage());
//	    e.printStackTrace();
        }
    }
}

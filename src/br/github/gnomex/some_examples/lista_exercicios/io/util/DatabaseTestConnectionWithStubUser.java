package br.github.gnomex.some_examples.lista_exercicios.io.util;

import static br.github.gnomex.some_examples.lista_exercicios.io.util.DatabaseDefinitions.SchemeModelName;
import br.github.gnomex.some_examples.lista_exercicios.io.common.DatabaseConnection;
import br.github.gnomex.some_examples.lista_exercicios.io.common.DatabaseUserAuthentication;
import br.github.gnomex.some_examples.lista_exercicios.io.common.GlobalConnector;

public class DatabaseTestConnectionWithStubUser {

	public static void main(String[] args) {
		
		DatabaseUserAuthentication userStub = new DatabaseUserAuthentication();
		userStub.setBd(SchemeModelName);
		userStub.setUser("root");
		userStub.setPasswd("root");
		
		try {
			DatabaseConnection db = GlobalConnector.getConnection(userStub);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

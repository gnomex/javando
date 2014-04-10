package br.github.gnomex.some_examples.lista_exercicios.io.common;

public class GlobalConnector {

	
	/**
	 * Returns a BD connection
	 * 
	 * */
	public static DatabaseConnection getConnection(DatabaseUserAuthentication user) throws Exception	{

		DatabaseConnection db_connection = new DatabaseConnection();
		db_connection.connect(user);

		return db_connection;

	}

}

package br.senac.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
	static  String URL = "jdbc:sqlite:D:\\Aluno\\ADS4_rest\\ADS4_REST\\WebContent\\WEB-INF\\db\\teste.db";


	public static void createNewDatabase(String fileName) {
		File file = new File("resource/db/" + fileName);

		if (file.exists()) {

		}


		try (Connection conn = DriverManager.getConnection(URL)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// createNewDatabase("teste.db");
		//createNewTableUsuario();
		//		executeSQl ( "CREATE TABLE IF NOT EXISTS ItemPedido (\n"
		//				+ " itempedidoID integer NOT NULL PRIMARY KEY ,"
		//				+ " Quantidade integer ,"
		//				+ " ItemID integer,"
		//				+ " foreing key(itemid) references item (itemid) "
		//				+")");


	}

	public static void createNewTableUsuario() {


		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS USUARIO (\n"
				+ "	USUARIOid integer PRIMARY KEY NOT NULL,\n"
				+ "	USUARIOData TEXT,\n"
				+ " USUARIOvalidade date NOT NULL,\n"
				+ " USUARIOLogin TEXT (100),\n"
				+ " USUARIONumeroCartao INTEGER,\n"
				+ "	USUARIOSenha INT\n"
				+ ");";
		try (Connection conn = DriverManager.getConnection(URL);
				Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}



	public static void createNewTablePedidoCompra() {
		//SQLite connection string


		// SQL statement for creating a new table 
		String sql = "CREATE TABLE IF NOT EXISTS COMPRA (\n"
				+ "Data (DATE),\n"
				+ "FOREING KEY USUARIO ,\n"
				+")";



	}
	public static void createNewTableItemPedido() {


		// SQL statement for creating a new table 
		String sql = "CREATE TABLE IF NOT EXISTS ItemPedido (\n"
				+ " Quantidade INT,\n"
				+")";

	}

}
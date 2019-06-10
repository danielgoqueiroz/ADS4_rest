package br.senac.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
	
	
	public static final File DB_FILE =new File("D:\\Desenvimento\\javaWorkspaces\\default\\ADS4_rest\\ADS4_REST\\WebContent\\WEB-INF\\db\\pedido.db");
//	public static final String URL = "jdbc:sqlite:" + DB_FILE.getAbsolutePath();
	public static final String URL = "jdbc:sqlite:" + DB_FILE.getAbsolutePath();
	public static Connection connection;

	public Connection connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(URL);
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("Erro na conexão: " + e.getMessage()+ "\n" + URL);
		}
		return connection;
	}


	public static void executeSql(String sql) {
		
		try (Connection conn = DriverManager.getConnection(URL);
				Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("tablea criada");
		} catch (SQLException e) {
			System.err.println("Erro ao criar tabela: " + e.getMessage());
		}
	}

	public static void createNewDatabase() {
		if (!DB_FILE.exists()) {
			DB_FILE.getParentFile().mkdirs();
			System.out.println("Criou pastas");
		} else {
			System.out.println("Pasta já existe.");
		}

		try (Connection conn = DriverManager.getConnection(URL)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created: " + URL);
			}

		} catch (SQLException e) {
			System.err.println("Conexão error : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		if (!DB_FILE.exists()) {
			Conn conn = new Conn();
			conn.connect();
		}
		
		createNewDatabase();
//		executeSql("CREATE TABLE IF NOT EXISTS USUARIO (" 
//				+ "	USERID integer PRIMARY KEY NOT NULL," 
//				+ " USERLOGIN TEXT,"
//				+ " USERCODSEGU integer," 
//				+ "	USERDATA TEXT," 
//				+ " USERVALIDADE date," 
//				+ " USERCARTAO INTEGER," 
//				+ "	USERSENHA text" 
//				+ ")");
//		executeSql ("CREATE TABLE IF NOT EXISTS ITEM ("
//				+ " ITEMID integer NOT NULL PRIMARY KEY ,"
//				+ " ITEMVALOR double,"
//				+ " ITEMDESC text,"
//				+ " ITEMNOME text"
//				+")");
//
//		executeSql ("CREATE TABLE IF NOT EXISTS ITEMPEDIDO ("
//				+ " ITEMPEDIDOID integer NOT NULL PRIMARY KEY ,"
//				+ " ITEMPQDIDOQTD text,"
//				+ " ITEMID integer,"
//				+ " FOREIGN KEY(ITEMID) REFERENCES ITEM(ITEMID)"
//				+")");
//		executeSql ("CREATE TABLE IF NOT EXISTS PEDIDOCOMPRA ("
//				+ " PEDIDOCOMPRAID integer NOT NULL PRIMARY KEY ,"
//				+ " PEDIDOCOMPRADATA DATE,"
//				+ " USERID integer,"
//				+ " ITEMPEDIDOID integer,"
//				+ " FOREIGN KEY(USERID) REFERENCES USER(ISERID),"
//				+ " FOREIGN KEY(ITEMPEDIDOID) REFERENCES ITEMPEDIDO(ITEMPEDIDOID)"  
//				+")");
		
	}


}
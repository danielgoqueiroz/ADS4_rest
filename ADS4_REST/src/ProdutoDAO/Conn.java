package ProdutoDAO;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	
	public static void createNewDatabase(String fileName) {
		File file = new File("resource/db/" + fileName);
		
		if (file.exists()) {
			
		}
		
        String url = "jdbc:sqlite:sqlite/db/" + fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
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
		createNewDatabase("teste.db");
	}
	
	
}

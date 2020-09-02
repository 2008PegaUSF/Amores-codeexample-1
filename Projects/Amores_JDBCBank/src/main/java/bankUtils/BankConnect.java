package bankUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BankConnect {
	
	//private static instance of itself
	private static BankConnect cf= new BankConnect();
	
	//private no args constructor
	private BankConnect() {
		super();
	}
	
	//public static synchronized "getter" method
	public static synchronized BankConnect getInstance() {
		if (cf==null) {
			cf= new BankConnect();
		}
		return cf;
	}
	
	//Methods to do certain actions
	public Connection getConnection() {
		Connection cnn= null;
		Properties pro= new Properties();
		
		try {
			pro.load(new FileReader("src/main/resources/database.properties"));
			cnn=DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("password"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cnn;
	}
}

package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
	private static Connection conexao = null;
	
	public static Connection getConnetion() {
		if (conexao == null) {
			try {
				Properties prop = lendoProperties();
				String url = prop.getProperty("dburl");
				conexao = DriverManager.getConnection(url, prop);
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conexao;
		
	}
	
	public static void closeConnection() {
		if (conexao != null) {
			try {
				conexao.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	private static Properties lendoProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")){
			Properties prop = new Properties();
			prop.load(fs);
			return prop;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeStatement(PreparedStatement st) {
		// TODO Auto-generated method stub
		
	}

	public static void closeResultSet(ResultSet rs) {
		// TODO Auto-generated method stub
		
	}
}

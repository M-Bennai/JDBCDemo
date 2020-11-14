package co.simplon.dao;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;

public class DAOContext {
	
	static String db_url = "jdbc:mysql://localhost:3306/testjdbc";
	static String db_username = "root";
	static String db_password = "simplon93";
	
public static Connection getConnection() throws SQLException {

	try {
	
	Class.forName("com.mysql.jdbc.Driver");
	
	
}catch(ClassNotFoundException e) {
	
	e.printStackTrace();
}
	Connection connexion = DriverManager.getConnection(db_url,db_username,db_password);
	System.out.println("bravo");
	return connexion;
	
 
}

public PaysDAO getPaysDao() {
	
	return new PaysDaoImpl(this);
}
	public static void init (ServletContext context) {
		
		try {
			Class.forName(context.getInitParameter("JDBC_DRIVER"));
			db_url = context.getInitParameter( "JDBC_URL");
			db_username = context.getInitParameter( "JDBC_LOGIN");
			db_password = context.getInitParameter("JDBC_PASSWORD");
			
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		
	}
		
	
}
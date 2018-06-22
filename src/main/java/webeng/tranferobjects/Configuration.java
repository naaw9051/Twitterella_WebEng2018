package webeng.tranferobjects;

import java.sql.Connection;

public class Configuration { 

	private static Connection connection;
	
	public static Connection getConnection(){
		return connection;
	}
	
	public static void setConnection(Connection con){
		connection = con;
	}

}
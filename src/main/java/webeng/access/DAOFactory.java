package webeng.access;

public class DAOFactory {
	
	public static UserDAO getUserDAO(){
		return new MySQLUserDAO();
	}
	
	public static MessageDAO getMessageDAO(){
		return new MySQLMessageDAO();
	}

}

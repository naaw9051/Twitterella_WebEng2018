package webeng.presentation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webeng.tranferobjects.Configuration;


/**
 * Servlet implementation class Bootstrap
 */
@WebServlet(urlPatterns ={ "/BootstrapTwitterella" })
public class Bootstrap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bootstrap() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	super.init();
        
        Connection connection = (Connection) getServletContext().getAttribute("connection");
        Configuration.setConnection(connection);
      
        try
        {
        	Statement stmt = Configuration.getConnection().createStatement();
        	stmt.execute("DROP TABLE IF EXISTS USERS");
        	stmt.execute("CREATE TABLE USERS(NAME VARCHAR(255) PRIMARY KEY, PASSWORD VARCHAR(255))");
        	stmt.execute("INSERT INTO USERS VALUES('TestUser', '123')");
        	stmt.execute("INSERT INTO USERS VALUES('Nettie', 'NettieIsCool')");
        	stmt.execute("INSERT INTO USERS VALUES('Will','WillIsCool')");
        	stmt.execute("INSERT INTO USERS VALUES('Deborah','DeborahIsCool')");
        	stmt.execute("INSERT INTO USERS VALUES('Sylvie', 'SylvieNettieIsCool')");
        	stmt.execute("INSERT INTO USERS VALUES('Jeffery','JefferyIsCool')");
        	
        	stmt.execute("DROP TABLE IF EXISTS MESSAGES");
        	stmt.execute("CREATE TABLE MESSAGES(ID INT PRIMARY KEY, MESSAGES VARCHAR(255), LIKES INT, USERNAME VARCHAR(255)");
        	stmt.execute("INSERT INTO MESSAGES VALUES(1,'Wow, what a cool site!!', 12, 'Will')");
        	stmt.execute("INSERT INTO MESSAGES VALUES(2,'I got a new dog <333', 33, 'Sylvie')");
        	stmt.execute("INSERT INTO MESSAGES VALUES(3,'omg hi guyysss', 27, 'Deborah')");
        	stmt.execute("INSERT INTO MESSAGES VALUES(4,'what are u doiiiing??', 7, 'Deborah')");
        	stmt.execute("INSERT INTO MESSAGES VALUES(5,'im like sooooo bored rn', 5, 'Deborah')");
        	stmt.execute("INSERT INTO MESSAGES VALUES(6,'hellooo?', 11, 'Deborah')");
        	stmt.execute("INSERT INTO MESSAGES VALUES(7,'@Will i like your style :)', 2, 'Nettie')");
        	stmt.execute("INSERT INTO MESSAGES VALUES(8,'Finally, its summer *-*', 17, 'Sylvie')");
        	stmt.execute("INSERT INTO MESSAGES VALUES(9,'What do you think about my new artwork?', 31, 'Will')");
        	stmt.execute("INSERT INTO MESSAGES VALUES(10,'hi', 120, 'Jeffery')");
        }
        catch(SQLException e)
        {
        	System.out.println(e.getMessage());
        }
 }     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

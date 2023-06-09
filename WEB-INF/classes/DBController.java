
import java.sql.Connection;
import java.sql.DriverManager;

public class DBController {
	
	static Connection connection=null;
	
	public static Connection getDBConnection() {
		
		try {
			if(connection==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Contacts","root","root");
			}
		}
		catch(Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return connection;
	}
}



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
	
	PreparedStatement stmt;
	public void register(user u,String enabled)throws SQLException 
	{	
		
		Connection con=new DBController().getDBConnection();
		
		String query="insert into user(username,password,secretkey,2faenabled) values(?,?,?,?)";
		stmt=con.prepareStatement(query);
		stmt.setString(1,u.getUsername());
		stmt.setString(2,u.getPassword());
		stmt.setString(3,u.getSecretkey());
		stmt.setString(4,enabled);
		stmt.executeUpdate();	
		stmt.close();
		
		
	}
	

}

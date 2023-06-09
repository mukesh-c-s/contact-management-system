import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class secretkeyDao {
    public  String getSecretkey(String username) throws SQLException {
		String sk="hi";
		String query="select * from user where username='"+username+"'";
        
		Connection con=DBController.getDBConnection();
		PreparedStatement stmt=con.prepareStatement(query);
		// stmt.setString(1,username);
		ResultSet rs1=stmt.executeQuery();
		if(rs1.next());
		{   
			sk=rs1.getString("secretkey");
			
		}
        return sk;
    }
}

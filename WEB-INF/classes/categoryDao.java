
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;



public class categoryDao{
		
		
	public ArrayList<category> getcategory() throws SQLException
	{	
		ArrayList<category> cat=new ArrayList<>();
		Connection con=DBController.getDBConnection();
		String query="select * from category";
		Statement stmt=con.prepareStatement(query);
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()){
			cat.add(new category(Integer.parseInt(rs.getString("ct_id")), rs.getString("category")));
		}
		return cat;
	}
	
	
}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteDao {
		String [] pea={"contact_mobile","contact_email","contact_address"};
		PreparedStatement stmt=null;
		Connection con=DBController.getDBConnection();
	public int deleteContact(int cid,int uid ) throws SQLException 
		{
		deletepea(cid);
		String query="delete from contact_personel where cid=? and uid=?";
		
	        stmt=con.prepareStatement(query);
		stmt.setInt(1,cid);
		stmt.setInt(2,uid);
		return(stmt.executeUpdate());
		
	}
	public int getUid(String username) throws SQLException {
		String query="select * from user where username=?";
		Connection con=DBController.getDBConnection();
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setString(1,username);
		ResultSet rs=stmt.executeQuery();
		if(rs.next())
		{
			return rs.getInt("uid");
		}
		return 0;
	}
	public void deletepea(int cid) throws SQLException 
	{	int order=0;
		while(order<3)
		{
			String query="delete from "+pea[order]+" where cid=? ";
			stmt=con.prepareStatement(query);
			stmt.setInt(1,cid);
			
			stmt.executeUpdate();
			order++;
		}
	}
}

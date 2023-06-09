


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AddDao {
    
    public int checkpersonel(Contact c) throws SQLException 
    {   Connection connection= DBController.getDBConnection();
        String query="select * from contact_personel where firstname='"+c.getFirstname()+"' and lastname='"+c.getLastname()+"'";
		
		PreparedStatement stmt= connection.prepareStatement(query);
		
		ResultSet rs=stmt.executeQuery(query);
		int cid=0;
		if(rs.next())
		{	
			
			cid=rs.getInt("cid");
			
		}
		
		stmt.close();
		return cid;
    }
    public void insert(Contact c,int uid) throws SQLException
    {       Connection connection= DBController.getDBConnection();
            String query="INSERT INTO contact_personel(uid,firstname,lastname,companyname,birthday) VALUES (?,?,?,?,?)";
			PreparedStatement stmt= connection.prepareStatement(query);
	   		stmt.setInt(1,uid);
			stmt.setString(2,c.getFirstname());
			stmt.setString(3,c.getLastname());
			stmt.setString(4,c.getCompanyname());
			stmt.setString(5,c.getBirthday());
			stmt.executeUpdate();
            stmt.close();
    }
    public void addp(ContactMobile cm) throws SQLException
    {   Connection connection= DBController.getDBConnection();
        String query="insert into contact_mobile (ct_id,cid,mobilenumber) values(?,?,?)";
        PreparedStatement stmt=connection.prepareStatement(query);
        stmt.setInt(1,cm.getCtid());
        stmt.setInt(2,cm.getCid());
        stmt.setString(3,cm.getMobilenumber());
        stmt.executeUpdate();
        stmt.close();
    }
    public void adde(ContactEmail ce) throws SQLException
    {   Connection connection= DBController.getDBConnection();
        String query="insert into contact_email (ct_id,cid,email) values(?,?,?)";
        PreparedStatement stmt=connection.prepareStatement(query);
        stmt.setInt(1,ce.getCtid());
        stmt.setInt(2,ce.getCid());
        stmt.setString(3,ce.getEmail());
        stmt.executeUpdate();
        stmt.close();
    }
    public void adda(ContactAddress cm) throws SQLException
    {   Connection connection= DBController.getDBConnection();
        String query="insert into contact_address (ct_id,cid,address) values(?,?,?)";
        PreparedStatement stmt=connection.prepareStatement(query);
        stmt.setInt(1,cm.getCtid());
        stmt.setInt(2,cm.getCid());
        stmt.setString(3,cm.getAddress());
        stmt.executeUpdate();
        stmt.close();
    }
	public int newcategory(String category) throws SQLException
    {   Connection connection= DBController.getDBConnection();
        String query="insert into category (category) values(?)";
        PreparedStatement stmt=connection.prepareStatement(query);
        stmt.setString(1,category);
      
        stmt.executeUpdate();
        stmt.close();
		return(category(category));
    }
	public int category(String category) throws SQLException
    {   Connection connection= DBController.getDBConnection();
        String query="select * from category where category=?";
        PreparedStatement stmt=connection.prepareStatement(query);
        stmt.setString(1,category);
      
        ResultSet rs=stmt.executeQuery();
        stmt.close();
		return rs.getInt("ct_id");
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
	
}

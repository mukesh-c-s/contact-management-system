package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Contact;
import view.DisplayView;
public class DisplayController {
	
	public void display(int uid)throws SQLException
	{
		Connection con=new DBController().getDBConnection();
		
		String query="select * from contact_personel as cp inner join  contact_work as cw on cp.wid=cw.wid where uid=?";
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setInt(1,uid);
		
		ResultSet rs=stmt.executeQuery();
		int sno=1;
		while(rs.next())
		{	
			new DisplayView().display(sno,rs.getInt("cid"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("companyname"),rs.getString("homemobile"),rs.getString("workmobile"),rs.getString("homeemail"),rs.getString("workemail"),rs.getString("homeaddress"),rs.getString("workaddress"),rs.getString("birthday"));
			sno++;
		}
		stmt.close();
		rs.close();
	}
}

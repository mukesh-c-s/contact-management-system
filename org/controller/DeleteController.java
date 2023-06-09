package controller;
import java.sql.Connection;
import java.sql.Savepoint;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import view.DeleteView;

import model.Contact;

public class DeleteController {
	
		PreparedStatement stmt=null;
	public void deleteContact(int uid) throws SQLException 
		{
		int rows=0;
		 
		int cid=new DeleteView().getcid();
		Connection con=new DBController().getDBConnection();
		con.setAutoCommit(false);
		Savepoint sp=con.setSavepoint();
		String query="delete from contact_personel where cid=? and uid=?";
		
	        stmt=con.prepareStatement(query);
		stmt.setInt(1,cid);
		stmt.setInt(2,uid);
		rows=stmt.executeUpdate();
			
			
		if(rows>0)
		{	
			String confirm=new DeleteView().confirm();
			if(confirm.equals("y"))
			{	
				con.commit();
				new DeleteView().found();
			}
			else if(confirm.equals("n"))
			{	
				con.rollback(sp);
				
			}
		}
		 else
         	{
			 new DeleteView().notfound();
			
	        }
		
		stmt.close();
	}
}

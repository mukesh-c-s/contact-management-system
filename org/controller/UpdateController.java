package controller;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Contact;
import view.UpdateView;
public class UpdateController {
	String[] arr=new String[]{"firstname","lastname","companyname","homemobile","workmobile","homeemail","workemail","homeaddress","workaddress","birthday"};
	PreparedStatement stmt=null;
	Connection con=new DBController().getDBConnection();
	public void update(int uid)throws SQLException 
	{	
		int cid=new UpdateView().getcid();
		
		String query="select * from contact_personel as cp inner join  contact_work as cw on cp.wid=cw.wid where uid=? and cid=?";
	        stmt=con.prepareStatement(query);
		stmt.setInt(1,uid);
		stmt.setInt(2,cid);
		ResultSet rs=stmt.executeQuery();
		if(rs.next())
		{  stmt.close();
		   new UpdateView().attributes();
	 	   int col=new UpdateView().getCol();
		   Savepoint sp=con.setSavepoint();
		   con.setAutoCommit(false);
		   if(col==3)
		   {
			String companyname=new UpdateView().companyName();
			
			String workmobile=new UpdateView().workMobile();
			
			String workemail=new UpdateView().workEmail();
			
			String workaddress=new UpdateView().workAddress();
			int wid=checkcompany(companyname,workmobile,workemail,workaddress);
			query="update contact_personel set wid=? where cid=? and uid=?";
			stmt=con.prepareStatement(query);
			stmt.setInt(1,wid);
			stmt.setInt(2,cid);
			stmt.setInt(3,uid);
			stmt.executeUpdate();
	 	    	stmt.close();
		    	
		   }
		   else if(col==5 || col==7 || col==9)
		   {
		    String value =new UpdateView().getValue();
		    int wid=rs.getInt("wid");
		    query="update contact_work set "+arr[col-1]+"= ? where wid= ?";
		    stmt=con.prepareStatement(query);
		    stmt.setString(1,value);
		    stmt.setInt(2,wid);
		    stmt.executeUpdate();
	 	    stmt.close();
		    
		    
		   }
		   else
		   {
			String value =new UpdateView().getValue();
		    query="update contact_personel set "+arr[col-1]+"= ? where cid= ? and uid=?"; 
	 	    stmt=con.prepareStatement(query);
		    stmt.setString(1,value);
		    stmt.setInt(2,cid);
		    stmt.setInt(3,uid);
		    stmt.executeUpdate();
	 	    stmt.close();
		    
		   }
		   String confirm=new UpdateView().confirm();
		   if(confirm.equals("y"))
			{	
				con.commit();
				new UpdateView().found();
			}
		   else if(confirm.equals("n"))
			{	
				con.rollback(sp);
				
			}		 	
		}
		else
		{
 	   		new UpdateView().notfound();
			stmt.close();
		}
		rs.close();
		
	}
	public int checkcompany(String companyname,String workmobile,String workemail,String workaddress) throws SQLException
	{
		String query1="SELECT * FROM contact_work where companyname='"+companyname+"'";
		PreparedStatement stmt2=con.prepareStatement(query1);
		//stmt2.setString(1,companyname);
		ResultSet rs=stmt2.executeQuery(query1);
		if(rs.next())
		{
			int wid=rs.getInt(1);
			stmt2.close();
			rs.close();
			return wid;
		}
		else
		{	
			String query3="INSERT INTO contact_work( companyname , workmobile , workemail , workaddress) VALUES ( '"+companyname +"','"+ workmobile +"','"+ workemail +"','"+ workaddress+"')";
			PreparedStatement stmt= con.prepareStatement(query3);
			/*stmt.setString(1,companyname);
			stmt.setString(2,workmobile);
			stmt.setString(3,workemail);
			stmt.setString(4,workaddress);*/
			stmt.executeUpdate(query3);
			stmt.close();
			return checkcompany(companyname,workmobile,workemail,workaddress);
			
			
		}
	}
}
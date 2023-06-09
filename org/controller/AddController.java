package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import view.AddView;
import model.Contact;
public class AddController {
		Connection connection= new DBController().getDBConnection();
	public void addContact(int uid) throws SQLException
	{	
		int wid=1;
		
		String firstname=new AddView().firstName();
		String lastname=new AddView().lastName();
		String companyname=new AddView().companyName();
		String homemobile=new AddView().homeMobile();
		String workmobile=new AddView().workMobile();
		String homeemail=new AddView().homeEmail();
		String workemail=new AddView().workEmail();*/
		String homeaddress=new AddView().homeAddress();
		String workaddress=new AddView().workAddress();
		String birthday=new AddView().birthday();
		Contact c=new Contact(firstname,lastname,companyname,homemobile ,workmobile ,homeemail ,workemail ,homeaddress ,workaddress,birthday);
		int found=0;
		found=checkpersonel(firstname,lastname);
		if(found==1)
		{
			new AddView().present();
			
			
		}
		else
		{
	        	  wid=checkcompany(companyname,workmobile,workemail,workaddress);
			  String query="INSERT INTO contact_personel(uid,firstname,lastname,homemobile ,homeemail ,homeaddress ,birthday,wid) VALUES (?,?,?,?,?,?,?,?)";
			  PreparedStatement stmt1= connection.prepareStatement(query);
		
			  stmt1.setInt(1,uid);
			  stmt1.setString(2,c.getDetails()[0]);
			  stmt1.setString(3,c.getDetails()[1]);
			  stmt1.setString(4,c.getDetails()[3]);
			  stmt1.setString(5,c.getDetails()[5]);
			  stmt1.setString(6,c.getDetails()[7]);
			  stmt1.setString(7,c.getDetails()[9]);
			  stmt1.setInt(8,wid);
		
			  int rows=stmt1.executeUpdate();
			  if(rows>0)
			 {
			    new AddView().inserted();
			 }
			stmt1.close();
		}
		
		
		
		
	}
	public int checkcompany(String companyname,String workmobile,String workemail,String workaddress) throws SQLException
	{
		String query1="SELECT * FROM contact_work where companyname='"+companyname+"'";
		PreparedStatement stmt2=connection.prepareStatement(query1);
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
			PreparedStatement stmt= connection.prepareStatement(query3);
			/*stmt.setString(1,companyname);
			stmt.setString(2,workmobile);
			stmt.setString(3,workemail);
			stmt.setString(4,workaddress);*/
			stmt.executeUpdate(query3);
			stmt.close();
			return checkcompany(companyname,workmobile,workemail,workaddress);	
		}
		
	
	}
	public int checkpersonel(String firstname,String lastname) throws SQLException
	{	
		String query="select * from contact_personel where firstname='"+firstname+"' and lastname='"+lastname+"'";
		
		PreparedStatement stmt= connection.prepareStatement(query);
		//stmt.setString(1,firstname);
		//stmt.setString(2,lastname);
		ResultSet rs=stmt.executeQuery(query);
		if(rs.next())
		{	
			stmt.close();
			return 1;
		}
		stmt.close();
		rs.close();
		return 0;	
	}
	
	
}

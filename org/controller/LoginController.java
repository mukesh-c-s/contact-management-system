package controller;
import java.sql.Connection;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Contact;
import view.LoginView;
public class LoginController {
	
	PreparedStatement stmt=null;
	public void login()throws SQLException 
	{	
		String username=new LoginView().getUsername(); 
		String password=new LoginView().getPassword();
		try
		{
			password= hash(password);
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}

		Connection con=new DBController().getDBConnection();
		
		String query="select * from user where username= ? and password=?";
		stmt=con.prepareStatement(query);
		stmt.setString(1,username);
		stmt.setString(2,password);
		
		ResultSet rs=stmt.executeQuery();
		
		if(rs.next())
		{  int uid=rs.getInt(1);
		   System.out.println(uid);
		   stmt.close();
		   
		   new menuController().homeMenu(uid);
					 	
		}
		else
		{
 	   		new LoginView().notfound();
			stmt.close();
			
		}
		rs.close();
		
	}
	 public String hash(String password) throws Exception 
	{
        	

        	MessageDigest md = MessageDigest.getInstance("SHA-512");
        	byte[] messageDigest = md.digest(password.getBytes());

        	StringBuilder hexString = new StringBuilder();
        	for (byte b : messageDigest) 
		{
            		hexString.append(String.format("%02X", b));
        	}

        
	return(hexString.toString());
    }
}

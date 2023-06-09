package controller;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Contact;
import view.RegisterView;
public class RegisterController {
	
	PreparedStatement stmt;
	public void register()throws SQLException 
	{	
		String username=new RegisterView().getUsername(); 
		String password=new RegisterView().getPassword();
		try
		{
			password= hash(password);
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		Connection con=new DBController().getDBConnection();
		con.setAutoCommit(false);
		Savepoint sp=con.setSavepoint();
		String query="insert into user(username,password) values(?,?)";
		stmt=con.prepareStatement(query);
		stmt.setString(1,username);
		stmt.setString(2,password);
		
		stmt.executeUpdate();
		
		String confirm=new RegisterView().confirm();
		   if(confirm.equals("y"))
			{	
				con.commit();
				new RegisterView().success();
			}
		   else if(confirm.equals("n"))
			{	
				con.rollback(sp);
				
			}		 	
		stmt.close();
		
		new LoginController().login();
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

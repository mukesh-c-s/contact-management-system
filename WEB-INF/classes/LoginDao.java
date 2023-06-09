
import java.sql.Connection;

import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

import de.taimos.totp.TOTP;

import java.sql.PreparedStatement;




public class LoginDao  {
	
	
	public static boolean getLogin(String username ,String password)throws SQLException 
	{	
		PreparedStatement stmt=null;
		Connection con=new DBController().getDBConnection();

		try
		{
			password= hash(password);
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		
		
			String query="select * from user where username= ? and password=?";
			stmt=con.prepareStatement(query);
			stmt.setString(1,username);
			stmt.setString(2,password);
			
			ResultSet rs=stmt.executeQuery();
			
			if(rs.next())
			{  
				
				return true;				 
			}	
			else{
				return false;
			}
			 
		
	}
	public static boolean enabled(String username) throws SQLException
	{
		PreparedStatement stmt=null;
		Connection con=new DBController().getDBConnection();
		String query="select * from user where username= ?";
			stmt=con.prepareStatement(query);
			stmt.setString(1,username);
			
			
			ResultSet rs=stmt.executeQuery();
			
			if(rs.next())
			{  
				if(rs.getString("2faenabled").equals("yes"))
				{
					return true;
				}
								 
			}	
			
				return false;
			
	}
	public static String hash(String password) throws Exception 
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
	public static String getTOTPCode(String secretKey) {
		Base32 base32 = new Base32();
		byte[] bytes = base32.decode(secretKey);
		String hexKey = Hex.encodeHexString(bytes);
		return TOTP.getOTP(hexKey);
	}
	
    public static String getUid(String username) throws SQLException {
        String query="select * from user where username=?";
		Connection con=DBController.getDBConnection();
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setString(1,username);
		ResultSet rs=stmt.executeQuery();
		if(rs.next())
		{
			return Integer.toString(rs.getInt("uid"));
		}
		return null;
    }
    public  String getSecretkey(String username) throws SQLException {
		String sk="hi";
		String query="select * from user where username=?";
		Connection con=DBController.getDBConnection();
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setString(1,username);
		ResultSet rs=stmt.executeQuery();
		if(rs.next());
		{
			sk=rs.getString("secretkey");
			return sk;
		}
    }
    public static void insertenabled(String username) throws SQLException {

		PreparedStatement stmt=null;
		Connection con=new DBController().getDBConnection();
		String query="UPDATE `user` SET `2faenabled` = ? WHERE `username` = ?";
			stmt=con.prepareStatement(query);
			stmt.setString(1,"yes");
			stmt.setString(2,username);
			stmt.executeUpdate();
    }
}

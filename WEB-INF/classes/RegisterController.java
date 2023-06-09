
import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base32;

import java.sql.SQLException;

public class RegisterController extends HttpServlet {
	private RegisterDao registerDao;
	public void init() {
		registerDao = new RegisterDao();
	}	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException 
	{	
		String username=req.getParameter("j_username"); 
		String password=req.getParameter("j_password");
		HttpSession session=req.getSession();
		session.setAttribute("username",username);
		session.setAttribute("signedup", "yes");
		try
		{
			password= hash(password);
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		String secretkey=generateSecretKey();
		user u=new user(username, password,secretkey);
		try {
			registerDao.register(u,"no");
			res.sendRedirect("Menu.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static String generateSecretKey() {
		SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[20];
		random.nextBytes(bytes);
		Base32 base32 = new Base32();
		return base32.encodeToString(bytes);
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

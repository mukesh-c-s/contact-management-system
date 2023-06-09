
import java.sql.Connection;
import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LoginController extends HttpServlet {
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException 
	{	
		PreparedStatement stmt=null;
		Connection con=DBController.getDBConnection();
		HttpSession session=req.getSession();
		
		
		String username=req.getParameter("j_username"); 
		String password=req.getParameter("j_password");
		String returnpage;
		session.setAttribute("username",username);
		
		if(BasicLoginModule.isauthenticated==true && BasicLoginModule.isenabled==true)
		{
			returnpage="Otp.jsp";
			
		}
		else{
			returnpage="error.jsp";
		}
		req.getRequestDispatcher(returnpage).forward(req, res);
	}
	
}

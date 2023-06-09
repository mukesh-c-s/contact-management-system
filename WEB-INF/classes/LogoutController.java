
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LogoutController extends HttpServlet {
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException 
	{	if(((String) req.getSession().getAttribute("signedup"))!=null)
	{
		if(((String) req.getSession().getAttribute("signedup")).equals("yes"))
		{
			try {
				LoginDao.insertenabled((String)req.getSession().getAttribute("username"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		req.getSession().invalidate();
		res.sendRedirect("Home.jsp");
	}
}

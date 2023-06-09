
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.sql.SQLException;

public class DeleteController extends HttpServlet {
	private DeleteDao deleteDao;
	public void init() {
		deleteDao = new DeleteDao();
	}	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
		{
		
		 HttpSession session=req.getSession();
		 int uid=0;
		 try {
			 uid = deleteDao.getUid((String)session.getAttribute("username"));
		 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		int cid=Integer.parseInt(req.getParameter("id"));
		try {
			int deletec=deleteDao.deleteContact(cid,uid);
			
			req.getRequestDispatcher("display").forward(req,res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}
	
}



import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SortController extends HttpServlet {
	
	private SortDao sortDao;
	public void init() {
		sortDao = new SortDao();
	}	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException 
   	{	
		HttpSession session=req.getSession();
		RequestDispatcher rd=null;
		int uid=0;
		try {
			uid = sortDao.getUid((String)session.getAttribute("username"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int col=Integer.parseInt(req.getParameter("button"));
		
		try {
			ArrayList<Contact> contacts=sortDao.sorting(col,uid);
			req.setAttribute("contacts", contacts);
			
			rd=req.getRequestDispatcher("displaycontact.jsp");
			rd.forward(req, res);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
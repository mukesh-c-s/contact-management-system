

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SearchController extends HttpServlet {
	private SearchDao searchDao;
	public void init() {
		searchDao = new SearchDao();
	}	
	public void doPost(HttpServletRequest req,HttpServletResponse res ) throws ServletException, IOException 
	{
		HttpSession session=req.getSession();  
		int uid=0;
		try {
			uid = searchDao.getUid((String)session.getAttribute("username"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   int col=Integer.parseInt(req.getParameter("button"));
  	   
  	   String value=req.getParameter("value");
	   
	   
		try {
			ArrayList<Contact> contacts=searchDao.search(uid,col,value);
			if(contacts.size()!=0)
			{	req.setAttribute("contacts", contacts);
				req.setAttribute("found", 1);
				req.getRequestDispatcher("SearchDisplay.jsp").forward(req,res);
			}
			else
			{
				req.setAttribute("found", 0);
				req.getRequestDispatcher("SearchDisplay.jsp").forward(req,res);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} 
	   
	}
	

}




import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class DisplayController extends HttpServlet {
		String [] pea={"contact_mobile","contact_email","contact_address"};
		private DisplayDao displayDao;
	public void init() {
		displayDao = new DisplayDao();
	}	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{	
		HttpSession session=req.getSession();
		int uid=0;
		try {
			uid = displayDao.getUid((String)session.getAttribute("username"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=null;
		Contact c=new Contact(uid);
		try {
			
			ArrayList<Contact> contacts=displayDao.display(c);
			req.setAttribute("contacts", contacts);
			
			rd=req.getRequestDispatcher("displaycontact.jsp");
			rd.forward(req, res);
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
			doPost(req, res);
	}
	
}

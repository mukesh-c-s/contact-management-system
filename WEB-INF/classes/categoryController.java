
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class categoryController extends HttpServlet{
	private categoryDao categoryDao;
	public void init() {
		categoryDao = new categoryDao();
	}	
		
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{	
		ArrayList<category> cat=new ArrayList<>();
		try {
			cat=categoryDao.getcategory();
			req.setAttribute("cat", cat);
			req.getRequestDispatcher("AddContact.jsp").forward(req,res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class AddController extends HttpServlet{
	private AddDao addDao;
	public void init() {
		addDao = new AddDao();
	}	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{	HttpSession session=req.getSession();
		if(session.getAttribute("username")!=null)
		{
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}
		String js=sb.toString();
		String[] jss=js.split("\"");
		String firstname="";
		String lastname="";
		String companyname="";
		String birthday="";
		ArrayList<String> mobileCategory=new ArrayList<>();
		ArrayList<String> mobile=new ArrayList<>();;
		ArrayList<String> emailCategory=new ArrayList<>();;
		ArrayList<String> email=new ArrayList<>();;
		ArrayList<String> addressCategory=new ArrayList<>();;
		ArrayList<String> address=new ArrayList<>();;
		
		for (int i=1;i<jss.length;i+=2) {
			if(jss[i].equals("firstName"))
			{
				firstname=jss[i+2];
			}
			else if(jss[i].equals("lastName"))
			{
				lastname=jss[i+2];
			}
			else if(jss[i].equals("companyName"))
			{
				companyname=jss[i+2];
			}
			else if(jss[i].equals("birthday"))
			{
				birthday=jss[i+2];
			}
			else if(jss[i].equals("mobiles"))
			{	for(int j=i+2;j<jss.length;j+=2)
				{
				if(jss[j].equals("mobileCategorys"))
				{
					
					break;
				}
				else
				{
					mobile.add(jss[j]);
					i=i+2;
				}
				}
				
			}
			else if(jss[i].equals("mobileCategorys"))
			{	for(int j=i+2;j<jss.length;j+=2)
				{
				if(jss[j].equals("emails"))
				{
					
					break;
				}
				else
				{
					mobileCategory.add(jss[j]);
					i=i+2;
				}
				}
				
			}
			else if(jss[i].equals("emails"))
			{
				for(int j=i+2;j<jss.length;j+=2)
				{
				if(jss[j].equals("emailCategorys"))
				{
					
					break;
				}
				else
				{
					email.add(jss[j]);
					i=i+2;
				}
				}
				
			}
			else if(jss[i].equals("emailCategorys"))
			{
				for(int j=i+2;j<jss.length;j+=2)
				{
				if(jss[j].equals("addresses"))
				{
					
					
					break;
				}
				else
				{
					emailCategory.add(jss[j]);
					i=i+2;
				}
				}
			}
			else if(jss[i].equals("addresses"))
			{	
				for(int j=i+2;j<jss.length;j+=2)
				{
				if(jss[j].equals("addressCategorys"))
				{
					
					break;
				}
				else
				{
					address.add(jss[j]);
					i=i+2;
				}
				}
				
			}
			else if(jss[i].equals("addressCategorys"))
			{	for(int j=i+2;j<jss.length;j+=2)
				{
					addressCategory.add(jss[j]);
				}
				
			}
			
		  }
		 
		  
		Contact c=new Contact(firstname, lastname, companyname, birthday);
		int cid=0;
		
		int uid=0;
		try {
			uid = addDao.getUid((String)session.getAttribute("username"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			cid=addDao.checkpersonel(c);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cid!=0)
		{
			req.setAttribute("found", 0);
			req.getRequestDispatcher("addview.jsp").forward(req,res);	
		}
		else
		{
			
			try {
				addDao.insert(c, uid);
				cid=addDao.checkpersonel(c);
				
				for(int i=0;i<mobileCategory.size();i++)
			{ 	ContactMobile cm;
				
				if(mobileCategory.get(i).length()>1)
				{
					int ctid=addDao.newcategory(mobileCategory.get(i));
					cm=new ContactMobile(ctid, cid, mobile.get(i));
				}
				else{
					cm=new ContactMobile(Integer.parseInt(mobileCategory.get(i)), cid, mobile.get(i));
				}
				
				addDao.addp(cm);
			}
			for(int i=0;i<emailCategory.size();i++)
			{	ContactEmail ce;
				if(emailCategory.get(i).length()>1)
				{
					int ctid=addDao.newcategory(emailCategory.get(i));
					ce=new ContactEmail(ctid, cid, email.get(i));
				}
				else
				{
				 ce=new ContactEmail(Integer.parseInt(emailCategory.get(i)), cid, email.get(i));
				}
				addDao.adde(ce);
			}
			for(int i=0;i<addressCategory.size();i++)
			{
				ContactAddress ca;
				if(addressCategory.get(i).length()>1)
				{
					int ctid=addDao.newcategory(addressCategory.get(i));
					ca=new ContactAddress(ctid, cid, address.get(i));
				}
				else
				{
				 ca=new ContactAddress(Integer.parseInt(addressCategory.get(i)), cid, address.get(i));
				
				}
				addDao.adda(ca);
			}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
	}
}
	 }

	
	
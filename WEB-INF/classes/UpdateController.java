
import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.ArrayList;

public class UpdateController extends HttpServlet {
	private UpdateDao updateDao;
	public void init() {
		updateDao = new UpdateDao();
	}	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if (action.equals("/edit")) {
			int cid = Integer.parseInt(req.getParameter("id"));
			try {
				Contact contact = updateDao.getbyid(cid);
				req.setAttribute("contact", contact);
				req.getRequestDispatcher("/EditContact.jsp").forward(req, res);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} 
		else if (action.equals("/update"))
		 {
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = req.getReader();
			try 
			{
				String line;
				while ((line = reader.readLine()) != null) {
					sb.append(line).append('\n');
				}
			} finally {
				reader.close();
			}
			String js = sb.toString();
			String[] jss = js.split("\"");
			int cid = 0;
			String firstname = "";
			String lastname = "";
			String companyname = "";
			String birthday = "";
			ArrayList<String> mobileCategory = new ArrayList<>();
			ArrayList<String> mobile = new ArrayList<>();
			ArrayList<String> mobileid = new ArrayList<>();
			ArrayList<String> emailCategory = new ArrayList<>();
			ArrayList<String> email = new ArrayList<>();
			ArrayList<String> emailid = new ArrayList<>();
			ArrayList<String> addressCategory = new ArrayList<>();
			ArrayList<String> address = new ArrayList<>();
			ArrayList<String> addressid = new ArrayList<>();
			
			for (int i = 1; i < jss.length; i += 2) {
				if (jss[i].equals("cid")) {
					cid = Integer.parseInt(jss[i + 2]);
				} else if (jss[i].equals("firstName")) {
					firstname = jss[i + 2];
				} else if (jss[i].equals("lastName")) {
					lastname = jss[i + 2];
				} else if (jss[i].equals("companyName")) {
					companyname = jss[i + 2];
				} else if (jss[i].equals("birthday")) {
					birthday = jss[i + 2];
				} else if (jss[i].equals("mobiles")) {
					for (int j = i + 2; j < jss.length; j += 2) {
						if (jss[j].equals("mobileCategorys")) {

							break;
						} else {
							mobile.add(jss[j]);
							i = i + 2;
						}
					}

				} else if (jss[i].equals("mobileCategorys")) {
					for (int j = i + 2; j < jss.length; j += 2) {
						if (jss[j].equals("mobileids")) {

							break;
						} else {
							mobileCategory.add(jss[j]);
							i = i + 2;
						}
					}

				} else if (jss[i].equals("mobileids")) {
					for (int j = i + 2; j < jss.length; j += 2) {
						if (jss[j].equals("emails")) {

							break;
						} else {
							mobileid.add(jss[j]);
							i = i + 2;
						}
					}

				} else if (jss[i].equals("emails")) {
					for (int j = i + 2; j < jss.length; j += 2) {
						if (jss[j].equals("emailCategorys")) {

							break;
						} else {
							email.add(jss[j]);
							i = i + 2;
						}
					}

				} else if (jss[i].equals("emailCategorys")) {
					for (int j = i + 2; j < jss.length; j += 2) {
						if (jss[j].equals("emailids")) {

							break;
						} else {
							emailCategory.add(jss[j]);
							i = i + 2;
						}
					}
				} else if (jss[i].equals("emailids")) {
					for (int j = i + 2; j < jss.length; j += 2) {
						if (jss[j].equals("addresses")) {

							break;
						} else {
							emailid.add(jss[j]);
							i = i + 2;
						}
					}
				} else if (jss[i].equals("addresses")) {
					for (int j = i + 2; j < jss.length; j += 2) {
						if (jss[j].equals("addressCategorys")) {

							break;
						} else {
							address.add(jss[j]);
							i = i + 2;
						}
					}

				} else if (jss[i].equals("addressCategorys")) {
					for (int j = i + 2; j < jss.length; j += 2) {
						if (jss[j].equals("addressids")) {

							break;
						} else {
							addressCategory.add(jss[j]);
							i = i + 2;
						}
					}

				} else if (jss[i].equals("addressids")) {
					for (int j = i + 2; j < jss.length; j += 2) {
						addressid.add(jss[j]);
					}
				}

			}
			Contact c = new Contact(cid, firstname, lastname, companyname, birthday);
			try {
				int updatepersonel = updateDao.updatepersonel(c);
				int updatemobile = 0;
				int updateemail = 0;
				int updateaddress = 0;
				for (int i = 0; i < mobileid.size(); i++) {
					ContactMobile cm = new ContactMobile(Integer.parseInt(mobileid.get(i)), mobileCategory.get(i),
							mobile.get(i));
					updatemobile = updateDao.updatemobile(cm);
				}
				for (int i = 0; i < emailid.size(); i++) {
					ContactEmail ce = new ContactEmail(Integer.parseInt(emailid.get(i)), emailCategory.get(i),
							email.get(i));
					updateemail = updateDao.updateemail(ce);
				}
				for (int i = 0; i < addressid.size(); i++) {
					ContactAddress ca = new ContactAddress(Integer.parseInt(addressid.get(i)), addressCategory.get(i),
							address.get(i));
					updateaddress = updateDao.updateaddress(ca);
				}
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
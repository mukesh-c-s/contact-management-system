
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDao {
	String[] pea = { "contact_mobile", "contact_email", "contact_address" };
	String[] arr = new String[] { "firstname", "lastname", "companyname", "birthday", "mobilenumber", "email",
			"address" };
	PreparedStatement stmt = null;

	public Contact getbyid(int cid) throws SQLException {
		Connection con = DBController.getDBConnection();
		String query = "select * from contact_personel where  cid=?";
		stmt = con.prepareStatement(query);
		// stmt.setInt(1,uid);
		stmt.setInt(1, cid);
		ResultSet rs = stmt.executeQuery();
		Contact c = null;
		while (rs.next()) {
			c = new Contact(rs.getInt("cid"), rs.getString("firstname"), rs.getString("lastname"),
					rs.getString("companyname"), rs.getString("birthday"), displaymob(rs.getInt("cid"), 0),
					displaymob(rs.getInt("cid"), 1), displaymob(rs.getInt("cid"), 2));

		}
		return c;
	}

	public ArrayList<ArrayList<String>> displaymob(int cid, int order) throws SQLException {
		ArrayList<ArrayList<String>> cm = new ArrayList();
		Connection con = DBController.getDBConnection();
		String query = "select * from " + pea[order] + " inner join category on " + pea[order]
				+ ".ct_id=category.ct_id where cid=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, cid);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			if (order == 0) {
				ContactMobile cmob = new ContactMobile(rs.getInt("pid"), rs.getString("category"), rs.getString(4));
				ArrayList<String> ct = new ArrayList<>();
				ct.add(cmob.getPid());
				ct.add(cmob.getCategory());
				ct.add(cmob.getMobilenumber());
				cm.add(ct);
			} else if (order == 1) {
				ContactEmail ceEmail = new ContactEmail(rs.getInt("eid"), rs.getString("category"), rs.getString(4));
				ArrayList<String> ct = new ArrayList<>();
				ct.add(ceEmail.getEid());
				ct.add(ceEmail.getCategory());
				ct.add(ceEmail.getEmail());
				cm.add(ct);
			} else {
				ContactAddress cadd = new ContactAddress(rs.getInt("aid"), rs.getString("category"), rs.getString(4));
				ArrayList<String> ct = new ArrayList<>();
				ct.add(cadd.getAid());
				ct.add(cadd.getCategory());
				ct.add(cadd.getAddress());
				cm.add(ct);
			}

		}
		stmt.close();
		return cm;
	}
	public int updatepersonel(Contact c) throws SQLException
    {       Connection connection= DBController.getDBConnection();
            String query="update contact_personel set firstname=? ,lastname=?,companyname=?,birthday=? where cid=?";
			PreparedStatement stmt= connection.prepareStatement(query);
	   		stmt.setInt(5,c.getCid());
			stmt.setString(1,c.getFirstname());
			stmt.setString(2,c.getLastname());
			stmt.setString(3,c.getCompanyname());
			stmt.setString(4,c.getBirthday());
			return(stmt.executeUpdate());
            
    }
	public int updatemobile(ContactMobile cm) throws SQLException
	{	Connection con=DBController.getDBConnection();
		String query="update contact_mobile set ct_id=?"+",mobilenumber= "+"?"+" where pid=?";
		PreparedStatement stmt2 = con.prepareStatement(query);
		stmt2=con.prepareStatement(query);
		int ctid=category(cm.getCategory());
		stmt2.setInt(1,ctid);
		stmt2.setString(2,cm.getMobilenumber());
		stmt2.setInt(3,Integer.parseInt(cm.getPid()));
		return(stmt2.executeUpdate());
	}
	public int updateemail(ContactEmail ce) throws SQLException
	{	Connection con=DBController.getDBConnection();
		String query="update contact_email set ct_id=? ,email=? where eid=?";
		PreparedStatement stmt2 = con.prepareStatement(query);
		stmt2=con.prepareStatement(query);
		int ctid=category(ce.getCategory());
		stmt2.setInt(1,ctid);
		stmt2.setString(2,ce.getEmail());
		stmt2.setInt(3,Integer.parseInt(ce.getEid()));
		return(stmt2.executeUpdate());
	}
	public int updateaddress(ContactAddress ca) throws SQLException
	{	Connection con=DBController.getDBConnection();
		String query="update contact_address set ct_id=? ,address=? where aid=?";
		PreparedStatement stmt2 = con.prepareStatement(query);
		stmt2=con.prepareStatement(query);
		int ctid=category(ca.getCategory());
		stmt2.setInt(1,ctid);
		stmt2.setString(2,ca.getAddress());
		stmt2.setInt(3,Integer.parseInt(ca.getAid()));
		return(stmt2.executeUpdate());
	}

	public int category(String category) throws SQLException {
		Connection con=DBController.getDBConnection();
		int ctid=0;
		String query = "select * from category where category=? ";
		PreparedStatement stmt2 = con.prepareStatement(query);
		stmt2.setString(1,category);
		ResultSet rs = stmt2.executeQuery();
		
		if(rs.next()) {
			ctid=rs.getInt("ct_id");
		}
		else
		{	
			query="insert into category(category) values(?)";
			stmt2=con.prepareStatement(query);
			stmt2.setString(1,category);
			stmt2.executeUpdate();
			ctid=category(category);

		}
		return ctid;
	}
	
}
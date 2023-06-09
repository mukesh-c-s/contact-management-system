
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchDao {
	String[] pea = { "contact_mobile", "contact_email", "contact_address" };
	String[] arr = new String[] { "firstname", "lastname", "companyname", "birthday", "mobilenumber", "email",
			"address" };
	PreparedStatement stmt = null;
	Connection con = DBController.getDBConnection();

	public ArrayList<Contact> search(int uid, int col, String value) throws SQLException {
		ArrayList<Contact> alc =new ArrayList<>();
		
		if (col >= 1 && col < 5) {
			
			String query = "select * from contact_personel  where uid=? and " + arr[col - 1] + "=?";
			stmt = con.prepareStatement(query);
			stmt.setString(2, value);
			stmt.setInt(1, uid);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				alc.add(new Contact(rs.getInt("cid"), rs.getString("firstname"), rs.getString("lastname"),
						rs.getString("companyname"), rs.getString("birthday"), displaymob(rs.getInt("cid"), 0),
						displaymob(rs.getInt("cid"), 1), displaymob(rs.getInt("cid"), 2)));
			}
			
		} else {
			
			String query = "select * from " + pea[col - 5] + "  where " + arr[col - 1] + " =?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, value);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
					alc.add(displaypersonel(uid, rs.getInt("cid")));
			
			}
			
		}

		return alc;
	}
	public int getUid(String username) throws SQLException {
		String query="select * from user where username=?";
		Connection con=DBController.getDBConnection();
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setString(1,username);
		ResultSet rs=stmt.executeQuery();
		if(rs.next())
		{
			return rs.getInt("uid");
		}
		return 0;
	}

	public Contact displaypersonel(int uid, int cid) throws SQLException {
		String query = "select * from contact_personel  where cid=? and uid=? ";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, cid);
		stmt.setInt(2, uid);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			Contact c = new Contact(rs.getInt("cid"), rs.getString("firstname"), rs.getString("lastname"),
					rs.getString("companyname"), rs.getString("birthday"), displaymob(rs.getInt("cid"), 0),
					displaymob(rs.getInt("cid"), 1), displaymob(rs.getInt("cid"), 2));
			return c;
		}
		return null;

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
				ContactMobile cmob = new ContactMobile(rs.getString("category"), rs.getString(4));
				ArrayList<String> ct = new ArrayList<>();
				ct.add(cmob.getCategory());
				ct.add(cmob.getMobilenumber());
				cm.add(ct);
			} else if (order == 1) {
				ContactEmail ceEmail = new ContactEmail(rs.getString("category"), rs.getString(4));
				ArrayList<String> ct = new ArrayList<>();
				ct.add(ceEmail.getCategory());
				ct.add(ceEmail.getEmail());
				cm.add(ct);
			} else {
				ContactAddress cadd = new ContactAddress(rs.getString("category"), rs.getString(4));
				ArrayList<String> ct = new ArrayList<>();
				ct.add(cadd.getCategory());
				ct.add(cadd.getAddress());
				cm.add(ct);
			}

		}
		stmt.close();
		return cm;
	}

}



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class DisplayDao {
	String [] pea={"contact_mobile","contact_email","contact_address"};
	
        public ArrayList<Contact>  display(Contact c) throws SQLException
        {   
            Connection con=DBController.getDBConnection();
            ArrayList<Contact> al=new ArrayList<>();
            String query="select * from contact_personel where uid=?";
		    PreparedStatement stmt=con.prepareStatement(query);
		    stmt.setInt(1,c.getUid());
		
		    ResultSet rs=stmt.executeQuery();
		    
		    while(rs.next())
		    {	
                al.add(new Contact(rs.getInt("cid"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("companyname"),rs.getString("birthday"),displaymob(rs.getInt("cid"),0),displaymob(rs.getInt("cid"),1),displaymob(rs.getInt("cid"),2)));
		    	
		    	
		    }
			
		    
            return al;
        }
			public ArrayList<ArrayList<String>> displaymob(int cid,int order) throws SQLException
            {   ArrayList<ArrayList<String>> cm=new ArrayList();
                Connection con=DBController.getDBConnection();
                String query="select * from " +pea[order]+" inner join category on " +pea[order]+".ct_id=category.ct_id where cid=?";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setInt(1,cid);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				
				if(order==0)
				{
					ContactMobile cmob=new ContactMobile(rs.getInt("pid"),rs.getString("category"),rs.getString(4));
					ArrayList<String> ct=new ArrayList<>();
					ct.add(cmob.getPid());
					ct.add(cmob.getCategory());
					ct.add(cmob.getMobilenumber());
					cm.add(ct);
				}
				else if(order==1)
				{
					ContactEmail ceEmail=new ContactEmail(rs.getInt("eid"),rs.getString("category"),rs.getString(4));
					ArrayList<String> ct=new ArrayList<>();
					ct.add(ceEmail.getEid());
					ct.add(ceEmail.getCategory());
					ct.add(ceEmail.getEmail());
					cm.add(ct);
				}
				else
				{
					ContactAddress cadd=new ContactAddress(rs.getInt("aid"),rs.getString("category"),rs.getString(4));
					ArrayList<String> ct=new ArrayList<>();
					ct.add(cadd.getAid());
					ct.add(cadd.getCategory());
					ct.add(cadd.getAddress());
					cm.add(ct);
				}
				
			}
            stmt.close();
            return cm;
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
    
}

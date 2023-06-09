package controller;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Contact;
import view.SearchView;
import view.DisplayView;
public class SearchController {
	
	String[] arr=new String[]{"firstname","lastname","companyname","homemobile","workmobile","homeemail","workemail","homeaddress","workaddress","birthday"};
	PreparedStatement stmt=null;
	public void search(int uid) throws SQLException
	{
           int found =0;
	   new SearchView().attributes();
	   int col=new SearchView().getCol();
  	   
  	   String value=new SearchView().getValue();
  	   
  	   Connection con =new DBController().getDBConnection();
	   String query ="select * from contact_personel as cp inner join  contact_work as cw on cp.wid=cw.wid where uid=? and "+arr[col-1]+"=?";
	   
	   stmt=con.prepareStatement(query);
	   stmt.setString(2,value);
	   stmt.setInt(1,uid);
	   ResultSet rs=stmt.executeQuery();
	   int sno=1;
	   
  	   while(rs.next())
  	   {
			new DisplayView().display(sno,rs.getInt("cid"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("companyname"),rs.getString("homemobile"),rs.getString("workmobile"),rs.getString("homeemail"),rs.getString("workemail"),rs.getString("homeaddress"),rs.getString("workaddress"),rs.getString("birthday"));
  			sno++;
			 found=1;
  		   
  	   }
	   if(found==0)
	   {
		new SearchView().notfound();
	   }
	   
	
	   stmt.close();
	   rs.close();
	}

}

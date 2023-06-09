package view;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.*;
import model.Contact;
public class DisplayView {
	
	public void display(int sno,int cid,String FirstName,String LastName,String CompanyName,String HomeMobile,String WorkMobile,String HomeEmail,String WorkEmail,String HomeAddress,String WorkAddress,String Birthday) throws SQLException
	{
		System.out.println(sno);
		System.out.println("ContactId:   "+cid+"\n"+
				   "FirstName:   "+FirstName+"\n"+
				   "LastName:    "+LastName+"\n"+
				   "CompanyName: "+CompanyName+"\n"+
				   "HomeMobile:  "+HomeMobile+"\n"+
				   "WorkMobile:  "+WorkMobile+"\n"+
				   "HomeEmail:   "+HomeEmail+"\n"+
				   "WorkEmail:   "+WorkEmail+"\n"+
				   "HomeAddress: "+HomeAddress+"\n"+
				   "WorkAddress: "+WorkAddress+"\n"+
				   "Birthday:    "+Birthday+"\n");
	}
	
}

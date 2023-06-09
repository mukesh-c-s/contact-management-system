package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import model.Contact;
import view.MenuView;
public class menuController {
	Scanner s=new Scanner(System.in);
	
	public void homeMenu(int uid) throws SQLException
	{	
		
		
		int  choice;
		do 
	       {   choice=new MenuView().choice();
	           switch(choice)
	           {
	           case 1:
	           	{	
	           		new AddController().addContact(uid);
	           		
				
	           		break;
	           	}
	           case 2:
	           	{		           			
	           		new DisplayController().display(uid);	
	           		break;
	           	}
	           case 3:
		           {
		        	new SearchController().search(uid);
		                break;
		           }
	           case 4:
		           {	
		        	new DisplayController().display(uid);
		        	new UpdateController().update(uid);
		        	break;
		           }
	           case 5:
		           {
		        	 
		        	 
	                         new SortController().sorting(uid);
	                   	 
	                   	 break;
		        	   
		           }
		           
	            
	           case 6:
		           {	
		        	   new DisplayController().display(uid);
		        	   new DeleteController().deleteContact(uid);
		        	   
				   break;
		           }
		   case 0:
			return;
		

		           default:
		        	   new MenuView().def();
		        	   break;
	           }
	       }while(choice!=0);
	}
}

package view;
import java.util.Scanner;
//import model.*;

public class MenuView {
	Scanner s=new Scanner(System.in);
	
	public int choice() 
	{	
		
		
		   int  choice; 
	           System.out.println("\n\n1.ADD CONTACT\n2.DISPLAY CONTACTS\n3.SEARCH CONTACT\n4.EDIT CONTACT\n5.SORT CONTACT\n6.DELETE CONTACT\n0.EXIT\n");
		   System.out.println("\nEnter the choice: ");
	           choice=s.nextInt();
		   return choice; 
	 }
	public void def()
	{          
	       System.out.println("invalid choice");
	}
}

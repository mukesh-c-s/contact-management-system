package view;
import java.util.Scanner;
public class DeleteView {
	Scanner s=new Scanner(System.in);
	
	public int getcid()
	{
		System.out.println("Enter the contactid to be updated :");
		int cid=s.nextInt();
		return cid;
	}
	public void found()
	{
		System.out.println("\nCONTACT DELETED\n");
	}
	public void notfound()
	{
		System.out.println("CONTACT NOT AVAILABLE");
	}
	public String confirm()
	{
	System.out.println("confirm delete? y/n\n");
	return(s.nextLine());
	}
}

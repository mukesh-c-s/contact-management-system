package view;
import java.util.Scanner;
public class UpdateView {
	Scanner s=new Scanner(System.in);
	public void attributes()
	{	
		System.out.println("1.FirstName\n"+"2.LastName\n"+"3.CompanyName\n"+"4.HomeMobile\n"+"5.WorkMobile\n"+"6.HomeEmail\n"+"7.WorkEmail\n"+"8.HomeAddress\n"+"9.WorkAddress\n"+"10.Birthday\n");

	}
	public int getcid()
	{
		System.out.println("Enter the contactid to be updated :");
		int cid=s.nextInt();
		return cid;
	}
	public String companyName()
	{	
		System.out.println("CompanyName:");
		String companyname=s.nextLine();
		return companyname;
		
	}
	public String workMobile()
	{	
		System.out.println("WorkMobile:");
		String workmobile=s.nextLine();
		return workmobile;
		
	}
	public String workEmail()
	{	
		System.out.println("WorkEmail:");
		String workemail=s.nextLine();
		return workemail;
		
	}
	public String workAddress()
	{	
		System.out.println("WorkAddress:");
		String workaddress=s.nextLine();
		return workaddress;
		
	}
	public String getValue()
	{
		System.out.println("Enter the value to be updated :");
		String value=s.nextLine();
		return value;
	}
	public int getCol()
	{
		System.out.println("Enter attribute to be edited :");
		int col=s.nextInt();
		return col;
	} 
	public void found()
	{
		System.out.println("\nUPDATED CONTACT");
	}
	public void notfound()
	{
		System.out.println("CONTACT NOT FOUND");
	}
	public String confirm()
	{
	System.out.println("confirm update? y/n\n");
	return(s.nextLine());
	}
}

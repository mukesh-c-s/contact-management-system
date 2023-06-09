package view;
import java.util.Scanner;
public class AddView {
	Scanner s=new Scanner(System.in);
	public String firstName()
	{	
		System.out.println("FirstName:");
		String firstname=s.nextLine();
		return firstname;
		
	}
	public String lastName()
	{	
		System.out.println("LastName:");
		String lastname=s.nextLine();
		return lastname;
		
	}
	public String companyName()
	{	
		System.out.println("CompanyName:");
		String companyname=s.nextLine();
		return companyname;
		
	}
	public String homeMobile()
	{	
		System.out.println("HomeMobile:");
		String homemobile=s.nextLine();
		return homemobile;
		
	}
	public String workMobile()
	{	
		System.out.println("WorkMobile:");
		String workmobile=s.nextLine();
		return workmobile;
		
	}
	public String homeEmail()
	{	
		System.out.println("HomeEmail:");
		String homeemail=s.nextLine();
		return homeemail;
		
	}
	public String workEmail()
	{	
		System.out.println("WorkEmail:");
		String workemail=s.nextLine();
		return workemail;
		
	}
	public String homeAddress()
	{	
		System.out.println("HomeAddress:");
		String homeaddress=s.nextLine();
		return homeaddress;
		
	}
	public String workAddress()
	{	
		System.out.println("WorkAddress:");
		String workaddress=s.nextLine();
		return workaddress;
		
	}
	public String birthday()
	{	
		System.out.println("Birthday:");
		String birthday=s.nextLine();
		return birthday;
		
	}
	public void present()
	{
		System.out.println("contact already present");
		
	}
	public void inserted()
	{
		System.out.println("\nCONTACT ADDED\n");
	}

}

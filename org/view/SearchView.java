package view;
import java.util.Scanner;
public class SearchView {
	Scanner s=new Scanner(System.in);
	public void attributes()
	{	
		System.out.println("1.FirstName\n"+"2.LastName\n"+"3.CompanyName\n"+"4.HomeMobile\n"+"5.WorkMobile\n"+"6.HomeEmail\n"+"7.WorkEmail\n"+"8.HomeAddress\n"+"9.WorkAddress\n"+"10.Birthday\n");

	}
	public int getCol()
	{
		System.out.println("Enter the attribute to be searched :");
		int col=s.nextInt();
		return col;
	}
	public String getValue()
	{
		System.out.println("Enter the value to be searched :");
		String value=s.nextLine();
		return value;
	}
	public void notfound()
	{
		System.out.println("CONTACT NOT AVAILABLE");
	}
}

package view;
import java.util.Scanner;
public class LoginView {
	Scanner s=new Scanner(System.in);
	
	public String getUsername()
	{
		System.out.println("Enter the username :");
		String username=s.nextLine();
		return username;
	}
	public String getPassword()
	{
		System.out.println("Enter the password :");
		String password=s.nextLine();
		return password;
	} 
	
	public void notfound()
	{
		System.out.println("\nusername or password is incorrect");
		
	}
	public void success()
	{
		System.out.println("\nregistered successful\n");
	}
	public String confirm()
	{
	System.out.println("confirm register? y/n\n");
	return(s.nextLine());
	}
}

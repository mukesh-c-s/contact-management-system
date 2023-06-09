package view;
import java.util.Scanner;
public class ChoiceView {
	Scanner s=new Scanner(System.in);
	public String choice()
	{
		System.out.println("\npress l for login or r for register\n");
		String choice=s.nextLine();
		return choice;
	}
	public void notValid()
	{
		System.out.println("entered  invalid ");
	}
}

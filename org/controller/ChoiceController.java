package controller;
import java.sql.SQLException;
import model.Contact;
import view.ChoiceView;
public class ChoiceController {
	
	
	public void choice() throws SQLException
	{
		String opt=new ChoiceView().choice();
		if(opt.equals("l"))
		{
			new LoginController().login();
		}
		else if(opt.equals("r"))
		{
			new RegisterController().register();
		}
		else
		{
			new ChoiceView().notValid();
			choice();
		}
	} 
}

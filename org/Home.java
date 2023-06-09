import java.sql.SQLException;
import controller.ChoiceController;
import controller.*;

import model.Contact;

public class Home
{
	
	
	public static void main(String[] args) throws SQLException
	   {	
		       new ChoiceController().choice();
			/*new DBController().getDBConnection();
		       new AddController().addContact(1);
		       new DisplayController().display(1);
		       new SearchController().search(1);
			new SortController().sorting(1);
			new DeleteController().deleteContact(1);
			new UpdateController().update(1);
			new LoginController().login();
			new RegisterController().register();*/
	   }
}


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;


public class LockAndLoad //This class looks up the user and also calls the password authentication method
{
	/**
	 * this method returns a boolean on whether or not the username and password was authentic
	 * @returns a boolean that authenticats the username and password
	 * @throws FileNotFoundException
	 */
	public static boolean Search() throws FileNotFoundException 
	{
		
		String UserName = GUI.Field.getText(); //username
		String password = GUI.Field2.getText(); //password
		int count = 0;
		boolean found = false;
		for (int i = 0; i < User.r.size(); i++)
		{
			if (UserName.equals(User.r.get(i).getName()))
			{
				
				found = true;
				count++;
			}
			
		}
		boolean auth = false;
		if (found)
		{
			auth = Authenticate.PasswordAuthentication();
		}
		
		if (auth && found)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
		
		
		
	}
	
	



import java.io.FileNotFoundException;
import java.util.Arrays;
/**
 * This class authenticates the password by comparing the hash values to the password in the database. If the hashed password matches, then the password is authentic
 * @author Andrew
 *
 */
public class Authenticate 
{
	/**
	 * 
	 * @return a boolean if the password is authentic or not
	 * true if it is and false if it is not
	 *@throws FileNotFoundException when Salt.txt cannot be found 
	 */
	public static boolean PasswordAuthentication() throws FileNotFoundException
	{
		boolean authenticated = false;
		String username = GUI.Field.getText();
		String password = GUI.Field2.getText();
		String encpw = "";
		String salt = "";
		for (int i = 0; i < FileHero.SaltMachine.size();i++)
		{
			if (username.equals(FileHero.SaltMachine.get(i).getUser()))
			{
				salt = FileHero.SaltMachine.get(i).getSalt();
				break;
			}
		}
	
		for (int i = 0; i < 10000; i++)
		{
			password = Encryption.Sha(password+salt);
		}

		for (int i = 0; i < User.r.size(); i++)
		{
			if (username.equals(User.r.get(i).getName()))
			{
				encpw = User.r.get(i).getPw();
				break;
			}
		}
		if (password.equals(encpw))
		{
			authenticated = true;
		}
		return authenticated;
	}
		
}

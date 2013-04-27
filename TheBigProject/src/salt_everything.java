import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;


public class salt_everything 
{
	public static void save() throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter("Accounts");
		PrintWriter salty = new PrintWriter("Salt.txt");
		int max = User.r.size();
		int counter = 0;
		String password = "";
		while (counter < max)
		{
			password = User.r.get(counter).getPw();
			String salt = Arrays.toString(FileHero.makeSalt());
			for (int i = 0; i < 10000; i++)
			{
				password = Encryption.Sha(password+salt);
			}
			pw.println(User.r.get(counter).getName() +","+password);
			salty.println(User.r.get(counter).getName() + "/" + salt);
			
			counter++;
		}
		pw.close();
		salty.close();
	}
}

import java. io.*;
import java.util.*;
/**
 * //This is the class that keeps the username and password
 * @author Andrew
 *
 */
public class User
{
	private String Username;
	private String password;
	public static ArrayList<User> r = new ArrayList<User>();

	public static File file = new File("Accounts");
	
	
	/**
	 * Method loads text from Accounts into the arraylist r
	 * @throws FileNotFoundException when the Accounts file cannot be found
	 */
	public static void d() throws FileNotFoundException
	{
		
		int count = 0;
		
		@SuppressWarnings("resource")
		Scanner fin = new Scanner(file).useDelimiter(",");
		//Scanner f = new Scanner(file).useDelimiter(",");
		ArrayList<String> d= new ArrayList<String>();
		while(fin.hasNextLine())
		{
			String line = fin.nextLine();
			String[] user = line.split(",");
			r.add(new User(user[0], user[1]));
			
			count++;
		}
		
		fin.close();
		
		
		
		
	}
	/**
	 * 
	 * @param Username String that contains username	
	 * @param password String that contains password
	 */
	public User(String Username, String password) 
	{
		this.Username = Username;
		this.password = password;
	}
	/**
	 * 
	 * @return username
	 */
	public String getName()
	{
		return Username;
	}
	/**
	 * 
	 * @return password
	 */
	public String getPw()
	{
		return password;
	}
	
	

	/**
	 * Allows a new user to be added into the text file by printing out the contents of the arraylist into the accounts file
	 * @param username String that contains username
	 * @param password String that contains password
	 * @throws FileNotFoundException
	 */
	public static void addUser(String username, String password) throws FileNotFoundException 
	{
		PrintWriter pw = new PrintWriter(file);
		r.add(new User(username, password));
		for (int i = 0; i < r.size(); i++)
		{
			pw.println(r.get(i).getName() +","+r.get(i).getPw());
		}
		
		pw.close();
	}

	
}

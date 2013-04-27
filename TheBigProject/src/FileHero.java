import java.security.SecureRandom;
import java.util.*;
import java.io.*;
/**
 * This class is mainly used to regulate the salts that are being generated
 * @author Andrew
 *
 */
public class FileHero
{
	
	private String user;
	private String salt;
	public static ArrayList<FileHero> SaltMachine = new ArrayList<FileHero>(); //Saves user and salt
	/**
	 * 
	 * @param user String that contains username
	 * @param salt String that contains the salt
	 */
	public FileHero(String user, String salt)
	{
		this.user = user;
		this.salt = salt;
	}
	/**
	 * This method puts the user and salt in the text file into the arraylist
	 * @throws FileNotFoundException when Salt.txt cannot be found by the program
	 */
	public static void loadSalt() throws FileNotFoundException
	{
		File f = new File("Salt.txt");
		Scanner fin = new Scanner(f);
		while (fin.hasNextLine())
		{
			String line = fin.nextLine();
			String[] salt = line.split("/");
			SaltMachine.add(new FileHero(salt[0], salt[1]));
		}
		
		fin.close();
	}
	/**
	 * /Uses the method in Encryption to make a salt for each password
	 * @return a random byte array that is the salt
	 */
	public static byte[] makeSalt()
	{
		Random r = new SecureRandom();
		byte[] salt = new byte[64];
		r.nextBytes(salt);
		return salt;
	}
	/**
	 * Adds the salt and user to the text file that stores them
	 * @param user String that contains username
	 * @param salt String that contains salt
	 * @throws FileNotFoundException when Salt.txt cannot be found by the program
	 */
	public static void addSalt(String user, String salt) throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter("Salt.txt");
		SaltMachine.add(new FileHero(user, salt));
		for (int i = 0; i < SaltMachine.size(); i++)
		{
			pw.println(SaltMachine.get(i).getUser() + "/" + SaltMachine.get(i).getSalt());
		}
		pw.close();
	}
	/**
	 * 
	 * @return String that has username
	 */
	public String getUser()
	{
		return user;
	}
	/**
	 * 
	 * @return String that contains the salt
	 */
	public String getSalt()
	{
		return salt;
	}
}
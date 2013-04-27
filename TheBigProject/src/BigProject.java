import java.io.FileNotFoundException;
import java.util.*;

public class BigProject //main class
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		User.d();
		FileHero.loadSalt();
		run();
	
	}

	public static void run() throws FileNotFoundException //runs a new instance of gui in class GUI
	{
		
		new GUI();
	}
	
	
}

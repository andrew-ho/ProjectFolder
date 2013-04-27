import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/**
 * 
 * @author Andrew
 *
 */
 public class Encryption
 {
	 
	
	 /**
	  * 
	  * @param enc enc stands for the password that is going to be encrypted
	  * @return returns an encrypted string that has been iterated 10000 times
	  */
	 public static String EncPw(String enc)
	 {
		 for (int i = 0; i < 10000; i++)
		 {
			 enc = Sha(enc);
		 }
		return enc;
	 }
	 /**
	  * This method takes the string given to it and encrypts the password using SHA-512
	  * @param s the password to be encrypted
	  * @return the encryped password
	  */
	 public static String Sha(String s)  
	 {
		    try 
		    {
		        MessageDigest m = MessageDigest.getInstance("SHA-512");
		        m.update(s.getBytes(), 0, s.length());
		        BigInteger i = new BigInteger(1,m.digest());
		        return String.format("%1$032x", i);         
		    } catch (NoSuchAlgorithmException e) {
		        e.printStackTrace();
		    }
		    return null;
	}
	 
	
 }
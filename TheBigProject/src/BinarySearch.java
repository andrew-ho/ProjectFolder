import java.util.ArrayList;


public class BinarySearch 
{

	public static int binarySearch(ArrayList<User> a, String value )
	{
		int start = 0;
		int end = a.size()-1;
		for (int i = 0; i < a.size();i++)
		{
			int mid = (start + end)/2;
			if (value.equals(a.get(mid).getName())) 
			{
				return mid;
			}
			else if (a.get(mid).getName().substring(4).compareTo(value.substring(4)) < value.substring(4).compareTo(a.get(mid).getName().substring(4)))
			{
				start = mid +1;
			}
			
			else
			{
				end = mid -1;
			}
			
		}
		return -1;
	}
	

}

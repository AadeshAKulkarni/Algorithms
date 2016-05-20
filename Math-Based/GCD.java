import java.util.*;
import java.math.*;
public class GCD
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		long a=in.nextLong();
		long b=in.nextLong();
		System.out.println(EGCD(a,b));	
	}
	static long EGCD(long a,long b)
	{
			if(b==0)
				return a;
			else
			{
				return EGCD(b,a%b);
			}
	}
}
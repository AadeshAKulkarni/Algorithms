import java.util.*;
import java.math.*;
public class LCM
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		long a=in.nextLong();
		long b=in.nextLong();
		System.out.println((a*b)/EGCD(a,b));	
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
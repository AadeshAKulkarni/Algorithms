import java.util.*;
import java.math.*;
public class MaxPairwiseProduct
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int A[]=new int[N];
		long max1=0,max2=0;
		int index=0;
		for(int i=0;i<N;i++)
		{
			A[i]=in.nextInt();
			if(max1<A[i])
			{
				max1=A[i];			
				index=i;
			}
		}
		for(int i=0;i<N;i++)
		{			
			if((i!=index)&&(A[i]>max2))
				max2=A[i];			
		}
		BigInteger b1=new BigInteger(String.valueOf(max1));
		BigInteger b2=new BigInteger(String.valueOf(max2));
		b1=b1.multiply(b2);
		System.out.println(b1);
	}
}
import java.util.*;
public class Prims
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		
		int N=in.nextInt();
		int matrix[][]=new int[N][N];
		int visited[]=new int[N];
		int min=999;
		int u=0,v=0;
		int total=0;
		//Accepting input from user
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{	
				matrix[i][j]=in.nextInt();
				
				if(matrix[i][j]==0)
					matrix[i][j]=999;
			}
		}
		
		visited[0]=1;
		
		//Logic Begins Here
		
		for(int counter=0;counter<N;counter++)
		{
			min=999;
			for(int i=0;i<N;i++)
			{
				if(visited[i]==1)
				{
					for(int j=0;j<N;j++)
					{
						if(visited[j]!=1)
						{
							if(min>matrix[i][j])
							{
								min=matrix[i][j];
								u=i;
								v=j;
							}	
						}	
					}	
				}	
			}
			visited[v]=1;
			if(min!=999)				
				total+=min;
			System.out.println("Edge Found: "+u+"->"+v+"\t Weight:"+min);
		}
			System.out.println("MST="+total);
		
	}
}
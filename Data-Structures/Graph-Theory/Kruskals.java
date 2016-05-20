import java.util.*;

class Edge
{
	int u;
	int v;
	int wt;
/*	public Edge(int u1,int v1,int wt1)
	{
		u=u1;
		v=v1;
		wt=wt1;
	}
	*/
}
class Kruskals
{
	static int path[];
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		
		System.out.println("Enter Number of Nodes and Edges: ");
		int N=in.nextInt();
		int M=in.nextInt();
		int u,v,wt;
		Edge []e=new Edge[M]; 
		path=new int[M];
		for(int i=0;i<M;i++)
		{
			e[i]=new Edge();
			e[i].u=in.nextInt();
			e[i].v=in.nextInt();
			e[i].wt=in.nextInt();
		}
		
		// Initalize Path to 0
		for(int i=0;i<M;i++)
			path[i]=0;
		
		// Sort Edges in Ascending order of Weights
		Edge temp=new Edge();
		for(int i=0;i<(M-1);i++)
			for(int j=0;j<(M-i-1);j++)
				if(e[j].wt>e[j+1].wt)
				{
					temp=e[j];
					e[j]=e[j+1];
					e[j+1]=temp;
				}
				
		// Actual logic begins!
		int i=0;
		int j=0;
		int mincost=0;
		while((i!=(N-1))&&(j!=M))
		{
			if(checkCycle(e[j].u,e[j].v))
			{
				mincost=mincost+e[j].wt;
				i++;				
			}	
			j++;
		}
		System.out.println(mincost);
	}
	static boolean checkCycle(int u,int v)
	{
		while(path[u]>0)
			u=path[u];
		while(path[v]>0)
			v=path[v];
		
		if(u!=v)
		{
			path[u]=v;
			return true;
		}
		return false;
	}
}
import java.util.*;
class Djikstras
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		
		// Accept Input 
		int INF=10000;
		System.out.println("Enter Number of Nodes: ");
		int v=in.nextInt();
		int adj[][]=new int[v+1][v+1];
		for(int i=1;i<=v;i++)
			for(int j=1;j<=v;j++)
				adj[i][j]=in.nextInt();
				
		// Initalize Stuff
		
		int visited[]=new int[v+1];
		int path[]=new int[v+1];
		int distance[]=new int[v+1];
		
		for(int i=1;i<=v;i++)
		{
			visited[i]=0;
			distance[i]=INF;
			path[i]=0;
		}
		
		// Accept Source here
		System.out.println("Enter Source: ");
		int source=in.nextInt();
		
		
		// Actual Logic 
		
		int current=source;
		int min;
		visited[current]=1;
		int T=0;
		int nv=1;
		while(nv<v)
		{
		// Process Adjacent Nodes
		
			for(int i=1;i<=v;i++)
				if(adj[current][i]!=0)
					if(visited[i]!=1)
						if(distance[i]>adj[current][i]+T)
						{
							distance[i]=adj[current][i]+T;
							path[i]=current;
						}
		
		//Closest Vertex
		
		min=INF;
		for(int i=1;i<=v;i++)
		{
			if(visited[i]!=1)
				if(distance[i]<min)
				{
					min=distance[i];
					current=i;
				}
		}
		visited[current]=1;
		T=distance[current];
		nv++;
		
		}
		
		// Printing Shortest Distance from source to all nodes
		
		System.out.println("Distance from "+source+" to others: ");
		for(int i=1;i<=v;i++)
		{
			System.out.println(i+" Node has distance= "+distance[i]);
		}
	}
}

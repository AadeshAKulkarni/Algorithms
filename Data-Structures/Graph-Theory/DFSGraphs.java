import java.util.*;
class Neighbor
{
	int vertexNum;
	Neighbor next;
	Neighbor(int vnum,Neighbor nbr)
	{
		this.vertexNum=vnum;
		this.next=nbr;
	}	
}
class Vertex
{	
	int data;
	Neighbor adjlist;
	Vertex(int data,Neighbor neighbors)
	{
		this.data=data;
		this.adjlist=neighbors;		
	}
}
public class DFSGraphs
{
	static Vertex[] adjlists;
	static int N,E;
	static boolean visited[];
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		N=in.nextInt();
		E=in.nextInt();
		adjlists=new Vertex[N+1];
		visited=new boolean[N+1];
		for(int i=1;i<=N;i++)
		{
			adjlists[i]=new Vertex(in.nextInt(),null);
		}
		for(int i=1;i<=E;i++)
		{
			int v1=in.nextInt();
			int v2=in.nextInt();			
			adjlists[v1].adjlist=new Neighbor(v2,adjlists[v1].adjlist);
			adjlists[v2].adjlist=new Neighbor(v1,adjlists[v2].adjlist);
		}	
		DFS(1,visited);
		//printt();
		
	}
	public static void printt()
	{
		for(int i=1;i<=N;i++)
		{
			System.out.println();
			System.out.print(adjlists[i].data);
			for(Neighbor nbr=adjlists[i].adjlist;nbr!=null;nbr=nbr.next)
			{
				System.out.println("-->"+adjlists[nbr.vertexNum].data);
			}	
			System.out.println("\n");
		}	
	}
	public static void DFS(int v,boolean visited[])
	{
		visited[v]=true;
		System.out.println(v);
		for(Neighbor nbr=adjlists[v].adjlist;nbr!=null;nbr=nbr.next)
		{
			if(!visited[nbr.vertexNum])
			{
				DFS(nbr.vertexNum,visited);
			}	
		}	
	}
	
}
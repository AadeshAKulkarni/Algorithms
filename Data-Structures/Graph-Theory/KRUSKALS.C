#include<stdio.h>
#include<conio.h>
struct edge
{
	int u;
	int v;
	int wt;
};
int checkcycle(int,int,int);
int path[100];
void main()
{
	int N,M,mincost=0,i,j;
	struct edge e[100];
	struct edge temp;
	clrscr();
	printf("Enter Number of Nodes: ");
	scanf("%d",&N);
	printf("\nEnter Number of Edges: ");
	scanf("%d",&M);

	for(i=0;i<M;i++)
	{
		printf("\nEnter Source, Destination and Weight: %d : ",i);
		scanf("%d%d%d",&e[i].u,&e[i].v,&e[i].wt);
	}
	for(i=0;i<M;i++)
		path[i]=0;

	for(i=0;i<(M-1);i++)
		for(j=0;j<(M-i);j++)
			if(e[j].wt>e[j+1].wt)
			{
				temp=e[j];
				e[j]=e[j+1];
				e[j+1]=temp;
			}
	i=0;j=0;
	while((i!=(N-1))&&(j!=M))
	{
		if(checkcycle(e[j].u,e[j].v,e[j].wt))
		{
			mincost=mincost+e[j].wt;
			i++;
		}
		else
		{
		}
		j++;
	}
	printf("\n\n\t Cost: %d",mincost);
	getch();
}
int checkcycle(int u,int v,int wt)
{
	while(path[u]>0)
		u=path[u];
	while(path[v]>0)
		v=path[v];
	if(u!=v)
	{
		path[u]=v;
		return 1;
	}
	else
		return 0;
}

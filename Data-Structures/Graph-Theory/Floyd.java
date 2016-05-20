import java.util.*;
/**
 * Floyd-Warshall Algorithm for finding all pair shortest path.
 * Time complexity - O(V^3)
 * Space complexity - O(V^2)
 
 */
public class Floyd {

       private static final int INF = 1000000;

    public int[][] allPairShortestPath(int[][] distanceMatrix) {
        
        int distance[][] = new int[distanceMatrix.length][distanceMatrix.length];
        int path[][] = new int[distanceMatrix.length][distanceMatrix.length];

		// Path Matrix Initialization
        for (int i=0; i < distanceMatrix.length; i++) {
            for (int j=0; j< distanceMatrix[i].length; j++){
                distance[i][j] = distanceMatrix[i][j];
                if (distanceMatrix[i][j] != INF && i != j) {
                    path[i][j] = i;
                } else {
                    path[i][j] = -1;
                }
            }
        }

	// Actual Logic begins here
        for(int k=0; k < distanceMatrix.length; k++){
            for(int i=0; i < distanceMatrix.length; i++){
                for(int j=0; j < distanceMatrix.length; j++){
                    if(distance[i][k] == INF || distance[k][j] == INF) {
                        continue;
                    }
                    if(distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        //look for negative weight cycle in the graph
        //if values on diagonal of distance matrix is negative
        //then there is negative weight cycle in the graph.
      //  printPath(path, 3, 2);
        return distance;
    }

   /* public void printPath(int[][] path, int start, int end) {
        if(start < 0 || end < 0 || start >= path.length || end >= path.length) {
            throw new IllegalArgumentException();
        }

       // System.out.println("Actual path - between " + start + " " + end);
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.addFirst(end);
        while (true) {
            end = path[start][end];
            if(end == -1) {
                return;
            }
            stack.addFirst(end);
            if(end == start) {
                break;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pollFirst() + " ");
        }

        System.out.println();
    }
*/
    public static void main(String args[]){
        
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int[][] graph=new int[N][N];
		
		for(int i=0; i < N; i++){
            for(int j=0; j < N; j++)
				if(i!=j)	
					graph[i][j]=INF;
				else
					graph[i][j]=0;
		}		
		int M=in.nextInt();
		for(int i=0;i<M;i++)
		{
			int u=in.nextInt();
			int v=in.nextInt();
			int r=in.nextInt();
			graph[u-1][v-1]=r;
		}

		
		Floyd shortestPath = new Floyd();
        int[][] distance = shortestPath.allPairShortestPath(graph);
    //    System.out.println("Minimum Distance matrix");
        int q=in.nextInt();
		for(int i=0;i<q;i++)
		{
			int u=in.nextInt();
			int v=in.nextInt();
			if(distance[u-1][v-1]==INF)
				System.out.println("-1");
			else
				System.out.println(distance[u-1][v-1]);
		}
    }
}
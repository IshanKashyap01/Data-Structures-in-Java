# Code Dijkstra's Algorithm

```Java
import java.util.Scanner;
/*
 * Time complexity  : O(V^2)
 * Space complexity : O(V)
 */
public class Solution {

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();
        int[][] graph = inputGraph(scanner, vertices, edges);
        printMST(getMST(graph, vertices, 0));
    }

    private static int[][] inputGraph(Scanner scanner, int vertices, int edges)
    {
        int[][] graph = new int[vertices][vertices];
        int v1, v2;
        for(int i = 0; i < edges; i++)
        {
            v1 = scanner.nextInt();
            v2 = scanner.nextInt();
            graph[v1][v2] = graph[v2][v1] = scanner.nextInt();
        }
        return graph;
    }

    private static int[] getMST(int[][] graph, int vertices, int source)
    {
        // initialise all pre-requisite variables
        int[] distance = getDistanceArray(vertices);
        boolean[] visited = new boolean[vertices];
        // set the distance of source to itself as 0
        distance[source] = 0;
        int min,dist;
        // for each unvisited vertex
        for(int i = 0; i < vertices - 1; i++)
        {
            // get the unvisited vertex closest to source
            min = minDistance(distance, visited);
            // mark the min vertex as visited
            visited[min] = true;
            // for each of its unvisited adjacent vertices
            for(int j = 0; j < vertices; j++)
            {
                if(graph[min][j] > 0 && !visited[j])
                {
                    // distance to this vertex via the min vertex
                    dist = distance[min] + graph[min][j];
                    // compare this distance to its min distance from source
                    distance[j] = Math.min(distance[j], dist);
                }
            }
        }
        return distance;
    }

    private static int minDistance(int[] weights, boolean[] visited)
    {
        int index = -1;
        for(int i = 0; i < weights.length; i++)
        {
            if(!visited[i])
            {
                if(index == -1 || weights[i] < weights[index])
                {
                    index = i;
                }
            }
        }
        return index;
    }

    private static int[] getDistanceArray(int vertices)
    {
        int[] distance = new int[vertices];
        for(int i = 0; i < vertices; i++)
        {
            distance[i] = Integer.MAX_VALUE;
        }
        return distance;
    }

    private static void printMST(int[] distance)
    {
        for(int i = 0; i < distance.length; i++)
        {
            System.out.println(i + " " + distance[i]);
        }
    }
}
```

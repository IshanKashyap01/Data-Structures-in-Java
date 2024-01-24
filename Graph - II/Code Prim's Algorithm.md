# Code Prim's Algorithm

```Java
import java.util.Scanner;
/*
 * Time complexity  : O(V^2)
 * Space complexity : O(V)
 */
public class Solution 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();
        int[][] graph = inputGraph(scanner, vertices, edges);
        printMST(graph, vertices);
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

    private static void printMST(int[][] graph, int vertices)
    {
        // initialise pre-requisite variables
        int[] parent = new int[vertices];
        int[] weights = getWeightsArray(vertices);
        boolean[] visited = new boolean[vertices];
        // pick 0th vertex as source and make it its own parent
        parent[0] = 0;
        // weight of this edge as 0
        weights[0] = 0;
        int min;
        // for each unvisited vertex
        for(int i = 0; i < vertices - 1; i++)
        {
            // get the vertex with minimum weight
            min = minWeight(weights, visited);
            // mark it visited
            visited[min] = true;
            // for each vertex
            for(int j = 0; j < vertices; j++)
            {
                // if min has an edge with it and it is unvisited
                if(graph[min][j] > 0 && !visited[j])
                {
                    // if this edge has lesser weight
                    if(graph[min][j] < weights[j])
                    {
                        // update the weight
                        weights[j] = graph[min][j];
                        // replace min as its parent
                        parent[j] = min;
                    }
                }
            }
        }
        printGraph(parent, weights);
    }

    private static int minWeight(int[] weights, boolean[] visited)
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

    private static int[] getWeightsArray(int vertices)
    {
        int[] weights = new int[vertices];
        for(int i = 0; i < vertices; i++)
        {
            weights[i] = Integer.MAX_VALUE;
        }
        return weights;
    }

    private static void printGraph(int[] parent, int[] weights)
    {
        for (int i = 1; i < parent.length; i++) 
        {
            // print the nodes in increasing order lowest higest weight
            if (parent[i] < i) 
            {
                System.out.println(parent[i] + " " + i + " " + weights[i]);
            }
            else 
            {
                System.out.println(i + " " + parent[i] + " " + weights[i]);
            }
        }
    }
}
```

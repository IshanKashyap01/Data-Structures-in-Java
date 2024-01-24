# BFS Traversal

```Java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/*
 * Time complexity  : O(n^2)
 * Space complexity : O(n^2)
 */
public class Solution 
{
    public static void main(String[] args) throws NumberFormatException, IOException 
    {
        bfs(inputGraph());
    }

    private static int[][] inputGraph()
    {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();
        int[][] graph = new int[vertices][vertices];
        for(int i = 0; i < edges; i++)
        {
            addEdge(graph, scanner.nextInt(), scanner.nextInt());
        }
        return graph;
    }

    private static void addEdge(int[][] graph, int i, int j)
    {
        graph[i][j] = graph[j][i] = 1;
    }

    // prints all the components of the graph
    private static void bfs(int[][] graph)
    {
        if(graph.length == 0)
        {
            return;
        }
        boolean[] visited = new boolean[graph.length];
        // for each vertex
        for(int vertex = 0; vertex < graph.length; vertex++)
        {
            if(!visited[vertex])
            {
                // print it and all its adjacent vertices
                bfs(graph, vertex, visited);
            }
        }
    }

    // prints only connected vertices
    private static void bfs(int[][] graph, int vertex, boolean[] visited)
    {
        // queue to hold pending vertices
        Queue<Integer> queue = new LinkedList<>();
        // add the vertex
        queue.add(vertex);
        // mark it visited
        visited[vertex] = true;
        // placeholder for current vertex
        int curr;
        // until the queue is empty
        while(!queue.isEmpty())
        {
            // get the next vertex from queue and print it
            curr = queue.poll();
            System.out.print(curr + " ");
            // add all its unvisited adjacent vertices
            for(int i = 0; i < graph.length; i++)
            {
                if(!visited[i] && graph[curr][i] == 1)
                {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
```

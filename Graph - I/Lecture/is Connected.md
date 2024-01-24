# is Connected

```Java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.IOException;
/*
 * Time complexity  : O(n^2)
 * Space complexity : O(n^2)
 */
public class Solution 
{
    public static void main(String[] args) throws NumberFormatException, IOException 
    {
       Scanner scanner = new Scanner(System.in);
        boolean[][] graph = inputGraph(scanner);
        System.out.println(isConnected(graph));
    }

    private static boolean[][] inputGraph(Scanner scanner)
    {
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();
        boolean[][] graph = new boolean[vertices][vertices];
        int v1, v2;
        for(int i = 0; i < edges; i++)
        {
            v1 = scanner.nextInt();
            v2 = scanner.nextInt();
            graph[v1][v2] = graph[v2][v1] = true;
        }
        return graph;
    }

    private static boolean isConnected(boolean[][] graph)
    {
        if(graph.length == 0)
        {
            return true;
        }
        boolean[] visited = new boolean[graph.length];
        // traverse the graph from any point to fill the visited array
        // dfs(graph, visited, 0);
        bfs(graph, visited);
        // check if a vertex is unvisited
        for(boolean vertex : visited)
        {
            if(!vertex)
            {
                return false;
            }
        }
        return true;
    }

    private static void dfs(boolean[][] graph, boolean[] visited, int source)
    {
        if(!visited[source])
        {
            // mark source as visited
            visited[source] = true;
            // visit each of its unvisited adjacent vertices
            for(int i = 0; i < graph.length; i++)
            {
                if(graph[source][i] && !visited[i])
                {
                    dfs(graph, visited, i);
                }
            }
        }
    }

    private static void bfs(boolean[][] graph, boolean[] visited)
    {
        // Queue to hold pending vertices
        Queue<Integer> queue = new LinkedList<>();
        // add the first vertex into the queue and mark it visited
        queue.add(0);
        visited[0] = true;
        int curr;
        // loop until there are no vertices left
        while(!queue.isEmpty())
        {
            // get the vertex at the front
            curr = queue.poll();
            // add all its adjacent unvisited vertices to the queue
            for(int i = 0; i < graph.length; i++)
            {
                if(graph[curr][i] && !visited[i])
                {
                    queue.add(i);
                    // mark it visited
                    visited[i] = true;
                }
            }
        }
    }
}
```

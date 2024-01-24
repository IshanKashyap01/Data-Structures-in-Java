# Has Path

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
public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException 
    {
        Scanner scanner = new Scanner(System.in);
        int[][] graph = inputGraph(scanner);
        int source = scanner.nextInt();
        int dest = scanner.nextInt();
        System.out.println(hasPath(graph, source, dest));
    }

    private static int[][] inputGraph(Scanner scanner)
    {
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();
        int[][] graph = new int[vertices][vertices];
        int v1, v2;
        for(int i = 0; i < edges; i++)
        {
            v1 = scanner.nextInt();
            v2 = scanner.nextInt();
            graph[v1][v2] = graph[v2][v1] = 1;
        }
        return graph;
    }

    private static boolean hasPath(int[][] graph, int source, int dest)
    {
        if(source >= graph.length || dest >= graph.length)
        {
            return false;
        }
        // return hasPathBFS(graph, source, dest);
        return hasPathDFS(graph, new boolean[graph.length], source, dest);
    }

    // will visit only connected vertices
    private static boolean hasPathBFS(int[][] graph, int source, int dest)
    {
        // queue to store pending vertices
        Queue<Integer> queue = new LinkedList<>();
        // array to check if a vertex is visited or not
        boolean[] visited = new boolean[graph.length];
        // add source to the queue and mark it visited
        queue.add(source);
        visited[source] = true;
        int curr;
        while(!queue.isEmpty())
        {
            curr = queue.poll();
            if(curr == dest)
            {
                return true;
            }
            for(int i = 0; i < graph.length; i++)
            {
                if(!visited[i] && graph[curr][i] == 1)
                {
                    if(i == dest)
                    {
                        return true;
                    }
                    // add this adjacent vertex to the queue and mark it visited
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    // will visit only connected vertices
    private static boolean hasPathDFS
    (int[][] graph, boolean[] visited, int source, int dest)
    {
        // base case: we've reached dest or it is adjacent to source
        if(source == dest || graph[source][dest] == 1)
        {
            return true;
        }
        // now source is checked so mark it visited
        visited[source] = true;
        boolean hasPath = false;
        for(int i = 0; i < graph.length; i++)
        {
            if(graph[source][i] == 1 && !visited[i])
            {
                // recursive call will return all paths from source
                hasPath = hasPath || hasPathDFS(graph, visited, i, dest);
            }
        }
        // if there is at least one path to dest, hasPath will be marked true
        return hasPath;
    }
}
```

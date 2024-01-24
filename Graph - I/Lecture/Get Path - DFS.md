# Get Path - DFS

```Java
import java.util.ArrayList;
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
        int source = scanner.nextInt();
        int dest = scanner.nextInt();
        ArrayList<Integer> path = getPathDFS(graph, source, dest);
        printList(path);
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

    private static ArrayList<Integer> getPathDFS(boolean[][] graph, int source, int dest)
    {
        return hepler(graph, new boolean[graph.length], source, dest);
    }

    private static ArrayList<Integer> hepler
    (boolean[][] graph, boolean[] visited, int source, int dest)
    {
        ArrayList<Integer> path;
        // base case: if we reached the destination, add it to the path and return 
        if(source == dest)
        {
            path = new ArrayList<>();
            path.add(dest);
            return path;
        }
        // mark source as visited
        visited[source] = true;
        // make recursive calls to all unvisited adjacent vertices
        for(int i = 0; i < graph.length; i++)
        {
            if(graph[source][i] && !visited[i])
            {
                path = hepler(graph, visited, i, dest);
                // if path is not empty, add source to it and return it
                if(!path.isEmpty())
                {
                    path.add(source);
                    return path;
                }
            }
        }
        // if there is no path, return an empty list
        return new ArrayList<>();
    }

    private static void printList(ArrayList<Integer> list)
    {
        for(int i : list)
        {
            System.out.print(i + " ");
        }
    }
}
```

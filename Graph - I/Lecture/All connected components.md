# All connected components

```Java
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
        printComponents(graph);
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

    private static void printComponents(boolean[][] graph)
    {
        // list of visited vertices
        boolean[] visited = new boolean[graph.length];
        // list of vertices in the current component
        boolean[] component;
        // print each component of the grraph
        for(int i = 0; i < graph.length; i++)
        {
            if(!visited[i])
            {
                component = bfs(graph, visited, i);    
                for(int vertex = 0; vertex < component.length; vertex++)
                {
                    if(component[vertex])
                    {
                        System.out.print(vertex + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    private static boolean[] bfs(boolean[][] graph, boolean[] visited, int source)
    {
        boolean[] component = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        int curr;
        while(!queue.isEmpty())
        {
            curr = queue.poll();
            component[curr] = true;
            for(int i = 0; i < graph.length; i++)
            {
                if(graph[curr][i] && !visited[i])
                {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return component;
    }
}
```

# Get Path - BFS

```Java
import java.util.ArrayList;
import java.util.HashMap;
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
    public static void main(String[] args)  throws NumberFormatException, IOException
    {
        Scanner scanner = new Scanner(System.in);
        boolean[][] graph = inputGraph(scanner);
        int source = scanner.nextInt();
        int dest = scanner.nextInt();
        if(source < graph.length && dest < graph.length)
        {
            printList(getPathBFS(graph, source, dest));
        }
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

    private static ArrayList<Integer> getPathBFS(boolean[][] graph, int source, int dest)
    {
        // queue to add pending vertices
        Queue<Integer> queue = new LinkedList<>();
        // hashmap to map child to parent
        HashMap<Integer, Integer> map = new HashMap<>();
        // add source to the queue and mark it visited
        queue.add(source);
        boolean[] visited = new boolean[graph.length];
        visited[source] = true;
        int curr;
        // until queue is empty
        while(!queue.isEmpty())
        {
            curr = queue.poll();
            for(int i = 0; i < graph.length; i++)
            {
                if(graph[curr][i] && !visited[i])
                {
                    queue.add(i);
                    visited[i] = true;
                    map.put(i, curr);
                }
            }
            if(visited[dest])
            {
                break;
            }
        }
        ArrayList<Integer> path = new ArrayList<>();
        if(map.containsKey(dest))
        {
            curr = dest;
            // loop until we trace destination back to source
            while(curr != source)
            {
                path.add(curr);
                curr = map.get(curr);
            }
            // now add source to the path
            path.add(source);
        }
        return path;
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

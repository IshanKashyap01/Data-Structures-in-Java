# Islands

```Java
import java.util.LinkedList;
import java.util.Queue;
/*
 * Time complexity  : O(n^2)
 * Space complexity : O(n^2)
 */
public class Solution 
{
    public static int numConnected(int[][] graph, int n) 
    {
        boolean[] visited = new boolean[graph.length];
        int count = 0;
        for(int i = 0; i < graph.length; i++)
        {
            if(!visited[i])
            {
                dfs(graph, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] graph, boolean[] visited, int source)
    {
        if(!visited[source])
        {
            visited[source] = true;
            for(int i = 0; i < graph.length; i++)
            {
                if(graph[source][i] == 1 && !visited[i])
                {
                    // dfs(graph, visited, i);
                    bfs(graph, visited, i);
                }
            }
        }
    }

    private static void bfs(int[][] graph, boolean[] visited, int source)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        int curr;
        while(!queue.isEmpty())
        {
            curr = queue.poll();
            for(int i = 0; i < graph.length; i++)
            {
                if(graph[curr][i] == 1 && !visited[i])
                {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
```

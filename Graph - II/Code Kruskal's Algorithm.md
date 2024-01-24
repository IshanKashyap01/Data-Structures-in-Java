# Code Kruskal's Algorithm

```Java
import java.util.*;
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
        Edge[] graph = inputGraph(scanner, edges);
        Arrays.sort(graph);
        printGraph(getMST(graph, vertices));
    }

    private static Edge[] inputGraph(Scanner scanner, int edges)
    {
       Edge[] graph = new Edge[edges];
       for(int i = 0; i < edges; i++)
       {
           graph[i] = new Edge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
       }
       return graph;
    }

    private static Edge[] getMST(Edge[] graph, int vertices)
    {
        Edge[] mst = new Edge[vertices - 1];
        // get the parent array with each vertex as its own parent
        int[] parent = getParentArray(vertices);
        // counter for both graph and mst
        int count = 0, i = 0;
        // parents for both vertices of an edge
        int p1, p2;
        // until v - 1 edges are added to the mst
        while(count != vertices - 1)
        {
            // find root parent of both vertices of the current edge
            p1 = find(parent, graph[i].v1);
            p2 = find(parent, graph[i].v2);
            if(p1 != p2)
            {
                // add the edge to the graph
                mst[count++] = graph[i];
                // update one of their root parent's parent
                parent[p2] = parent[p1];
            }
            // move to the next edge in the graph
            i++;
        }
        return mst;
    }

    private static int find(int[] parent, int vertex)
    {
        if(vertex == parent[vertex])
        {
            return vertex;
        }
        return find(parent, parent[vertex]);
    }

    private static int[] getParentArray(int vertices)
    {
        int[] parent = new int[vertices];
        for(int i = 0; i < vertices; i++)
        {
            parent[i] = i;
        }
        return parent;
    }

    private static void printGraph(Edge[] graph)
    {
        for(Edge edge : graph)
        {
            if(edge.v1 <= edge.v2)
            {
                System.out.println(edge.v1 + " " + edge.v2 + " " + edge.weight);
            }
            else
            {
                System.out.println(edge.v2 + " " + edge.v1 + " " + edge.weight);
            }
        }
    }
}

class Edge implements Comparable<Edge>
{
    int v1;
    int v2;
    int weight;

    Edge(int v1, int v2, int weight)
    {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge)
    {
        return (this.weight == edge.weight) ? 0 : (this.weight > edge.weight) ? 1 : -1;
    }
}
```

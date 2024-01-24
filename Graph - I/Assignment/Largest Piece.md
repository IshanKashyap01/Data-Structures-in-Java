# Largest Piece

```Java
/*
 * Time complexity  : O(n^2)
 * Space complexity : O(n^2)
*/
public class Solution 
{
    public static int dfs(String[] graph, int n) 
    {
        boolean[][] visited = new boolean[n][n];
        Direction start = new Direction(0, 0);
        int max = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(graph[i].charAt(j) == '1')
                {
                    if(!visited[i][j] && graph[i].charAt(j) == '1')
                    {
                        start.x = i;
                        start.y = j;
                        max = Math.max(max, dfs(graph, visited, getDirections(), start));
                    }
                }
            }
        }
        return max;
    }

    private static int dfs
    (String[] graph, boolean[][] visited, Direction[] directions, Direction start)
    {
        // mark start as visited
        visited[start.x][start.y] = true;
        // count mark in the current component of graph
        int count = 1;
        Direction curr;
        // get count from all neighbours of start
        for(Direction d : directions)
        {
            curr = start.add(d);
            if(isValid(graph, visited, curr))
            {
                count += dfs(graph, visited, directions, curr);
            }
        }
        return count;
    }

    private static Direction[] getDirections()
    {
        Direction[] directions = new Direction[4];
        // top
        directions[0] = new Direction(-1, 0);
        // bottom
        directions[1] = new Direction(1, 0);
        // left
        directions[2] = new Direction(0, -1);
        // right
        directions[3] = new Direction(0, 1);
        return directions;
    }

    private static boolean isValid(String[] graph, boolean[][] visited, Direction d)
    {
        return inBounds(graph, d) && !visited[d.x][d.y] && graph[d.x].charAt(d.y) == '1';
    }

    private static boolean inBounds(String[] graph, Direction d)
    {
        return (d.x > -1 && d.x < graph.length) && (d.y > -1 && d.y < graph.length);
    }
}

class Direction
{
    int x, y;

    Direction(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    Direction add(Direction d)
    {
        return new Direction(x + d.x, y + d.y);
    }
}
```

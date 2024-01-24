# Coding Ninjas

```Java
/*
 * Time complexity  : O(n^2)
 * Space complexity : O(n^2)
 */
public class Solution 
{    
    int solve(String[] graph , int n, int m)
    {
        String word = "CODINGNINJAS";
        boolean[][] visited = new boolean[n][m];
        boolean isPresent = false;
        Direction start = new Direction(0, 0);
        // find 'C' in the graph
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(graph[i].charAt(j) == 'C')
                {
                    start.x = i;
                    start.y = j;
                    // check if the word can be formed from this 'C'
                    isPresent = isPresent || dfs(graph, visited, getDirections(), word, start, 1);
                    if(isPresent)
                    {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean dfs
    (String[] graph, boolean[][] visited, Direction[] directions, String word, Direction start, int index)
    {
        // base case: we are at the last 'A'; there is no next character to search for so just return
        if(index == word.length() - 1)
        {
            return true;
        }
        boolean isPresent = false;
        Direction curr;
        // mark the starting character as visited
        visited[start.x][start.y] = true;
        for(Direction d : directions)
        {
            // get the next possible direction
            curr = start.add(d);
            // if this direction is valid and contains the correct character
            if(isValid(graph, visited, curr) && graph[curr.x].charAt(curr.y) == word.charAt(index))
            {
                //debug: System.out.println(word.charAt(index) + ": " + curr.x + " " + curr.y);
                isPresent = isPresent || dfs(graph, visited, directions, word, curr, index + 1);
                if(isPresent)
                {
                    return true;
                }
            }
        }
        // mark the starting character as unvisited for future permutations
        visited[start.x][start.y] = false;
        return isPresent;
    }

    private static Direction[] getDirections()
    {
        Direction[] directions = new Direction[8];
        // top
        directions[0] = new Direction(-1, 0);
        // bottom
        directions[1] = new Direction(1, 0);
        // left
        directions[2] = new Direction(0, -1);
        // right
        directions[3] = new Direction(0, 1);
        // top-left
        directions[4] = new Direction(-1, -1);
        // top-right
        directions[5] = new Direction(-1, 1);
        // bottom-left
        directions[6] = new Direction(1, -1);
        // bottom-right
        directions[7] = new Direction(1, 1);
        return directions;
    }

    private static boolean isValid(String[] graph, boolean[][] visited, Direction d)
    {
        return inBounds(graph, d) && !visited[d.x][d.y];
    }

    private static boolean inBounds(String[] graph, Direction d)
    {
        return (d.x > -1 && d.x < graph.length) && (d.y > -1 && d.y < graph[0].length());
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

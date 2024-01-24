# Connecting Dots

```Java
import java.util.*;

public class Solution 
{
    int solve(String[] board , int n, int m)
    {
        return hasCycle(board) ? 1 : 0;
    }

    static boolean hasCycle(String[] board)
    {
        int n = board.length, m = board[0].length();
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(!visited[i][j])
                {
                    if(hasCycle(board, visited, i, j, i, j))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean hasCycle(String[] board, boolean[][] visited, int sx, int sy, int i, int j)
    {
        if(visited[i][j])
        {
            return true;
        }
        int[] xDir = { 1, 0, 0, -1};
        int[] yDir = { 0, 1, -1, 0};
        visited[i][j] = true;
        int x, y;
        for(int k = 0; k < xDir.length; k++)
        {
            x = i + xDir[k];
            y = j + yDir[k];
            if(x == sx && y == sy)
            {
                continue;
            }
            // check cordinate validity
            if((x >= 0 && x < board.length) && (y >= 0 && y < board[0].length()))
            {
                if(board[x].charAt(y) == board[i].charAt(j))
                {
                    if(hasCycle(board, visited, i, j, x, y))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
```

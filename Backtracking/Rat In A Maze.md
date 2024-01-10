# Rat In A Maze

```Java
/*
 * Time complexity  : O(3^n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static boolean ratInAMaze(int maze[][])
    {
        Direction[] directions = getDirections();
        int n = maze.length;
        int[][] path = new int[n][n];
        Direction start = new Direction(0, 0);
        Direction end = new Direction(n - 1 , n - 1);
        
        return play(maze, path, directions, start, end);
    }

    private static boolean play
    (int[][] maze, int[][] path, Direction[] directions, Direction start, Direction end)
    {
        // base case: if we reached at the end
        if(start.x == end.x && start.y == end.y)
        {
            return true;
        }
        Direction curr;
        // set the current co-ordinates as visited
        path[start.x][start.y] = 1;
        // for each direction to be visited
        for(Direction d : directions)
        {
            // get the co-ordinates
            curr = d.add(start);
            // if they are valid, check there
            if(isValid(maze, path, curr))
            {
                // if the path leads to end, return true
                if(play(maze, path, directions, curr, end))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static Direction[] getDirections()
    {
        Direction[] directions = new Direction[4];
        directions[0] = new Direction(0, 1);
        directions[1] = new Direction(0, -1);
        directions[2] = new Direction(1, 0);
        directions[3] = new Direction(-1, 0);

        return directions;
    }

    private static boolean isValid(int[][] maze, int[][] path, Direction d)
    {
        return inBounds(maze, d) && !isVisited(path, d) && maze[d.x][d.y] != 0;
    }

    private static boolean isVisited(int[][] path, Direction d)
    {
        return path[d.x][d.y] == 1;
    }

    private static boolean inBounds(int[][] maze, Direction d)
    {
        int n = maze.length;
        if(d.x < n && d.x > -1)
        {
            if(d.y < n && d.y > -1)
            {
                return true;
            }
        }
        return false;
    }
}

class Direction
{
    int x;
    int y;

    public Direction(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Direction add(Direction d)
    {
        return new Direction(x + d.x, y + d.y);
    }
}
```

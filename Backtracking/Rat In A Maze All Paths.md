# Rat In A Maze All Paths

```Java
/*
    Note:
    To get all the test cases accepted, make recursive calls in following order: Top, Down, Left, Right.
    This means that if the current cell is (x, y), then order of calls should be: top cell (x-1, y), 
    down cell (x+1, y), left cell (x, y-1) and right cell (x, y+1).
*/  
/*
 * Time complexity  : O(3^n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void ratInAMaze(int[][] maze, int n) 
    {
        Direction[] directions = getDirections();
        int[][] path = new int[n][n];
        Direction start = new Direction(0, 0);
        Direction end = new Direction(n - 1, n - 1);
        printAllPaths(maze, path, directions, start, end);
    }

    public static void printAllPaths
    (int[][] maze, int[][] path, Direction[] directions, Direction start, Direction end)
    {
        // mark the current co-ordinates as visited
        path[start.x][start.y] = 1;
        // base case: we reached the end, so print the path
        if(start.x == end.x && start.y == end.y)
        {
            printPath(path);
        }
        else
        {
            Direction curr;
            // for each direction
            for(Direction d : directions)
            {
                curr = start.add(d);
                if(isValid(maze, path, curr))
                {
                    // print the path if it leads to the end
                    printAllPaths(maze, path, directions, curr, end);
                }
            }
        }
        // mark this co-ordinate as not visited, as we will backtrack now
        path[start.x][start.y] = 0;
    }

    private static Direction[] getDirections()
    {
        Direction[] directions = new Direction[4];
        // top
        directions[0] = new Direction(0, -1);
        // down
        directions[1] = new Direction(0, 1);
        // left
        directions[2] = new Direction(-1, 0);
        // right
        directions[3] = new Direction(1, 0);

        return directions;
    }

    private static boolean isValid(int[][] maze, int[][] path, Direction d)
    {
        return inBounds(path, d) && !isVisited(path, d) && maze[d.x][d.y] != 0;
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

    private static boolean isVisited(int[][] path, Direction d)
    {
        return path[d.x][d.y] == 1;
    }

    private static void printPath(int[][] path)
    {
        for(int[] arr : path)
        {
            for(int i : arr)
            {
                System.out.print(i + " ");
            }
        }
        System.out.println();
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

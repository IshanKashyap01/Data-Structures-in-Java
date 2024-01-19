# Magic Grid

```Java
/*
 * Time complexity  : O(m*n)
 * Space complexity : O(m*n)
 */
public class Solution
{
    public static int getMinimumStrength(int[][] grid) 
    {
        Direction start = new Direction(0, 0);
        int m = grid.length;
        int n = grid[0].length;
        Direction end = new Direction(m - 1, n - 1);

        // return brute(grid, getDirections(), start, end);
        return rdp(grid, getDirections(), new int[m][n], start, end);
    }

    private static int brute
    (int[][] grid, Direction[] directions, Direction start, Direction end)
    {
        // base case: if we are at the end
        if(start.x == end.x && start.y == end.y)
        {
            return 1;
        }
        Direction curr;
        int min = Integer.MAX_VALUE;
        // Travel to every given direction
        for(Direction d : directions)
        {
            curr = start.add(d);
            if(isValid(grid, curr))
            {
                // find the minimum from curr and subtract its value to it as well
                min = Math.min(min, brute(grid, directions, curr, end) - grid[curr.x][curr.y]);
            }
        }
        // if the min is less than zero, we don't need excessive health
        return min = min <= 0 ? 1 : min;
    }

    private static int rdp
    (int[][] grid, Direction[] directions, int[][] min, Direction start, Direction end)
    {
        // base case: if we are at the end
        if(start.x == end.x && start.y == end.y)
        {
            return 1;
        }
        // return the answer if we already calculated it
        if(min[start.x][start.y] != 0)
        {
            return min[start.x][start.y];
        }
        Direction curr;
        int temp = Integer.MAX_VALUE;
        // Travel to every given direction
        for(Direction d : directions)
        {
            curr = start.add(d);
            if(isValid(grid, curr))
            {
                // find the minimum from curr and subtract its value to it as well
                temp = Math.min(temp, rdp(grid, directions, min, curr, end) - grid[curr.x][curr.y]);
            }
        }
        // if the min is less than zero, we don't need excessive health
        return min[start.x][start.y] = temp <= 0 ? 1 : temp;
    }


    private static Direction[] getDirections()
    {
        Direction[] directions = new Direction[2];
        // down
        directions[0] = new Direction(1, 0);
        // right
        directions[1] = new Direction(0, 1);
        return directions;
    }

    private static boolean isValid(int[][] grid, Direction d)
    {
        int m = grid.length;
        int n = grid[0].length;
        return (d.x > -1 && d.x < m) && (d.y > -1 && d.y < n);
    }

    private static void print2DArray(int[][] mat)
    {
        for(int[] arr : mat)
        {
            for(int i : arr)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class Direction
{
    int x, y;

    Direction()
    {}

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

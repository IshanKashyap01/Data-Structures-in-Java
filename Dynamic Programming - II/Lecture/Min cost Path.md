# Min cost Path

```Java
/*
 * Time complexity  : O(m*n)
 * Space complexity : O(m*n)
 */
/* Complexities for dp and backtracking are same as the recurring problems are
 * already taken care of in backtracking by using path.
 */
public class Solution 
{
    public static int minCostPath(int[][] mat) 
    {
        int m = mat.length;
        int n = mat[0].length;
        Direction start = new Direction(0, 0);
        Direction end = new Direction(m - 1, n - 1);

        // return backtracking(mat, new boolean[m][n], getDirections(), start, end);
        // return rdp(mat, new Integer[m][n], getDirections(), start, end);
        return idp(mat, getDirections(), start, end);
    }

    private static int backtracking
    (int[][] mat, boolean[][] path, Direction[] directions, Direction start, Direction end)
    {
        // base case: we are at the end
        if(start.x == end.x && start.y == end.y)
        {
            return mat[start.x][start.y];
        }
        int min = Integer.MAX_VALUE;
        Direction curr;
        // for each direction
        for(Direction direction : directions)
        {
            curr = start.add(direction);
            // get the cost to end and store the min
            if(isValid(mat, path, curr))
            {
                min = Math.min(min, backtracking(mat, path, directions, curr, end));
            }
        }
        // add curr cost to min and return
        return min + mat[start.x][start.y];
    }

    private static int rdp
    (int[][] mat, Integer[][] cost, Direction[] directions, Direction start, Direction end)
    {
        // keep track of the total cost of each point we have visited
        cost[start.x][start.y] = mat[start.x][start.y];
        if(start.x == end.x && start.y == end.y)
        {
            return cost[start.x][start.y];
        }
        int min = Integer.MAX_VALUE;
        Direction curr;
        // for each direction
        for(Direction d : directions)
        {
            curr = start.add(d);
            if(inBounds(mat, curr))
            {
                // calculate the cost if not done so already
                if(cost[curr.x][curr.y] == null)
                {
                    cost[curr.x][curr.y] = rdp(mat, cost, directions, curr, end);
                }
                min = Math.min(min, cost[curr.x][curr.y]);
            }
        }
        return cost[start.x][start.y] += min;
    }

    // bottom-up approach
    private static int idp
    (int[][] mat, Direction[] directions, Direction start, Direction end)
    {
        int[][] cost = getCostArray(mat);
        // trace the cost to reach end for each cell starting from end
        for(int row = end.x; row >= 0; row--)
        {
            for(int column = end.y; column >= 0; column--)
            {
                int min = Integer.MAX_VALUE;
                Direction curr = new Direction(row, column);
                Direction position;
                // find the minimum cost of all directions
                for(Direction d : directions)
                {
                    // get the position in the direction d
                    position = curr.add(d);
                    // if it is in bounds, store the minimum cost until now
                    if(inBounds(mat, position))
                    {
                        min = Math.min(min, cost[position.x][position.y]);
                    }
                }
                // add the minimum cost (if there is one) to the current position's cost
                cost[curr.x][curr.y] += min == Integer.MAX_VALUE ? 0 : min;
            }
        }
        return cost[start.x][start.y];
    }

    private static Direction[] getDirections()
    {
        Direction[] directions = new Direction[3];
        // down
        directions[0] = new Direction(1, 0);
        // right
        directions[1] = new Direction(0, 1);
        // diagonally right
        directions[2] = new Direction(1, 1);

        return directions;
    }

    private static boolean isValid(int[][] mat, boolean[][] path, Direction d)
    {
        // if the co-ordinate is in bounds and not yet visited
        return inBounds(mat, d) && !isVisited(path, d);
    }

    private static boolean inBounds(int[][] mat, Direction d)
    {
        int m = mat.length;
        int n = mat[0].length;
        return (d.x >= 0 && d.x < m) && (d.y >= 0 && d.y < n);
    }

    private static boolean isVisited(boolean[][] path, Direction d)
    {        
        // this is only useful for diagonals as they're the only ones we might revisit
        return path[d.x][d.y];
    }

    private static int[][] getCostArray(int[][] mat)
    {
        int[][] cost = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[0].length; j++)
            {
                cost[i][j] = mat[i][j];
            }
        }
        return cost;
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
        return new Direction(d.x + x, d.y + y);
    }
}
```

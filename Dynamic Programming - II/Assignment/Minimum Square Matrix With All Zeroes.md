# Minimum Square Matrix With All Zeroes

```Java
/*
 * Time complexity  : O(m*n)
 * Space complexity : O(m*n)
 */
public class Solution 
{
    /* Top-down approach
     *
     * For each zero, we'll check the maximum square that can be made
     * if it was the bottom right corner.
     * The left and top edge of the square will be used as padding
     * to handle the first row, and the first element of each row.
     *
     * For bottom-up approach, each cell will be treated as the top-left
     * corner instead
     */
    public static int findMaxSquareWithAllZeros(int[][] mat)
    {
        // if mat is invalid
        if(mat.length == 0)
        {
            return 0;
        }
        int n = mat.length;
        int m = mat[0].length;
        // array containing the max size of square at every index
        int[][] square = new int[n + 1][m + 1];
        int max = 0;
        // from (1,1) to (n, m) of the square
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                // if the corresponding cell in the matrix is a zero
                if(mat[i - 1][j - 1] == 0)
                {
                    // we will get the minimum of its top, left and top-left
                    square[i][j] = 1 + Math.min(square[i - 1][j], Math.min(square[i][j - 1], square[i - 1][j - 1]));
                    // and update the max
                    max = Math.max(max, square[i][j]);
                }
            }
        }
        return max;
    }
}
```

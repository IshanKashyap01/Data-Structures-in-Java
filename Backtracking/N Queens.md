# N Queens

```Java
/*
 * Time complexity  : O(n^n)
 * Space complexity : O(n)
 */
public class Solution 
{    
    public static void placeNQueens(int n)
    {
        helper(new int[n][n], 0);
    }

    public static void helper(int[][] board, int row)
    {
        // base case: if all queens are placed, print the board
        if(row == board.length)
        {
            printBoard(board);
        }
        else
        {
            // for all columns
            for(int column = 0; column < board.length; column++)
            {
                if(isSafe(board, row, column))
                {
                    // place the queen at this position
                    board[row][column] = 1;
                    // repeat for the next row
                    helper(board, row + 1);
                    // remove her from the row as we now backtrack
                    board[row][column] = 0;
                }
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int column)
    {
        // is there a queen just above?
        for(int i = 0; i < row; i++)
        {
            if(board[i][column] == 1)
            {
                return false;
            }
        }
        // is there a queen in the left diagonal?
        for(int i = row - 1, j = column - 1; i > -1 && j > -1; i--, j--)
        {
            if(board[i][j] == 1)
            {
                return false;
            }
        }
        // is there a queen in the right diagonal?
        for(int i = row - 1, j = column + 1; i > -1 && j < board.length; i--, j++)
        {
            if(board[i][j] == 1)
            {
                return false;
            }
        }
        return true;
    }

    private static void printBoard(int[][] board)
    {
        for(int[] arr : board)
        {
            for(int i : arr)
            {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
```

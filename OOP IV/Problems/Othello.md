# Othello

## Problem Statement

Othello is a board game and you are expected to implement the move function for
this game.

Arguments passed to the function are - a symbol of the player making the move
and x y coordinates of the cell at which the player wishes to make the move.

The move function will be returning a boolean, false - if the move isn't
feasible and true - if the move is feasible and this function will also make
the move then i.e. make the required changes in the board.

## Detailed Explanation

### Input Format

Integer n (Total number of moves)

Player 1 coordinates, x and y (Two integers separated by space)

Player 2 coordinates, x and y (Two integers separated by space)

**Note 1**: Number of moves (i.e. n) is always even and Player 1 always starts
the game.

**Note 2**: If any player's coordinates are not valid, enter again till the
right move. Main function is given for you reference.

```ltf
Sample Input:
2
2 4
1 5
2 5
Sample Output:
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 1 0 0 0 
0 0 0 1 1 0 0 0 
0 0 0 2 1 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
false
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 1 2 0 0 
0 0 0 1 2 0 0 0 
0 0 0 2 1 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0
```

## Solution

```java
public class OthelloBoard 
{
    private int board[][];
    final static int player1Symbol = 1;
    final static int player2Symbol = 2;
    private static final int[] xDirections = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] yDirections = {1, 1, 0, -1, -1, -1, 0, 1};
    
    public OthelloBoard() 
    {
        board = new int[8][8];
        board[3][3] = player1Symbol;
        board[3][4] = player2Symbol;
        board[4][3] = player2Symbol;
        board[4][4] = player1Symbol;
    }

    public void print() 
    {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean move(int symbol, int row, int column)
    {
        // check if the position is valid and empty
        if(areCoordinatesOutOfBounds(row, column) || this.board[row][column] != 0)
        {
            return false;
        }
        // check in all 8 directions to find opponent pieces that can be converted
        boolean isValid = false;
        for(int i = 0; i < 8; i++)
        {
            if(convertOpponentPiecesInDirection(row, column, symbol, xDirections[i], yDirections[i]))
            {
                isValid = true;
            }
        }
        // if there were conversions, put the player's symbol at the position
        if(isValid)
        {
            this.board[row][column] = symbol;
        }
        return isValid;
    }

    private boolean areCoordinatesOutOfBounds(int row, int column)
    {
        return row < 0 || row > 7 || column < 0 || column > 7;
    }

    private boolean convertOpponentPiecesInDirection(int row, int column, int symbol, int x, int y)
    {
        // the piece right next should be opponent's
        int xEnd = row + x;
        int yEnd = column + y;
        if(areCoordinatesOutOfBounds(xEnd, yEnd) || this.board[xEnd][yEnd] == 0 || this.board[xEnd][yEnd] == symbol)
        {
            return false;
        }
        // move in the given direction as long as there are opponent's pieces
        while(!areCoordinatesOutOfBounds(xEnd, yEnd) && this.board[xEnd][yEnd] == this.board[row + x][column + y])
        {
            xEnd += x;
            yEnd += y;
        }
        // the last position should contain the player's symbol
        if(areCoordinatesOutOfBounds(xEnd, yEnd) || this.board[xEnd][yEnd] != symbol)
        {
            return false;
        }
        // move back and turn all pieces to player's
        while(xEnd != row || yEnd != column)
        {
            this.board[xEnd][yEnd] = symbol;
            xEnd -= x;
            yEnd -= y;
        }
        return true;
    }
}
```

The main function used internally:

```java
import java.util.Scanner;

public class Runner {

    static Scanner s = new Scanner(System.in);

    final static int player1Symbol = 1;
    final static int player2Symbol = 2;

    public static void main(String[] args) {
        OthelloBoard b = new OthelloBoard();
        int n = s.nextInt();
        boolean p1Turn = true;
        while(n > 0) {
            int x = s.nextInt();
            int y = s.nextInt();
            boolean ans = false;
            if(p1Turn) {
                ans = b.move(player1Symbol, x, y);
            }
            else {
                ans = b.move(player2Symbol, x, y);
            }
            if(ans) {
                b.print();
                p1Turn = !p1Turn;
                n--;
            }
            else {
                System.out.println(ans);
            }
        }
    }
}
```

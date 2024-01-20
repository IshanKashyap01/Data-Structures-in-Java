# TicTacToeEngine

```Java
import java.util.Scanner;

public class TicTacToeEngine 
{
    Player p1;
    Player p2;
    Board board;
    private static final int BOARD_SIZE = 3;
    
    public TicTacToeEngine(Player p1, Player p2)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.board = new Board(BOARD_SIZE);
    }

    public void printBoard()
    {
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            for(int j = 0; j < BOARD_SIZE; j++)
            {
                System.out.print("| " + board.get(i, j) + " ");
                if(board.get(i, j) == '\0')
                {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println();
    }

    /*
     * start the game with player 1 and continue until the game ends
     * ask for co-ordinates for the player and put the symbol there
     */
    public void startGame(Scanner scanner)
    {
        // signal for checking whose turn it is
        boolean turn1 = false;
        // number of turns
        int turns = 0;
        while(!gameWon() && turns != 9)
        {
            turn1 = !turn1;
            if(turn1)
            {
                takeTurn(p1, scanner);
            }
            else
            {
                takeTurn(p2, scanner);
            }
            turns++;
            printBoard();
        }
        if(turns == 9)
        {
            System.out.println("DRAW");
        }
        else
        {
            Player winner = turn1 ? p1 : p2;
            System.out.println(winner.getName() + " WINS!!");
        }
    }

    private void takeTurn(Player player, Scanner scanner)
    {
        System.out.println(player.getName() + ": ");
        int[] cordinates = inputCordinates(scanner);
        // if the cordinates are already taken
        while(!board.isEmpty(cordinates[0], cordinates[1]))
        {
            System.out.println("ERROR: co-ordinate already taken");
            cordinates = inputCordinates(scanner);
        }
        board.set(player.getSymbol(), cordinates[0], cordinates[1]);
    }

    private int[] inputCordinates(Scanner scanner)
    {
        int[] cordinates = new int[2];
        cordinates[0] = scanner.nextInt() - 1;
        cordinates[1] = scanner.nextInt() - 1;
        // if cordinates are invalid
        if(!isValid(cordinates[0], cordinates[1]))
        {
            System.out.println("ERROR: invalid co-ordinates");
            return inputCordinates(scanner);
        }
        return cordinates;
    }

    private boolean gameWon()
    {
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            // check rows
            if(checkLine(board.get(i, 0), board.get(i, 1), board.get(i, 2)))
            {
                return true;
            }
            // check columns
            if(checkLine(board.get(0, i), board.get(1, i), board.get(2, i)))
            {
                return true;
            }
        }
        // check left to right diagonal
        if(checkLine(board.get(0, 0), board.get(1, 1), board.get(2, 2)))
        {
            return true;
        }
        // check right to left diagonal
        return checkLine(board.get(0, 2), board.get(1, 1), board.get(2, 0));
    }

    private boolean checkLine(char a, char b, char c)
    {
        return a != '\0' && a == b && b == c;
    }

    private boolean isValid(int i, int j)
    {
        return (i >= 0 && i < BOARD_SIZE) && (j >= 0 && j < BOARD_SIZE);
    }
}
```

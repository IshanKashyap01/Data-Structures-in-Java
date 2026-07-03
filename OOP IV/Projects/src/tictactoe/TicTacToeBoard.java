package tictactoe;

public class TicTacToeBoard 
{
    private char[][] board;

    public TicTacToeBoard()
    {
        this.board = new char[3][3];
    }

    public boolean makeMove(int row, int col, char symbol)
    {
        if(isInputValid(row, col))
        {
            this.board[row][col] = symbol;
            return true;
        }
        return false;
    }

    private boolean isInputValid(int row, int column)
    {
        if(row < 0 || row > 2)
        {
            return false;
        }
        if(column < 0 || column > 2)
        {
            return false;
        }
        return this.board[row][column] == '\0';
    }

    public boolean isWinner(char symbol)
    {
        for(int i = 0; i < 3; i++)
        {
            // check rows
            if(this.board[i][0] == symbol && this.board[i][1] == symbol && this.board[i][2] == symbol)
            {
                return true;
            }
            // check columns
            if(this.board[0][i] == symbol && this.board[1][i] == symbol && this.board[2][i] == symbol)
            {
                return true;
            }
        }
        // check diagonals
        if(this.board[0][0] == symbol && this.board[1][1] == symbol && this.board[2][2] == symbol)
        {
            return true;
        }
        return this.board[0][2] == symbol && this.board[1][1] == symbol && this.board[2][0] == symbol;
    }

    public void printBoard()
    {
        for(char[] row : this.board)
        {
            System.out.print("|");
            for(char cell : row)
            {
                System.out.print(" " + cell + " |");
            }
            System.out.println();
        }
    }
}

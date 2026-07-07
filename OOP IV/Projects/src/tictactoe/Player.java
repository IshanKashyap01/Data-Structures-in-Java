package tictactoe;

/**
 * Represents a player in the Tic Tac Toe game.
 * @author Ishan Kashyap
 */
public class Player 
{
    private String name;
    private char symbol;

    public Player(char symbol)
    {
        this.setSymbol(symbol);
    }

    public String getName() 
    {
        return this.name;
    }

    public boolean setName(String name) 
    {
        if(name == null || name.isBlank())
        {
            return false;
        }
        this.name = name;
        return true;
    }

    public char getSymbol() 
    {
        return this.symbol;
    }

    public boolean setSymbol(char symbol)
    {
        if(symbol != 'X' && symbol != 'O')
        {
            return false;
        }
        this.symbol = symbol;
        return true;
    }
}

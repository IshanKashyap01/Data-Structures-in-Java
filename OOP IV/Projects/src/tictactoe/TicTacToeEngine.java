package tictactoe;

import java.util.Scanner;
/**
 * Controls the flow of the game from start to finish
 */
public class TicTacToeEngine
{
    private TicTacToeBoard board;
    private Player player1;
    private Player player2;
    private static Scanner inputScanner = new Scanner(System.in);

    public TicTacToeEngine()
    {
        this.board = new TicTacToeBoard();
    }

    /**
     * Starts the game and run it until a player wins or the game ends in a draw
     */
    public void startGame()
    {
        initialisePlayers();
        Player currentPlayer = player1;
        for(int i = 0; i < 9; i++)
        {
            takeTurn(currentPlayer);
            this.board.printBoard();
            if(i >= 4 && this.board.isWinner(currentPlayer.getSymbol()))
            {
                System.out.println(currentPlayer.getName() + " wins!!");
                return;
            }
            currentPlayer = currentPlayer == this.player1 ? this.player2 : this.player1;
        }
        System.out.println("Game ends in draw");
    }

    private void initialisePlayers()
    {
        // instead of remaking them each game
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        inputPlayerName(player1, 1);
        inputPlayerName(player2, 2);
    }

    /**
     * Inputs the player name. Retakes if the name is incorrect
     * @param player player whose name is to be input
     * @param num number of the current player (1 or 2)
     */
    private void inputPlayerName(Player player, int num)
    {
        System.out.print("Input player " + num + "'s name: ");
        if(!player.setName(inputScanner.nextLine()))
        {
            System.out.println("Name cannot be empty! Try again");
            inputPlayerName(player, num);
        }
    }

    /**
     * Takes input for the {@code player}'s turn. Retakes if the input is incorrect.
     * @param player player who will take this turn
     */
    private void takeTurn(Player player)
    {
        System.out.print("Enter co-ordinates: ");
        int row = inputScanner.nextInt();
        int column = inputScanner.nextInt();
        if(!this.board.makeMove(row, column, player.getSymbol()))
        {
            System.out.println("Incorrect co-ordinates! try again.");
            takeTurn(player);
        }
    }
}

# TicTacToe

```Java
import java.util.Scanner;

public class TicTacToe 
{
    public static void main(String[] args) 
    {
        // input game details
        Scanner scanner = new Scanner(System.in);
        Player p1 = inputPlayer(1, scanner);
        Player p2 = inputPlayer(2, scanner);
        while(p2.getName().equals(p1.getName()) || p2.getSymbol() == p1.getSymbol())
        {
            System.out.println("ERROR: Duplicate details\n");
            p2 = inputPlayer(2, scanner);
        }
        // initialise the engine and start the game
        TicTacToeEngine engine = new TicTacToeEngine(p1, p2);
        engine.startGame(scanner);
        scanner.close();
    }

    private static Player inputPlayer(int num, Scanner scanner)
    {
        System.out.println("Enter details for player " + num);
        // input player name
        String name = inputPlayerName(scanner);
        // input player symbol
        char symbol = inputPlayerSymbol(scanner);
        // return the player
        return new Player(name, symbol);
    }

    private static String inputPlayerName(Scanner scanner)
    {
        System.out.print("Name of player: ");
        String name = scanner.next();
        System.out.println();
        return name;
    }

    private static char inputPlayerSymbol(Scanner scanner)
    {
        System.out.print("Symbol: ");
        char symbol = scanner.next().charAt(0);
        System.out.println();
        return symbol;
    }
}
```

# Coin Tower

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static String findWinner(int n, int x, int y) 
    {
        return idp(n, x, y) ? "Beerus" : "Whis";
    }

    private static boolean idp(int n, int x, int y)
    {
        if(x > y)
        {
            int k = x;
            x = y;
            y = k;
        }
        boolean[] winner = new boolean[n + 1];
        // I'm player 1 and I play first, if I don't get to pick the last coin, he wins
        winner[1] = true;
        // who wins for each position from 2 to n
        for(int i = 2; i <= n; i++)
        {
            if(i == 1 || i == x || i == y)
            {
                winner[i] = true;
            }
            else if(i < x)
            {
                // if he wins at i - 1, then I'll have the last coin at i
                winner[i] = !winner[i - 1];
            }
            // I have a few options now
            // If I lose at any of the next position, I'll get him to play that
            // if I win at either of the next positions, I can't win
            else if (i < y)
            {
                winner[i] = !(winner[i - 1] && winner[i - x]);
            }
            else
            {
                winner[i] = !(winner[i - 1] && winner[i - x] && winner[i - y]);
            }
        }
        return winner[n];
    }
}
```

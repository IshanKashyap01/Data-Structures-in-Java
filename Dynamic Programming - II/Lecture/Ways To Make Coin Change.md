# Ways To Make Coin Change

```Java
import java.util.Arrays;
/*
 * Time complexity  : O(n*value)
 * Space complexity : O(n*value)
 */
public class Solution 
{    
    public static int countWaysToMakeChange(int[] coins, int value)
    {
        // return brute(coins, value, 0);
        // return rdp(coins, getDPArray(coins, value), value, 0);
        return idp(coins, value);
    }

    private static int brute(int[] coins, int value, int i)
    {
        // base case: if we reached the end or value is/became 0
        if(i == coins.length)
        {
            return 0;
        }
        if(value == 0)
        {
            return 1;
        }
        int total = 0;
        // if the coin's value is less than the value
        if(coins[i] <= value)
        {
            // keep using this coin until we no longer can
            total += brute(coins, value - coins[i], i);
        }
        // otherwise we'll move on to the next coin
        total += brute(coins, value, i + 1);
        // return the total ways
        return total;
    }

    private static int rdp(int[] coins, int[][] total, int value, int i)
    {
        // base case: if we reached the end or value is 0
        if(i == coins.length)
        {
            return 0;
        }
        if(value == 0)
        {
            return 1;
        }
        // return the total if it is already calculated
        if(total[i][value] != -1)
        {
            return total[i][value];
        }
        total[i][value] = 0;
        // if the coin's value is less than the value
        if(coins[i] <= value)
        {
            // keep using this coin until we no longer can
            total[i][value] += rdp(coins, total, value - coins[i], i);
        }
        // otherwise we'll move on to the next coin
        total[i][value] += rdp(coins, total, value, i + 1);
        // return the total ways
        return total[i][value];
    }

    // bottom-up approach
    private static int idp(int[] coins, int value)
    {
        // dp array to hold total for each value and coin pair
        int[][] total = new int[coins.length + 1][value + 1];
        // the total for value 0 for every coin is 1
        for(int i = 0; i < coins.length; i++)
        {
            total[i][0] = 1;
        }
        // for each coin starting from the last
        for(int i = coins.length - 1; i >= 0; i--)
        {
            // for every value starting from 1
            for(int v = 1; v <= value; v++)
            {
                // if the coin's value is less than the current value
                if(coins[i] <= v)
                {
                    total[i][v] += total[i][v - coins[i]];
                }
                total[i][v] += total[i + 1][v];
            }
        }
        return total[0][value];
    }

    private static int[][] getDPArray(int[] coins, int value)
    {
        int[][] dp = new int[coins.length][value + 1];
        for(int[] arr : dp)
        {
            Arrays.fill(arr, -1);
        }
        return dp;
    }
}
```

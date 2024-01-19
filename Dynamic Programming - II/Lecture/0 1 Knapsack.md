# 0 1 Knapsack

```Java
/*
 * Time complexity  : O(max*n)
 * Space complexity : O(max*n)
 */
public class Solution 
{
    public static int knapsack(int[] weights, int[] values, int n, int max) 
    {
        // return brute(weights, values, 0, max);
        // return rdp(weights, values, new Integer[n][max + 1], 0, max);
        return idp(weights, values, n, max);
    }

    private static int brute(int[] weights, int[] values, int i, int max)
    {
        if(max == 0 || i == values.length)
        {
            return 0;
        }
        int exclude = brute(weights, values, i + 1, max);
        if(weights[i] <= max)
        {
            int include = values[i] + brute(weights, values, i + 1, max - weights[i]);
            return Math.max(include, exclude);
        }
        return exclude;
    }

    private static int rdp(int[] weights, int[] values, Integer[][] dp, int i, int max)
    {
        // base case: if knapsack is full or we reached the end
        if(max == 0 || i == values.length)
        {
            return 0;
        }
        // return if we already have the value
        if(dp[i][max] != null)
        {
            return dp[i][max];
        }
        // exclude the current item
        int exclude = rdp(weights, values, dp, i + 1, max);
        dp[i][max] = exclude;
        if(weights[i] <= max)
        {
            // include the current item
            int include =values[i] + rdp(weights, values, dp, i + 1, max - weights[i]);
            // max value will be max of inclusion and exclusion
            dp[i][max] = Math.max(include, exclude);
        }
        return dp[i][max];
    }

    private static int idp(int[] weights, int[] values, int n, int max)
    {
        int[][] dp = new int[n + 1][max + 1];
        int include, exclude;
        for(int i = n - 1; i > -1; i--)
        {
            for(int w = 0; w <= max; w++)
            {
                exclude = dp[i + 1][w];
                dp[i][w] = exclude;
                if(weights[i] <= w)
                {
                    include = values[i] + dp[i + 1][w - weights[i]];
                    dp[i][w] = Math.max(include, exclude);
                }
            }
        }
        return dp[0][max];
    }
}
```

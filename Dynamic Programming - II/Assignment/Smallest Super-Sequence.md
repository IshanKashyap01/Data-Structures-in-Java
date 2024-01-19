# Smallest Super-Sequence

```Java
import java.util.Arrays;
/*
 * Time complexity  : O(m*n)
 * Space complexity : O(m*n)
 */
public class Solution 
{
    public static int smallestSuperSequence(String s, String t)
    {
        // return brute(s, t, 0, 0);
        // return rdp(s, t, getDPArray(s.length(), t.length()), 0, 0);
        return idp(s, t);
    }

    private static int brute(String s, String t, int i, int j)
    {
        // base case: if one of the string is empty
        if(i == s.length() || j == t.length())
        {
            // return the remaining characters in the non-empty string
            return Math.max(s.length() - i, t.length() - j);
        }
        // if the characters at i and j are equal
        if(s.charAt(i) == t.charAt(j))
        {
            // count this character once and remove it from both
            return 1 + brute(s, t, i + 1, j + 1);
        }
        // find the min of the next substring of both and count the removed character
        return 1 + Math.min(brute(s, t, i + 1, j), brute(s, t, i, j + 1));
    }

    private static int rdp(String s, String t, int[][] dp, int i, int j)
    {
        // base case: if one of the string is empty
        if(i == s.length() || j == t.length())
        {
            // return the remaining characters in the non-empty string
            return Math.max(s.length() - i, t.length() - j);
        }
        // return the answer if it is already calculated
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        // if the characters at i and j are equal
        if(s.charAt(i) == t.charAt(j))
        {
            // count this character once and remove it from both
            return dp[i][j] = 1 + rdp(s, t, dp, i + 1, j + 1);
        }
        // find the min of the next substring of both and count the removed character
        return dp[i][j] = 1 + Math.min(rdp(s, t, dp, i + 1, j), rdp(s, t, dp, i, j + 1));
    }

    // top-down approach
    private static int idp(String s, String t)
    {
        // array to store size of super sequences for every pair of i and j
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // base case: size of sequence at least one string is empty
        for(int j = 0; j <= t.length(); j++)
        {
            dp[0][j] = j;
        }
        for(int i = 0; i <= s.length(); i++)
        {
            dp[i][0] = i;
        }
        // for each character in s and t in dp
        for(int i = 1; i <= s.length(); i++)
        {
            // deduce the value of each cell by using the recurrence relation
            for(int j = 1; j <= t.length(); j++)
            {
                if(s.charAt(i - 1) == t.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // the final value will be at the end of the array
        return dp[s.length()][t.length()];
    }

    private static int[][] getDPArray(int m, int n)
    {
        int[][] dp = new int[m][n];
        for(int[] arr : dp)
        {
            Arrays.fill(arr, -1);
        }
        return dp;
    }
}
```

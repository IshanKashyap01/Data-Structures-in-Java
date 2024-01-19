# Longest Common Subsequence

```Java
import java.util.Arrays;
/*
 * Time complexity  : O(m*n)
 * Space complexity : O(m*n)
 */
public class Solution 
{
    public static int lcs(String s, String t) 
    {
        // return brute(s, t, 0, 0);
        // return rdp(s, t, getSubsequenceCountArray(s, t), 0, 0);
        return idp(s, t);
    }

    private static int brute(String s, String t, int i, int j)
    {
        if(i >= s.length() || j >= t.length())
        {
            return 0;
        }
        if(s.charAt(i) == t.charAt(j))
        {
            return 1 + brute(s, t, i + 1, j + 1);
        }
        return Math.max(brute(s, t, i + 1, j), brute(s, t, i, j + 1));
    }

    private static int rdp(String s, String t, int[][] count, int i, int j)
    {
        if(i >= s.length() || j >= t.length())
        {
            return 0;
        }
        if(count[i][j] == -1)
        {
            if(s.charAt(i) == t.charAt(j))
            {
                if(count[i + 1][j + 1] == -1)
                {
                    count[i + 1][j + 1] = rdp(s, t, count, i + 1, j + 1);
                }
                count[i][j] = 1 + count[i + 1][j + 1];
            }
            else
            {
                if(count[i + 1][j] == -1)
                {
                    count[i + 1][j] = rdp(s, t, count, i + 1, j);
                }
                if(count[i][j + 1] == -1)
                {
                    count[i][j + 1] = rdp(s, t, count, i, j + 1);
                }
                count[i][j] = Math.max(count[i + 1][j], count[i][j + 1]);
            }
        }
        return count[i][j];
    }

    // bottom-up approach
    private static int idp(String s, String t)
    {
        int[][] count = new int[s.length() + 1][t.length() + 1];
        for(int i = s.length() - 1; i >= 0; i--)
        {
            for(int j = t.length() - 1; j >= 0; j--)
            {
                if(s.charAt(i) == t.charAt(j))
                {
                    count[i][j] = 1 + count[i + 1][j + 1];
                }
                else
                {
                    count[i][j] = Math.max(count[i + 1][j], count[i][j + 1]);
                }
            }
        }
        return count[0][0];
    }

    private static int[][] getSubsequenceCountArray(String s, String t)
    {
        int[][] count = new int[s.length() + 1][t.length() + 1];
        for(int[] arr : count)
        {
            Arrays.fill(arr, -1);
        }
        return count;
    }
}
```

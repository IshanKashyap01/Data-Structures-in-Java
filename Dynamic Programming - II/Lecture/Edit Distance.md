# Edit Distance

```Java
import java.util.Arrays;
/*
 * Time complexity  : O(m*n)
 * Space complexity : O(m*n)
 */
public class Solution 
{
    public static int editDistance(String s, String t) 
    {
        // return brute(s, t, 0, 0);
        // return rdp(s, t, getRdpArray(s, t), 0, 0);
        return idp(s, t);
    }

    private static int brute(String s, String t, int i, int j)
    {
        // base case: if one of the string is empty
        if(i == s.length() || j == t.length())
        {
            // return the length of the remaining non-empty string
            return Math.max(s.length() - i, t.length() - j);
        }
        if(s.charAt(i) == t.charAt(j))
        {
            return brute(s, t, i + 1, j + 1);
        }
        int replace = brute(s, t, i + 1, j + 1);
        int delete = brute(s, t, i + 1, j);
        int insert = brute(s, t, i, j + 1);

        return 1 + Math.min(replace, Math.min(delete, insert));
    }

    private static int rdp(String s, String t, int[][] changes, int i, int j)
    {
        // base case: if one of the string is empty
        if(i == s.length() || j == t.length())
        {
            // return the length of the remaining non-empty string
            return Math.max(s.length() - i, t.length() - j);
        }
        if(changes[i][j] == -1)
        {
            if(changes[i + 1][j + 1] == -1)
            {
                changes[i + 1][j + 1] = rdp(s, t, changes, i + 1, j + 1);
            }
            if(s.charAt(i) == t.charAt(j))
            {
                changes[i][j] = changes[i + 1][j + 1];
            }
            else
            {
                if(changes[i + 1][j] == -1)
                {
                    changes[i + 1][j] = rdp(s, t, changes, i + 1, j);
                }
                if(changes[i][j + 1] == -1)
                {
                    changes[i][j + 1] = rdp(s, t, changes, i, j + 1);
                }
                changes[i][j] = 1 + Math.min(changes[i + 1][j + 1], Math.min(changes[i + 1][j], changes[i][j + 1]));
            }
        }
        return changes[i][j];
    }


    private static int[][] getRdpArray(String s, String t)
    {
        int[][] changes = new int[s.length() + 1][t.length() + 1];
        for(int[] arr : changes)
        {
            Arrays.fill(arr, -1);
        }
        return changes;
    }
}
```

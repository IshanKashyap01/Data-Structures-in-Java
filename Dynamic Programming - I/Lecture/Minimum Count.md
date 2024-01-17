# Minimum Count

```Java
/*
 * Time complexity  : O(n√n)*
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int minCount(int n) 
    {
        // return brute(n);
        // return rdp(n, getCountArray(n));
        return idp(n);
    }

    // Time complexity: O(n^n)
    private static int brute(int n)
    {
        if(n == 0)
        {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++)
        {
            min = Math.min(min, 1 + brute(n - i * i));
        }
        return min;
    }

    private static int rdp(int n, int[] count)
    {
        if(n == 0)
        {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++)
        {
            if(count[n - i * i] == -1)
            {
                count[n - i * i] = rdp(n - i * i, count);
            }
            min = Math.min(min, 1 + count[n - i * i]);
        }
        return min;
    }

    private static int idp(int n)
    {
        int[] steps = new int[n + 1];
        int min;
        // for each number from i to n
        for(int i = 1; i <= n; i++)
        {
            // find the min steps to i
            min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++)
            {
                min =  Math.min(min, steps[i - j * j]);
            }
            steps[i] = 1 + min;
        }
        return steps[n];
    }

    private static int[] getCountArray(int n)
    {
        int[] arr = new int[n + 1];
        for(int i = 0; i <= n; i++)
        {
            arr[i] = -1;
        }
        return arr;
    }
}
```

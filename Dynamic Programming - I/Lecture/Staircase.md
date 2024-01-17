# Staircase

```Java
public class Solution 
{
    public static long staircase(int n) 
    {
        // return brute(n);
        // return rdp(n, getStepsArray(n));
        return idp(n);
    }

    /*
     * Time complexity  : O(3^n)
     * Space complexity : O(n)
     */
    private static long brute(int n)
    {
        if(n == 0)
        {
            return 1L;
        }
        if(n < 3)
        {
            return n;
        }
        return brute(n - 1) + brute(n - 2) + brute(n - 3);
    }

    /*
     * Time complexity  : O(n)
     * Space complexity : O(n)
     */
    private static long rdp(int n, long steps[])
    {
        if(n < 0)
        {
            return 0L;
        }
        if(n == 0)
        {
            return 1L;
        }
        if(steps[n] != -1)
        {
            return steps[n];
        }
        steps[n] = rdp(n - 1, steps) + rdp(n - 2, steps) + rdp(n - 3, steps);
        return steps[n];
    }

    /*
     * Time complexity  : O(3^n)
     * Space complexity : O(n)
     */
    private static long idp(int n)
    {
        if(n < 3)
        {
            return n;
        }
        long[] steps = new long[n + 1];
        steps[0] = steps[1] = 1;
        steps[2] = 2;
        for(int i = 3; i <= n; i++)
        {
            steps[i] = steps[i - 1] + steps[i - 2] + steps[i - 3];
        }
        return steps[n];
    }

    private static long[] getStepsArray(int n)
    {
        long[] steps = new long[n + 1];
        for(int i = 0; i <= n; i++)
        {
            steps[i] = -1;
        }
        return steps;
    }
}
```

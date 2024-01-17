# Min Steps to 1 using DP

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int countMinStepsToOne(int n) 
    {
        // return rdp(n, getStepsArray(n));
        return idp(n);
    }

    private static int rdp(int n, int[] steps)
    {
        if(n == 1)
        {
            return 0;
        }
        if(steps[n - 1] == -1)
        {
            steps[n - 1] = 1 + rdp(n - 1, steps);
        }
        int min = steps[n - 1];
        
        if(n % 2 == 0)
        {
            steps[n / 2] = (steps[n / 2] == -1) ? 1 + rdp(n / 2, steps) : steps[n / 2];
            min = Math.min(min, steps[n / 2]);
        }
        if(n % 3 == 0)
        {
            steps[n / 3] = (steps[n / 3] == -1) ? 1 + rdp(n / 3, steps) : steps[n / 3];
            min = Math.min(min, steps[n / 3]);
        }
        return min;
    }

    private static int idp(int n)
    {
        int[] steps = new int[n + 1];
        for(int i = 2; i <= n; i++)
        {
            steps[i] = 1 + steps[i - 1];
            if(i % 2 == 0)
            {
                steps[i] = Math.min(steps[i], 1 + steps[i / 2]);
            }
            if(i % 3 == 0)
            {
                steps[i] = Math.min(steps[i], 1 + steps[i / 3]);
            }
        }
        return steps[n];
    }

    private static int[] getStepsArray(int n)
    {
        int[] steps = new int[n + 1];
        for(int i = 0; i <= n; i++)
        {
            steps[i] = -1;
        }
        return steps;
    }
}
```

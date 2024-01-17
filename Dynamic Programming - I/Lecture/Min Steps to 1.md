# Min Steps to 1

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int countMinStepsToOne(int n) 
    {
        if(n == 1)
        {
            return 0;
        }
        int steps = Integer.MAX_VALUE;
        if(n % 3 == 0)
        {
            steps = Math.min(steps, 1 + countMinStepsToOne(n / 3));
        }
        if(n % 2 == 0)
        {
            steps = Math.min(steps, 1 + countMinStepsToOne(n / 2));
        }
        steps = Math.min(steps, 1 + countMinStepsToOne(n - 1));
        return steps;
    }
}
```

# Sum Of Array

```Java
public class Solution 
{
    public static int sum(int input[]) 
    {
        return helper(input, 0);
    }

    private static int helper(int[] arr, int index)
    {
        if(index == arr.length)
        {
            return 0;
        }
        return arr[index] + helper(arr, index + 1);
    }
}
```

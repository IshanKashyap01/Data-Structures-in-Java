# Check Number in Array

```Java
public class Solution 
{    
    public static boolean checkNumber(int input[], int x) 
    {
        return helper(input, x, 0);
    }

    private static boolean helper(int[] arr, int x, int index)
    {
        if(index == arr.length)
        {
            return false;
        }
        return arr[index] == x ? true : helper(arr, x, index + 1);
    }
}
```

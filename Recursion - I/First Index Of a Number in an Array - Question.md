# First Index Of a Number in an Array - Question

```Java
public class Solution 
{
    public static int firstIndex(int input[], int x) 
    {
        return helper(input, x, 0);
    }

    private static int helper(int[] input, int x, int index)
    {
        if(index == input.length)
        {
            return -1;
        }
        return input[index] == x ? index : helper(input, x, index + 1);
    }
}
```

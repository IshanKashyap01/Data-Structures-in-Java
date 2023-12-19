# Last Index Of a Number in an Array - Question

```Java
public class Solution 
{
    public static int lastIndex(int input[], int x) 
    {
        return helper(input, x, input.length - 1);
    }

    private static int helper(int[] input, int x, int index)
    {
        if(index == -1)
        {
            return index;
        }
        return input[index] == x ? index : helper(input, x, index - 1);
    }
}
```

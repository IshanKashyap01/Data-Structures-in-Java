# Duplicate in array

```Java
/*
 * Time complexity    : O(n)
 */
public class Solution 
{
    public static int findDuplicate(int[] arr) 
    {
        int n = arr.length;
        int nsum = (n - 2) * (n - 1) / 2;
        int sum = 0;
        for(int i : arr)
        {
            sum += i;
        }
        return sum - nsum;
    }
}
```

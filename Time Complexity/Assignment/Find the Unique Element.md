# Find the Unique Element

```Java
/*
 * Time complexity    : O(n)
 */
public class Solution 
{
    public static int findUnique(int[] arr) 
    {
        int ans = 0;
        for(int i : arr)
        {
            ans ^= i;
        }
        return ans;
    }
}
```

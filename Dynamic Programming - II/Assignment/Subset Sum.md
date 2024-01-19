# Subset Sum

```Java
/*
 * Time complexity  : O(2^n)
 * Space complexity : O(n)
 */
public class Solution
{
    static boolean isSubsetPresent(int[] arr, int n, int sum) 
    {
        return hepler(arr, 0, sum);
    }

    private static boolean hepler(int[] arr, int i, int sum)
    {
        if(i == arr.length)
        {
            return false;
        }
        if(arr[i] == sum ||sum == 0)
        {
            return true;
        }
        // as values in arr will never be smaller than 1
        if(arr[i] > sum)
        {
            return hepler(arr, i + 1, sum);
        }
        return hepler(arr, i + 1, sum) || hepler(arr, i + 1, sum - arr[i]);
    }
}
```

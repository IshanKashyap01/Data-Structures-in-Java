# Array Equilibrium Index

```Java
/*
 * Time complexity    : O(n)
 */
public class Solution 
{
    public static int arrayEquilibriumIndex(int[] arr)
    {
        int left = 0, right = 0;
        for(int i = 1; i < arr.length; i++)
        {
            right += arr[i];
        }
        for(int i = 1; i < arr.length; i++)
        {
            left += arr[i - 1];
            right -= arr[i];
            if(left == right)
            {
                return i;
            }
        }
        return -1;
    }
}
```

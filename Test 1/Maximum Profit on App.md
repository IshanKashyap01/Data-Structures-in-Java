# Maximum Profit on App

```Java
import java.util.Arrays;

/*
 * Time complexity    : O(n)
 * Space complexity    : O(1)
 */
public class solution 
{
    public static int maximumProfit(int arr[]) 
    {
        Arrays.sort(arr);
        int n = arr.length, max = 0;
        for(int i = 0; i < arr.length; i++, n--)
        {
            max = Math.max(arr[i] * n, max);
        }
        return max;
    }
}
```

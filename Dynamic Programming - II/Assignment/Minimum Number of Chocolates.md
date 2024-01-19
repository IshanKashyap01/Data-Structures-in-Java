# Minimum Number of Chocolates

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int getMin(int[] arr, int n)
    {
        // array to store number of chocolates
        int[] chocolates = new int[n];
        chocolates[0] = 1;
        // left to right traversal
        for(int i = 1; i < n; i++)
        {
            // compare with the student on the left
            chocolates[i] = arr[i] > arr[i - 1] ? chocolates[i - 1] + 1 : 1;
        }
        // right to left traversal
        int temp;
        for(int i = n - 2; i >= 0; i--)
        {
            // compare with the student on the right
            temp = arr[i] > arr[i + 1] ? chocolates[i + 1] + 1 : 1;
            // compare the required chocolates for both sides
            chocolates[i] = Math.max(chocolates[i], temp);
        }
        int sum = 0;
        for(int i : chocolates)
        {
            sum += i;
        }
        return sum;
    }
}
```

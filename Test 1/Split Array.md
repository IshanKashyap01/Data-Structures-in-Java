# Split Array

```Java
/*
 * Time complexity    : O(2^n)
 * Space complexity    : O(n)
 */
public class solution 
{
    public static boolean splitArray(int arr[]) 
    {
        return helper(arr, 0, 0, 0);
    }

    private static boolean helper(int[] arr, int i, int sumA, int sumB)
    {
        if(i == arr.length)
        {
            return sumA == sumB;
        }
        if(arr[i] % 5 == 0)
        {
            return helper(arr, i + 1, sumA + arr[i], sumB);
        }
        else if(arr[i] % 3 == 0)
        {
            return helper(arr, i + 1, sumA, sumB + arr[i]);
        }
        return helper(arr, i + 1, sumA + arr[i], sumB) || helper(arr, i + 1, sumA, sumB + arr[i]);
    }
}
```

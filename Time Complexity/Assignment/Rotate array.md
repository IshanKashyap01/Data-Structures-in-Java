# Rotate array

```Java
/*
 * Time complexity  : O(n)
 */
public class Solution
{
    public static void rotate(int[] arr, int d) 
    {
        // reverse the complete array
        reverse(arr, 0, arr.length - 1);
        // reverse the d elements originally from the front
        reverse(arr, arr.length - d, arr.length - 1);
        // reverse the remaining elements
        reverse(arr, 0, arr.length - d - 1);
    }

    private static void reverse(int[] arr, int start, int end)
    {
        while(start < end)
        {
            swap(arr, start++, end--);
        }
    }

    private static void swap(int[] arr, int i, int j)
    {
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }
    
    private static void print(int[] arr)
    {
        for(int i : arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
```

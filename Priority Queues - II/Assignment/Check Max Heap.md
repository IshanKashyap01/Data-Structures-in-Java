# Check Max Heap

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{

    public static boolean checkMaxHeap(int arr[]) 
    {
        int n = arr.length;
        for(int i = 0; i < n - n / 2; i++)
        {
            if(!check(arr, i, n))
            {
                return false;
            }
        }
        return true;
    }

    private static boolean check(int[] arr, int parent, int n)
    {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        if(left < n && arr[left] > arr[parent])
        {
            return false;
        }
        if(right < n && arr[right] > arr[parent])
        {
            return false;
        }
        return true;
    }
}
```

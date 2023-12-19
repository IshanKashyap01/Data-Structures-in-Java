# Merge Sort - Problem Statement

```Java
public class Solution 
{
    public static void mergeSort(int[] arr, int left, int right)
    {
        if(left < right)
        {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }        
    }

    private static void merge(int[] arr, int left, int mid, int right)
    {
        int[] first = getSubArray(arr, left, mid);
        int[] second = getSubArray(arr, mid + 1, right);
        
        int i = 0, j = 0, k = left;
        while(i < first.length && j < second.length)
        {
            arr[k++] = first[i] < second[j] ? first[i++] : second[j++];
        }
        while(i < first.length)
        {
            arr[k++] = first[i++];
        }
        while(j < second.length)
        {
            arr[k++] = second[j++];
        }
    }

    private static int[] getSubArray(int[] arr, int start, int end)
    {
        int[] sub = new int[end - start + 1];
        for(int i = 0; i < sub.length; i++)
        {
            sub[i] = arr[i + start];
        }
        return sub;
    }
}
```

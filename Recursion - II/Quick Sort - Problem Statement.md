# Quick Sort - Problem Statement

```Java
public class Solution 
{    
    public static void quickSort(int[] arr,int start, int end) 
    {
        if(start < end)
        {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end)
    {
        int temp = start + (int) (Math.random() * (end - start));
        int pivot = start;
        for(int i = start; i <= end; i++)    
        {
            pivot += arr[i] < arr[temp] ? 1 : 0;
        }
        swap(arr, temp, pivot);
        
        int i = start, j = end;
        while(i < pivot && j > pivot)
        {
            if(arr[i] < arr[pivot])
            {
                i++;
            }
            else if(arr[j] >= arr[pivot])
            {
                j--;
            }
            else
            {
                swap(arr, i++, j--);
            }
        }
        return pivot;
    }

    private static void swap(int[] arr, int i, int j)
    {
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }
}
```

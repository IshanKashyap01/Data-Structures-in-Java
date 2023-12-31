# Array Intersection

```Java
/*
 * Time complexity    : O(nlogn)
 */
public class Solution 
{
    public static void intersection(int[] arr1, int[] arr2) 
    {
        // mergeSort(arr1);
        // mergeSort(arr2);
        quickSort(arr1, 0, arr1.length - 1);
        quickSort(arr2, 0, arr2.length - 1);
        
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length)
        {
            if(arr1[i] == arr2[j]) 
            {
                System.out.print(arr1[i++] + " ");
                j++;
            }
            else if(arr1[i] < arr2[j])
            {
                i++;
            }
            else
            {
                j++;
            }
        }
    }

    private static void quickSort(int[] arr, int start, int end)
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
        while(start < pivot && end > pivot)
        {
            if(arr[start] < arr[pivot])
            {
                start++;
            }
            else if(arr[end] >= arr[pivot])
            {
                end--;
            }
            else
            {
                swap(arr, start++, end--);
            }
        }
        return pivot;
    }

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // private static void mergeSort(int[] input)
    // {
    //     if(input.length > 1)
    //     {
    //         int[] first = new int[input.length / 2];
    //         int[] second = new int[input.length - first.length];
        
    //         int i;
    //         for(i = 0; i < first.length; i++)
    //         {
    //             first[i] = input[i];
    //         }
    //         for(int j = 0; j < second.length; j++)
    //         {
    //             second[j] = input[i++];
    //         }
    //         mergeSort(first);
    //         mergeSort(second);
    //         merge(first, second, input);
    //     }
    // }

    // private static void merge(int[] left, int[] right, int[] arr)
    // {
    //     int i = 0, j = 0, k = 0;
    //     while(i < left.length && j < right.length)
    //     {
    //         arr[k++] = left[i] < right[j] ? left[i++] : right[j++];
    //     }
    //     while(i < left.length || j < right.length)
    //     {
    //         arr[k++] = i < left.length ? left[i++] : right[j++];
    //     }
    // }
}
```

# Inplace Heap sort

```Java
/*
 * Time complexity  : O(nlogn)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static void inplaceHeapSort(int arr[])
    {
        if(arr.length > 1)
        {
            constructHeap(arr);
            removeFromHeap(arr);
        }
    }

    private static void constructHeap(int[] arr)
    {
        // construct a max heap by sifting down non-leaf nodes
        int n = arr.length;
        int end = n - n / 2;
        for(int i = end; i >= 0; i--)
        {
            siftDown(arr, i, n);
        }
    }

    private static void removeFromHeap(int[] heap)
    {
        // remove each element but don't delete it from the array
        for(int i = heap.length - 1; i >= 0; i--)
        {
            swap(heap, 0, i);
            siftDown(heap, 0, i);
        }
    }

    private static void siftDown(int[] heap, int start, int end)
    {
        int higher = start, parent, left, right;
        do
        {
            parent = higher;
            left = 2 * parent + 1;
            right = 2 * parent + 2;
            if(left < end && heap[left] < heap[higher])
            {
                higher = left;
            }
            if(right < end && heap[right] < heap[higher])
            {
                higher = right;
            }
            swap(heap, parent, higher);
        }while(parent != higher);
    }

    private static void swap(int[] arr, int i, int j)
    {
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }
}
```

# Quick Sort

## Problem Statement

Given the `start` and the `end` positions of the array `input`. Your task is to
sort the elements between `start` and `end` using quick sort.

**Note**: Make changes in the input array itself.

## Detailed Explanation

### Input format

Integer N i.e. Array size

Array elements (separated by space)

### Output format

Array elements in increasing order (separated by space)

### Constraints

$1 <= N <= 10^3$

$0 <= input[i] <= 10^9$

```ltf
Sample Input 1:
6 
2 6 8 5 4 3
Sample Output 1:
2 3 4 5 6 8
Sample Input 2:
5
1 2 3 5 7
Sample Output 2:
1 2 3 5 7 
```

## Solution

```java
public class Solution 
{
    public static void quickSort(int[] input,int start, int end) 
    {
        // base case
        if(start >= end)
        {
            return;
        }
        // pick a pivot and move it to its correct position
        int pivot = placePivot(input, start, end);
        // partition the array around the pivot
        partition(input, start, end, pivot);
        // assume the function can sort the sub-arrays
        quickSort(input, start, pivot - 1);
        quickSort(input, pivot + 1, end);
    }

    private static int placePivot(int[] input, int start, int end)
    {
        int index = (int) (Math.random() * (end - start + 1)) + start;
        int pivot = start;
        for(int i = start; i <= end; i++)
        {
            if(input[i] < input[index])
            {
                pivot++;
            }
        }
        swap(input, index, pivot);
        return pivot;
    }

    private static void partition(int[] input, int start, int end, int pivot)
    {
        // Rearrange the array around the pivot such that all elements to its left are
        // smaller while those to its right are larger
        int i = start, j = end, pivotValue = input[pivot];
        while(i < pivot && j > pivot)
        {
            if(input[i] >= pivotValue && input[j] < pivotValue)
            {
                swap(input, i, j);
            }
            else
            {
                if(input[i] < pivotValue)
                {
                    i++;
                }
                if(input[j] >= pivotValue)
                {
                    j--;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

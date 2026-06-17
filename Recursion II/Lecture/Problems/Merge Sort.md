# Merge Sort

## Problem Statement

You are given the starting `l` and the ending `r` positions of the array `ARR`.

You must sort the elements between `l` and `r`.

**Note**: Change in the input array itself. So no need to return or print
anything.

## Detailed Explanation

### Input format

The first line contains an integer `N` representing the size of the array/list.

The second line contains `N` single space-separated integers representing the elements in the array/list.

### Output format

You don't need to return anything. In the output, you will see the array after you do the modification.

### Constraints

$1 <= N <= 10^3$

$0 <= ARR[i] <= 10^9$

```ltf
Sample Input 1:
7
2 13 4 1 3 6 28
Sample Output 1:
1 2 3 4 6 13 28
Sample Input 2:
5
9 3 6 2 0
Sample Output 2:
0 2 3 6 9
```

## Solution

```java
public class Solution 
{
    public static void mergeSort(int[] arr, int start, int end)
    {
        // base case
        if(start >= end)
        {
            return;
        }
        // divide the array into two halves
        int mid = start + (end - start) / 2;
        int[] left = copySubsetOfArray(arr, start, mid);
        int[] right = copySubsetOfArray(arr, mid + 1, end);
        // assume the function can sort both halves
        mergeSort(left, 0, left.length - 1);
        mergeSort(right, 0, right.length - 1);
        // merge the two back into the original array
        merge(arr, left, right);
    }

    private static int[] copySubsetOfArray(int[] arr, int start, int end)
    {
        int[] copy = new int[end - start + 1];
        for(int i = 0, j = start; i < copy.length; i++, j++)
        {
            copy[i] = arr[j];
        }
        return copy;
    }

    private static void merge(int[] arr, int[] left, int[] right)
    {
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length)
        {
            arr[k++] = left[i] < right[j] ? left[i++] : right[j++];
        }
        while(i < left.length)
        {
            arr[k++] = left[i++];
        }
        while(j < right.length)
        {
            arr[k++] = right[j++];
        }
    }
}
```

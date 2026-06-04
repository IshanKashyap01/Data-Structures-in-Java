# Selection Sort

## Problem Statement

Sort the given unsorted array `arr` of size `N` in non-decreasing order using
the selection sort algorithm.

**Note**: Change in the input array/list itself.

## Detailed Explanation

### Input format

First line contains an integer `N` representing the size of the array/list.

Second line contains `N` single space separated integers representing the
elements in the array/list.

### Output format

The output contains the integers of the sorted array, separated by a single
space.

**Note**: You don’t need to print anything. Just implement the given function.

### Constraints

$1 <= N <= 10^3$

$0 <= arr[i] <= 10^5$

Time Limit: $1 sec$

```ltf
Sample Input 1:
6
2 13 4 1 3 6 
Sample Output 1:
1 2 3 4 6 13 
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
    public static void selectionSort(int[] arr) 
    {
        //Your code goes here
        int minIndex;
        for(int i = 0; i < arr.length - 1; i++)
        {
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
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

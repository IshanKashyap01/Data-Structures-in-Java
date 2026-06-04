# Bubble Sort

## Problem Statement

You are given an integer array `arr` of size `N`.

You must sort this array using 'Bubble Sort'.

**Note**: Change in the input array itself. You don't need to return or print
the elements.

## Detailed Explanation

### Input format

The first line contains an integer `N` representing the size of the array.

The second line contains `N` single space-separated integers representing the
elements of the array.

### Output format

The output contains the array elements after the sorting.

### Constraints

$1 <= N <= 10^3$

$0 <= arr[i] <= 10^9$

Time Limit: $1 sec$

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
    public static void bubbleSort(int[] arr, int n) 
    {
        //Your code goes here
        for(int i = 0; i < n - 1; i++)
        {
            for(int j = 0; j < n - 1 - i; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    swap(arr, j, j + 1);
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

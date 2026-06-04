# Insertion Sort

## Problem Statement

You are given an integer array `arr` of size `N`.

**Note**: Change in the input array itself. You don't need to return or print
the elements.

## Detailed Explanation

### Input format

The first line contains an integer `N` representing the size of the array.

The second line contains `N` single space-separated integers representing the
elements of the array.

### Output Format

Print the array elements in sorted order, separated by a single space.

### Constraints

$0 <= N <= 10^3$

$0 <= arr[i] <= 10^5$

Time Limit: $1 sec$

```ltf
Sample Input 1:
5
9 3 6 2 0
Sample Output 1:
0 2 3 6 9
Sample Input 2:
4
4 3 2 1
Sample Output 2:
1 2 3 4 
```

## Solution

```java
public class Solution 
{
    public static void insertionSort(int[] arr, int size) 
    {
        //Your code goes here
        int j;
        for(int i = 1; i < size; i++)
        {
            j = i;
            while(j > 0 && arr[j] < arr[j - 1])
            {
                swap(arr, j, j - 1);
                j--;
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

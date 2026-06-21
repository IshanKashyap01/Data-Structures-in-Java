# Array Intersection

## Problem Statement

You have been given two integer arrays/list(ARR1 and ARR2) of size N and M,
respectively. You need to print their intersection. An intersection for this
problem can be defined when both the arrays/lists contain a particular value or
to put it in other words, when there is a common value that exists in both the
arrays/lists.

**Note**: Input arrays/lists can contain duplicate elements.

The intersection elements printed would be in ascending order.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

The first line of each test case or query contains an integer `N` representing
the size of the first array/list.

The second line contains `N` single space separated integers representing the
elements of the first the array/list.

The third line contains an integer `M` representing the size of the second
array/list.

The fourth line contains `M` single space separated integers representing the
elements of the second array/list.

### Output format

For each test case, print the intersection elements in a row, separated by a
single space.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= N <= 10^4$

$0 <= M <= 10^4$

Time Limit: $1 sec$

```ltf
Sample Input 1:
2
6
2 6 8 5 4 3
4
2 3 4 7 
2
10 10
1
10
Sample Output 1:
2 3 4
10
Sample Input 2:
1
4
2 6 1 2
5
1 2 3 4 2
Sample Output 2:
1 2 2

Explanation for Sample Output 2:
Since, both input arrays have two '2's, the intersection of the arrays also
have two '2's. The first '2' of first array matches with the first '2' of the
second array. Similarly, the second '2' of the first array matches with the
second '2' if the second array.
```

## Solution

```java
public class Solution 
{
    public static void intersection(int[] arr1, int[] arr2) 
    {
        //Your code goes here
        sort(arr1);
        sort(arr2);
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length)
        {
            if(arr1[i] == arr2[j])
            {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
            else if(arr1[i] > arr2[j])
            {
                j++;
            }
            else
            {
                i++;
            }
        }
    }

    private static void sort(int[] arr)
    {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end)
    {
        // base case
        if(start >= end)
        {
            return;
        }
        // pick a random index as pivot
        int pivot = (int) (Math.random() * (end - start + 1)) + start;
        // move it to its correct position
        pivot = movePivot(arr, start, end, pivot);
        // partition the array around the pivot
        partition(arr, start, end, pivot);
        // assume the function can do the same for each element in both sub-arrays
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int movePivot(int[] arr, int start, int end, int index)
    {
        int pivot = start;
        for(int i = start; i <= end; i++)
        {
            pivot += arr[i] < arr[index] ? 1 : 0;
        }
        swap(arr, pivot, index);
        return pivot;
    }

    private static void partition(int[] arr, int start, int end, int pivot)
    {
        int i = start, j = end, pivotValue = arr[pivot];
        while(i < pivot && j > pivot)
        {
            // if both pointers point to an incorrect value, swap and move
            if(arr[i] >= pivotValue && arr[j] < pivotValue)
            {
                swap(arr, i++, j--);
            }
            // otherwise, move whichever points to a correct value
            else
            {
                if(arr[i] < pivotValue)
                {
                    i++;
                }
                if(arr[j] >= pivotValue)
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

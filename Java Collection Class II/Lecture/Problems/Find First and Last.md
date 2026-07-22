# Find First and Last Position of Element in Sorted Array

## Problem Statement

You are given a non-decreasing array `arr` consisting of `n` integers and an
integer `x`. You need to find the first and last position of `x` in the array.

**Note**:

1. The array follows 0-based indexing, so you need to return 0-based indices.

2. If `x` is not present in the array, return {-1 -1}.

3. If `x` is only present once in the array, the first and last position of its
occurrence will be the same.

## Detailed Explanation

### Input Format

The first line contains the integer `n`, denoting the size of the sorted array.

The second line contains `n` space-separated integers denoting the array
elements.

The third line contains the value `x`, whose first and last position of
occurrence you need to find.

### Output Format

The only line of output should contain two space-separated integers, where the
first and second integer will be the first and the last position of occurrence
of `x`, respectively, in the array.

### Constraints

$1 <= n <= 10^4$

$-10^9 <= arr[i] <= 10^9$

$-10^9 <= x <= 10^9$

Time Limit: $1sec$

Expected Time Complexity: $O(n\log{n})$

```ltf
Sample Input 1:
5
-10 -5 -5 -5 2
-5
Sample Output 1:
1 3

Explanation for Sample Input 1:
The given array’s 0-based indexing is as follows:
-10    -5    -5    -5     2
 ↓      ↓     ↓     ↓     ↓
 0      1     2     3     4

So, the first occurrence of -5 is at index 1, and the last occurrence of -5 is
at index 3.

Sample Input 2:
4
1 2 3 4
-1
Sample Output 2:
-1 -1

Explanation for Sample Input 2:
The given array 'arr' is:[1, 2, 3, 4] and 'x' = -1.
In this case 'x' is not present in the array.
Hence, we return {-1,-1}. 
```

## Solution

```java
public class Solution 
{
    /*
    * Time complexity  : O(logn)
    * Space complexity : O(logn)
    */
    public static int[] searchRange(int []arr, int x) 
    {
        // Write your code here.
        int[] range = new int[2];
        range[0] = binarySearch(arr, x, true, 0, arr.length - 1);
        range[1] = binarySearch(arr, x, false, 0, arr.length - 1);
        return range;
    }
    /*
    * Time complexity  : O(logn)
    * Space complexity : O(logn)
    */
    private static int binarySearch(int[] arr, int x, boolean lookLower, int start, int end)
    {
        // base case: the sub-array is empty
        if(start > end)
        {
            return -1;
        }
        int mid = (end - start) / 2 + start;
        if(x < arr[mid])
        {
            return binarySearch(arr, x, lookLower, start, mid - 1);
        }
        if(x > arr[mid])
        {
            return binarySearch(arr, x, lookLower, mid + 1, end);
        }
        // assume recursion will return the correct bound, if it exists
        int index;
        if(lookLower)
        {
            index = binarySearch(arr, x, lookLower, start, mid - 1);
        }
        else
        {
            index = binarySearch(arr, x, lookLower, mid + 1, end);
        }
        return index != -1 ? index : mid;
    }
}
```

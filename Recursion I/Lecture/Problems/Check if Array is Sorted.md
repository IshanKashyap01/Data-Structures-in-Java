# Check if Array is Sorted

## Problem Statement

You are given an array `A` of length `N` , determine whether the array is
sorted in non-decreasing order or not.

## Detailed Explanation

### Input Format

The first line of the input contains an integer `N`.

The next line will contain `N` space-separated integers.

### Output Format

The output contains a string `True` or `False`.

**Note**: You don’t need to print anything. Just implement the given function.

### Constraints

$1 <= N  <= 10^5$

$1 <= A[i] <= 10^9$

```ltf
Sample Input 1:
5
10 20 30 20 40
Sample Output 1:
False
Sample Input 2:
1
1100
Sample Output 2:
True
```

## Solution

```java
public class Solution
{
    public static boolean arraySortedOrNot(int []arr, int n) 
    {
        // Write your code here.
        return helper(arr, 0);
    }

    private static boolean helper(int[] arr, int index)
    {
        if(index == arr.length - 1)
        {
            return true;
        }
        return arr[index] <= arr[index + 1] && helper(arr, index + 1);
    }
}
```

# Find Kth Smallest

## Problem Statement

You have been given an array/list and a number k. You have to find the kth
smallest number.

## Detailed Explanation

### Input format

The first line contains an Integer `N`, which denotes the size of the
array/list.

The second line contains `N` single space-separated integers representing the
elements in the array/list.

The third line contains the value of k.

### Output Format

Return the kth smallest number.

### Constraints

$1 <= N <= 10^4$

$1 <= nums[i] <= 10^9$

Time Limit: $1 sec$

```ltf
Sample Input 1:
5
3 2 5 11 1
2
Sample Output 1:
2
Sample Input 2:
7
17 5 14 16 11 18 10
5
Sample Output 2:
16
```

## Solution

```java
import java.util.Arrays;

public class Solution 
{
    public static int kthSmallest(int[] arr, int n, int k)
    {
        //Your code goes here
        Arrays.sort(arr);
        return arr[k - 1];
    }
}
```

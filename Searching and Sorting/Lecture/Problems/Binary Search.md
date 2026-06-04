# Binary Search

## Problem Statement

You are given an integer array `A` of size `N`, sorted in non-decreasing order.
You are also given an integer `target`. Your task is to write a function to
search for `target` in the array `A`. If it exists, return its index in 0-based
indexing. If `target` is not present in the array `A`, return -1.

## Detailed Explanation

### Input format

The first line contains an Integer `N`, which denotes the size of the
array/list.

The second line contains `N` single space-separated integers representing the
elements in the array/list.

The third line contains the value of `target` to be searched for in the
array/list.

### Output Format

Return the index at which `target` is present for each test case, -1 otherwise.

### Constraints

$1 <= N <= 10^5$

$1 <= A[i] <= 10^9$

$1 <= target <= 10^9$

Time Limit: $1 sec$

```ltf
Sample Input 1:
7
1 3 7 9 11 12 45
3
Sample Output 1:
1

Explanation of sample output 1:
nums = [1, 3, 7, 9, 11, 12, 45],
The index of element '3' is 1.
Hence, the answer is '1'.

Sample Input 2:
7
1 2 3 4 5 6 7
9
Sample Output 2:
-1

Explanation of sample output 2:
nums = [1, 2, 3, 4, 5, 6, 7],
Element '9' doesn't exist.
Hence, the answer is '-1'.
```

## Solution

```java
public class Solution {
    public static int search(int []nums, int target) 
    {
        int start = 0, end = nums.length - 1;
        int mid;
        while(start <= end)
        {
            mid = start + (end - start) / 2;
            if(target < nums[mid])
            {
                end = mid - 1;
            }
            else if(target == nums[mid])
            {
                return mid;
            }
            else
            {
                start = mid + 1;
            }
        }
        return -1;
    }
}
```

# Find Closest Index

## Problem Statement

You have been given a sorted(in ascending order) integer array/list(`nums`) of
size N and an element `target`. Your task is to return the index of closest
element to the `target` in the array `nums`.

## Detailed Explanation

### Input format

The first line contains an Integer `N`, which denotes the size of the
array/list.

The second line contains `N` single space-separated integers representing the
elements in the array/list.

The third line contains the value of `target` to be searched for in the
array/list.

### Output Format

Return the index closest or at which `target` is present for each test case.

### Constraints

$1 <= N <= 10^4$

$1 <= nums[i] <= 10^9$

$1 <= target <= 10^9$

Time Limit: $1 sec$

```ltf
Sample Input 1:
5
1 2 3 4 5
4
Sample Output 1:
3
Explanation of sample output 1:
For nums = [1, 2, 3, 4, 5],
The element 4 is already present, so we will return the index of 4.
Hence, the answer is '3'.
Sample Input 2:
7
6 7 11 13 21 44 46
22
Sample Output 2:
4
Explanation of sample output 2:
For nums = [6, 7, 11, 13, 21, 44, 46],
The element 21 is closest to the target element so we will return the index of element 21.
Hence, the answer is '4'
```

## Solution

```java
public class Solution 
{
    public static int binarySearchClosest(int []nums, int left, int right, int target) 
    {
        //Your code goes here
        int mid = 0;
        while(left <= right)
        {
            mid = left + (right - left) / 2;
            if(target < nums[mid])
            {
                right = mid - 1;
            }
            else if(target == nums[mid])
            {
                return mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        return mid;
    }
}
```

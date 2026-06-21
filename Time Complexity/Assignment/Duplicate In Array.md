# Duplicate in Array

## Problem Statement

You have been given an integer array/list(ARR) of size N which contains numbers
from 0 to (N - 2). Each number is present at least once. That is, if N = 5, the
array/list constitutes values ranging from 0 to 3, and among these, there is a
single integer value that is present twice. You need to find and return that
duplicate number present in the array.

**Note**: Duplicate number is always present in the given array/list.

## Detailed Explanation

### Input format

The first line contains an Integer `t` which denotes the number of test cases
or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer `N` representing the
size of the array/list.

Second line contains `N` single space separated integers representing the
elements in the array/list.

### Output Format

For each test case, print the duplicate element in the array/list.

Output for every test case will be printed in a separate line.

### Constraints

$1 <= t <= 10^2$

$0 <= N <= 10^6$

Time Limit: $1 sec$

```ltf
Sample Input 1:
1
9
0 7 2 5 4 7 1 3 6
Sample Output 1:
7
Sample Input 2:
2
5
0 2 1 3 1
7
0 3 1 5 4 3 2
Sample Output 2:
1
3
```

## Solution

```java
public class Solution 
{
    public static int findDuplicate(int[] arr) 
    {
        // edge case
        if(arr.length == 2)
        {
            return arr[0];
        }
        int max = arr.length - 2;
        int sum = max * (max + 1) / 2;
        int actual = 0;
        for(int num : arr)
        {
            actual += num;
        }
        return actual - sum;
    }
}
```

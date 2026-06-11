# Last Index of a Number in an Array

## Problem Statement

Given an array of length N and an integer x, you need to find and return the
last index of integer x present in the array. Return -1 if it is not present in
the array.

Last index means - if x is present multiple times in the array, return the
index at which x comes last in the array.

You should start traversing your array from 0, not from (N - 1).

Do this recursively. Indexing in the array starts from 0.

## Detailed Explanation

### Input Format

An Integer N i.e. size of array

N integers which are elements of the array, separated by spaces

Integer x

### Output Format

last index or -1

### Constraints

$1 <= N <= 10^3$

```ltf
Sample Input:
4
9 8 10 8
8
Sample Output:
3
```

## Solution

```java
public class Solution 
{
    public static int lastIndex(int input[], int x) 
    {
        return helper(input, input.length - 1, x);
    }

    private static int helper(int[] input, int index, int x)
    {
        if(index == -1)
        {
            return -1;
        }
        return input[index] == x ? index : helper(input, index - 1, x);
    }
}
```

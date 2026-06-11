# First Index of a Number in an Array

## Problem Statement

Given an array of length N and an integer x, you need to find and return the
first index of integer x present in the array. Return -1 if it is not present
in the array.

First index means, the index of first occurrence of x in the input array.

Do this recursively. Indexing in the array starts from 0.

## Detailed Explanation

### Input Format

An Integer N i.e. size of array

N integers which are elements of the array, separated by spaces

Integer x

### Output Format

first index or -1

### Constraints

$1 <= N <= 10^3$

```ltf
Sample Input
4
9 8 10 8
8
Sample Output
1
```

## Solution

```java
public class Solution 
{
    public static int firstIndex(int input[], int x) 
    {
        return helper(input, 0, x);
    }

    private static int helper(int[] input, int index, int x)
    {
        if(index == input.length)
        {
            return -1;
        }
        return input[index] == x ? index : helper(input, index + 1, x);
    }
}
```

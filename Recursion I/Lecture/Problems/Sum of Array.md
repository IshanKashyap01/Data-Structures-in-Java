# Sum of Array

## Problem Statement

Given an array of length N, you need to find and return the sum of all elements
of the array.

Do this recursively.

## Detailed Explanation

### Input Format

An Integer N i.e. size of array

N integers which are elements of the array, separated by spaces

### Output Format

Sum of the array

### Constraints

$1 <= N <= 10^3$

```ltf
Sample Input 1:
3
9 8 9
Sample Output 1:
26
Sample Input 2:
3
4 2 1
Sample Output 2:
7  
```

## Solution

```java
public class Solution 
{
    public static int sum(int input[]) 
    {
        return helper(input, 0);
    }

    private static int helper(int[] input, int index)
    {
        if(index == input.length)
        {
            return 0;
        }
        return input[index] + helper(input, index + 1);
    }
}
```

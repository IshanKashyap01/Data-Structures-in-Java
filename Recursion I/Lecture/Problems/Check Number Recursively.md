# Check Number Recursively

## Problem Statement

Given an array of length N and an integer x, you need to find if x is present
in the array or not. Return true or false.

Do this recursively.

## Detailed Statement

### Input Format

An Integer N i.e. size of array

N integers which are elements of the array, separated by spaces

Integer x

### Output Format

`true` or `false`

### Constraints

$1 <= N <= 10^3$

```ltf
Sample Input 1:
3
9 8 10
8
Sample Output 1:
true
Sample Input 2:
3
9 8 10
2
Sample Output 2:
false
```

## Solution

```java
public class Solution 
{
    public static boolean checkNumber(int input[], int x) 
    {
        return helper(input, 0, x);
    }

    private static boolean helper(int[] input, int index, int x)
    {
        if(index == input.length)
        {
            return false;
        }
        return input[index] == x || helper(input, index + 1, x);
    }
}
```

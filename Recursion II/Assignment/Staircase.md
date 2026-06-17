# Staircase

## Problem Statement

A child is running up a staircase with N steps, and can hop either 1 step, 2
steps or 3 steps at a time. Implement a method to count how many possible ways
the child can run up to the stairs. You need to return number of possible ways
W.

## Detailed Explanation

### Input format

Integer N

### Output Format

Integer W

### Constraints

$1 <= N <= 30$

```ltf
Sample Input 1:
4
Sample Output 1:
7
Sample Input 2:
5
Sample Output 2:
13
```

## Solution

```java
public class Solution
{
    public static int staircase(int n)
    {
        // base case: if stairs are less than or equal to 3
        if(n < 1)
        {
            return 0;
        }
        if(n <= 2)
        {
            return n;
        }
        // "1, 1, 1", "1, 2", "2, 1", and "3"
        if(n == 3)
        {
            return n + 1;
        }
        // if we take a step (either 1, 2 or 3) now,
        // assume the function will deal the remaining stairs
        return staircase(n - 1) + staircase(n - 2) + staircase(n - 3);
    }
}
```

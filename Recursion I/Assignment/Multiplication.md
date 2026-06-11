# Multiplication (Recursive)

## Problem Statement

Given two integers M & N, calculate and return their multiplication using
recursion. You can only use subtraction and addition for your calculation. No
other operators are allowed.

## Detailed Explanation

### Input format

Integer M

Integer N

### Output format

M x N

### Constraints

$0 <= M <= 1000$

$0 <= N <= 1000$

```ltf
Sample Input 1:
3 
5
Sample Output 1:
15
Sample Input 2:
4 
0
Sample Output 2:
0
```

## Solution

```java
public class solution 
{
    public static int multiplyTwoIntegers(int m, int n)
    {
        // Base case
        if(n == 0)
        {
            return 0;
        }
        // Assume the function will return m * (n - 1);
        return m + multiplyTwoIntegers(m, n - 1);
    }
}
```

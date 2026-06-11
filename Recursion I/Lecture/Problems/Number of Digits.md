# Number of Digits

## Problem Statement

You are given a number `n`.

Return number of digits in `n`.

## Detailed Explanation

### Input format

The first line of input contains an integer `n`.

### Output Format

Return an integer as described in the problem statement.

**Note**: You don’t need to print anything, it has already been taken care of,
just complete the given function.

### Constraints

$1 <= n <= 10^9$

```ltf
Sample Input 1:
121
Sample Output 1:
3

Explanation of sample output 1:
There are 3 digits in 121 are 1,2 and 1.

Sample Input 2:
38
Sample Output 2:
2
```

## Solution

```java
public class Solution 
{
    public static int countDigits(int n)
    {
        // Write your code here.
        if(n == 0)
        {
            return 0;
        }
        return 1 + countDigits(n / 10);
    }
}
```

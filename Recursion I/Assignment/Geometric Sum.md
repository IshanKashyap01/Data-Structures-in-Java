# Geometric Sum

## Problem Statement

Given k, find the geometric sum i.e.

$$
1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k)
$$

**Note**: using recursion.

## Detailed Explanation

### Input format

Integer k

### Output format

Geometric sum (up to 5 decimal places)

### Constraints

$0 <= k <= 1000$

```ltf
Sample Input 1:
3
Sample Output 1:
1.87500
Sample Input 2:
4
Sample Output 2:
1.93750
Explanation for Sample Input 1:
1+ 1/(2^1) + 1/(2^2) + 1/(2^3) = 1.87500
```

## Solution

```java
public class Solution 
{
    public static double geometricSum(int k) 
    {
        // base case
        if(k == 0)
        {
            return 1;
        }
        // assume the function handles everything until k - 1
        return 1.0 / Math.pow(2, k) + geometricSum(k - 1);
    }
}
```

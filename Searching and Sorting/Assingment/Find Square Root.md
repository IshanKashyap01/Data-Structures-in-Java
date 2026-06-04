# Find Square Root

You are given a positive integer `N`. Your task is to find and return its
square root. If `N` is not a perfect square, then return the floor value of
sqrt(N).

## Detailed Explanation

### Input Format

The first line of input contains the Integer `N`.

### Output Format

Return a single line containing an integer denoting the square root of `N`.

### Constraints

$0 <= N <= 10 ^ 16$

Time Limit: $1 sec$

```ltf
Sample Input 1:
6
Sample Output 1:
2

Explanation of Sample Input 1:
The square root of the given number 6 lies between 2 and 3, so the floor value
is 2.

Sample Input 2:
100
Sample Output 2:
10

Explanation of Sample Output 2:
The square root of the given number 100 is 10.
```

## Solution

```java
public class Solution 
{
    public static int sqrtN(long n) 
    {
        long start = 1, end = n;
        long mid = 0;
        while(start <= end)
        {
            mid = start + (end - start) / 2;
            // must not use multiplication to prevent overflow
            if(mid == n / mid)
            {
                return (int) mid;
            }
            else if(n / mid > mid)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        // start - 1 = end = the second last value of mid
        return (int) end;
    }
}
```

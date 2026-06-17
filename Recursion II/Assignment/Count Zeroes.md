# Count Zeroes

## Problem Statement

Given an integer N, count and return the number of zeros that are present in
the given integer using recursion.

## Detailed Explanation

### Input Format

Integer N

### Output Format

Number of zeros in N

### Constraints

$0 <= N <= 10^9$

```ltf
Sample Input 1:
0
Sample Output 1:
1
Sample Input 2:
00010204
Sample Output 2:
2

Explanation for Sample Output 2:
Even though "00010204" has 5 zeros, the output would still be 2 because when
you convert it to an integer, it becomes 10204.

Sample Input 3:
708000
Sample Output 3:
4
```

## Solution

```java
public class solution 
{
    public static int countZerosRec(int input)
    {
        // base case
        if(input == 0)
        {
            return 1;
        }
        if(input < 10)
        {
            return 0;
        }
        // check the last digit and assume the function can handle the rest
        if(input % 10 == 0)
        {
            return 1 + countZerosRec(input / 10);
        }
        return countZerosRec(input / 10);
    }
}
```

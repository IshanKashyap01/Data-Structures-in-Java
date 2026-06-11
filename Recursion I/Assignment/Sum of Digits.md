# Sum of Digits (Recursive)

## Problem Statement

Write a recursive function that returns the sum of the digits of a given
integer.

## Detailed Explanation

### Input format

Integer N

### Output format

Sum of digits of N

### Constraints

$0 <= N <= 10^9$

```ltf
Sample Input 1:
12345
Sample Output 1:
15
Sample Input 2:
9
Sample Output 2:
9
```

## Solution

```java
public class solution 
{
    public static int sumOfDigits(int input)
    {
        // base case
        if(input == 0)
        {
            return 0;
        }
        // add the current digit and assume the function takes care of the rest
        return (input % 10) + sumOfDigits(input / 10);
    }
}
```

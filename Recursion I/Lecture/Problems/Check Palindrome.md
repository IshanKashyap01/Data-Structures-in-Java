# Check Palindrome (recursive)

## Problem Statement

Determine if a given string `S` is a palindrome using recursion. Return a
Boolean value of true if it is a palindrome and false if it is not.

Note: You are not required to print anything, just implement the function.

## Detailed Explanation

### Input Format

The first and only line of the input contains string S.

### Output format

Return a boolean value True or False.

### Constraints

$0 <= S <= 10^6$

```ltf
Sample Input 1:
abbba
Sample Output 1:
true
Explanation Of Sample Input 1 :
“abbba” is a palindrome
Sample Input 2:
abcd
Sample Output 2:
false
Explanation Of Sample Input 2 :
“abcd” is not a palindrome.
```

## Solution

```java
public class Solution 
{
    public static boolean isPalindrome(String str) 
    {
        // Write your code here.
        return helper(str, 0, str.length() - 1);
    }

    private static boolean helper(String str, int start, int end)
    {
        // base case: either start and end have met or crossed each other
        if(start >= end)
        {
            return true;
        }
        return str.charAt(start) == str.charAt(end) && helper(str, start + 1, end - 1);
    }
}
```

# Check AB

## Problem Statement

Suppose you have a string, S, made up of only `a`s and `b`s. Write a recursive
function that checks if the string was generated using the following rules:

1. The string begins with an `a`

2. Each `a` is followed by nothing or an `a` or `bb`

3. Each `bb` is followed by nothing or an `a`

If all the rules are followed by the given string, return true otherwise return
false.

## Detailed Explanation

### Input format

String S

### Output format

`true` or `false`

### Constraints

$1 <= |S| <= 1000$

```ltf
Sample Input 1:
abb
Sample Output 1:
true
Sample Input 2:
abababa
Sample Output 2:
false

Explanation for Sample Input 2
In the above example, a is not followed by either "a" or "bb", instead it's
followed by "b" which results in false to be returned.
```

## Solution

```java
public class Solution 
{
    public static boolean checkAB(String input) 
    {
        // Write your code here
        return helper(input, 0);
    }

    private static boolean helper(String input, int index)
    {
        int n = input.length();
        // base case
        if(index >= n)
        {
            return true;
        }
        char curr = input.charAt(index);
        // check if the string begins at 'a'
        if(curr != 'a')
        {
            return false;
        }
        // if it is followed by nothing
        if(index == n - 1)
        {
            return true;
        }
        // if it is followed by another 'a'
        if(input.charAt(index + 1) == 'a')
        {
            // assume the function can check from the next 'a'
            return helper(input, index + 1);
        }
        // if it is followed by 'bb'
        if(input.substring(index + 1, index + 3).equals("bb"))
        {
            // assume the function can check the string after 'bb'
            return helper(input, index + 3);
        }
        return false;
    }
}
```

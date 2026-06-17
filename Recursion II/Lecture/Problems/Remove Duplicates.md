# Remove Duplicates

## Problem Statement

Given a string S, remove consecutive duplicates from it recursively.

## Detailed Explanation

### Input Format

String S

### Output Format

Output string

### Constraints

$1 <= |S| <= 10^3$

where $|S|$ represents the length of string

```ltf
Sample Input 1:
aabccba
Sample Output 1:
abcba
Sample Input 2:
xxxyyyzwwzzz
Sample Output 2:
xyzwz
```

## Solution

```java
public class Solution 
{
    public static String removeConsecutiveDuplicates(String s) 
    {
        // Write your code here
        StringBuilder builder = new StringBuilder();
        helper(s, builder, 0);
        return builder.toString();
    }

    private static void helper(String input, StringBuilder builder, int index)
    {
        // base case
        if(index == input.length())
        {
            return;
        }
        // handle the current character
        if(index == 0)
        {
            builder.append(input.charAt(index));
        }
        else if(input.charAt(index) != builder.charAt(builder.length() - 1))
        {
            builder.append(input.charAt(index));
        }
        // let recursion handle the rest
        helper(input, builder, index + 1);
    }
}
```

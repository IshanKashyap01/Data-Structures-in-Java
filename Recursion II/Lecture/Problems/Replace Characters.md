# Replace Characters Recursively

## Problem Statement

Given an input string S and two characters c1 and c2, you need to replace every
occurrence of character c1 with character c2 in the given string.

Do this recursively.

## Detailed Explanation

### Input Format

Input String S

Characters c1 and c2 (separated by space)

### Output Format

Updated string

### Constraints

$1 <= S <= 10^6$

```ltf
Sample Input:
abacd
a x
Sample Output:
xbxcd
```

## Solution

```java
public class Solution 
{
    public static String replaceCharacter(String input, char c1, char c2) 
    {
        StringBuilder builder = new StringBuilder();
        helper(input, builder, 0, c1, c2);
        return builder.toString();
    }

    private static void helper(String input, StringBuilder builder, int index, char c1, char c2)
    {
        // base case
        if(index == input.length())
        {
            return;
        }
        // handle the current index
        builder.append(input.charAt(index) == c1 ? c2 : input.charAt(index));
        // Assume the function can handle the remaining indices
        helper(input, builder, index + 1, c1, c2);
    }
}
```

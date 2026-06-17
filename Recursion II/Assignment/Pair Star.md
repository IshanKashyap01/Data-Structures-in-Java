# Pair Star

## Problem Statement

Given a string S, compute recursively a new string where identical chars that
are adjacent in the original string are separated from each other by a `*`.

## Detailed Explanation

### Input format

String S

### Output format

Modified string

### Constraints

$0 <= |S| <= 1000$

```ltf
Sample Input 1:
hello
Sample Output 1:
hel*lo
Sample Input 2:
aaaa
Sample Output 2:
a*a*a*a
```

## Solution

```java
public class solution 
{
    public static String addStars(String s) 
    {
        // edge case
        if(s.isEmpty())
        {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        helper(s, builder, 0);
        return builder.toString();
    }

    private static void helper(String input, StringBuilder builder, int index)
    {
        // base case
        if(index == input.length() - 1)
        {
            builder.append(input.charAt(index));
            return;
        }
        // add the current character to builder
        builder.append(input.charAt(index));
        // add a star if the next character is the same as this one
        if(input.charAt(index + 1) == input.charAt(index))
        {
            builder.append('*');
        }
        // assume the function can add stars for the remaining indices
        helper(input, builder, index + 1);
    }
}
```

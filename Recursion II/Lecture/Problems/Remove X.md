# Remove X

## Problem Statement

Given a string, compute recursively a new string where all `x` chars have been
removed.

## Detailed Statement

### Input format

String S

### Output format

Modified String

### Constraints

$1 <= |S| <= 10^3$

where $|S|$ represents the length of string S.

```ltf
Sample Input 1:
xaxb
Sample Output 1:
ab
Sample Input 2:
abc
Sample Output 2:
abc
Sample Input 3:
xx
Sample Output 3:
```

## Solution

```java
public class solution 
{
    public static String removeX(String input)
    {
        // Write your code here
        StringBuilder builder = new StringBuilder();
        helper(input, builder, 0);
        return builder.toString();
    }

    private static void helper(String input, StringBuilder builder, int index)
    {
        // base case
        if(index == input.length())
        {
            return;
        }
        // handle the current index
        if(input.charAt(index) != 'x')
        {
            builder.append(input.charAt(index));
        }
        // assume the function will handle the remaining indices
        helper(input, builder, index + 1);
    }
}
```

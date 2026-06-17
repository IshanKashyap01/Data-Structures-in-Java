# String to Integer

## Problem Statement

Write a recursive function to convert a given string into the number it
represents. That is input will be a numeric string that contains only numbers,
you need to convert the string into corresponding integer and return the
answer.

## Detailed Explanation

### Input format

Numeric string S (string, Eg. "1234")

### Output format

Corresponding integer N (int, Eg. 1234)

### Constraints

$0 < |S| <= 9$

```ltf
Sample Input 1:
00001231
Sample Output 1:
1231
Sample Input 2:
12567
Sample Output 2:
12567
```

## Solution

### Convert last digit and add first n - 1 digits

```java
public class solution 
{
    public static int convertStringToInt(String input)
    {
        int n = input.length();
        // edge case
        if(n == 0)
        {
            return 0;
        }
        return helper(input, n - 1);
    }

    private static int helper(String input, int index)
    {
        // base case
        if(index == 0)
        {
            return input.charAt(0) - 48;
        }
        // assume recursion can handle the first n - 1 digits
        int num = helper(input, index - 1);
        // append the last digit to num and return
        return num * 10 + input.charAt(index) - 48;
    }
}
```

### Convert first digit and add last n - 1 digits

```java
public class solution 
{
    public static int convertStringToInt(String input)
    {
        int n = input.length();
        // edge case
        if(n == 0)
        {
            return 0;
        }
        return helper(input, 0);
    }

    private static int helper(String input, int index)
    {
        // base case
        if(index == input.length() - 1)
        {
            return input.charAt(index) - 48;
        }
        // assume recursion can handle the last n - 1 digits
        int num = helper(input, index + 1);
        // convert the current digit
        int rem = (input.charAt(index) - 48);
        // add the correct amount of zeroes
        rem *= (int) Math.pow(10, input.length() - index - 1);
        // add both to get the number
        return num + rem;
    }
}
```

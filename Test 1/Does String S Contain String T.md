# Does String S Contain String T

## Problem Statement

Given two string s and t, write a function to check if s contains all
characters of t (in the same order as they are in string t).

Return true or false.

Do it recursively.

E.g.: s = “abchjsgsuohhdhyrikkknddg” contains all characters of t=”coding” in
the same order. So function will return true.

## Detailed Explanation

### Input Format

String s
String t

### Output Format

true or false

```ltf
Sample Input 1:
abchjsgsuohhdhyrikkknddg
coding
Sample Output 1:
true
Sample Input 2:
abcde
aeb
Sample Output 2:
false
```

## Solution

```java
public class Solution 
{
    public static boolean checkSequence(String s, String t) 
    {
        return helper(s, t, 0, 0);
    }

    /*
    * Time complexity  : O(n)
    * Space complexity : O(n)
    */
    private static boolean helper(String s, String t, int i, int j)
    {
        // base case
        if(j == t.length())
        {
            return true;
        }
        if(i == s.length())
        {
            return false;
        }
        // see if the current index is a match, and assume the function
        // can check the remaining indices
        if(s.charAt(i) == t.charAt(j))
        {
            return helper(s, t, i + 1, j + 1);
        }
        return helper(s, t, i + 1, j);
    }
}
```

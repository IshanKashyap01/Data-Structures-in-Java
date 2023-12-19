# Check Palindrome (recursive)

```Java
public class Solution 
{
    public static boolean isPalindrome(String str) 
    {
        return helper(str, 0, str.length() - 1);
    }

    private static boolean helper(String str, int i, int j)
    {
        if(i >= j)
        {
            return true;
        }
        if(str.charAt(i) != str.charAt(j))
        {
            return false;
        }
        return helper(str, i + 1, j - 1);
    }
}
```

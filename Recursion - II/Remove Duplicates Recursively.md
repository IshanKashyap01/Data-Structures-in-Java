# Remove Duplicates Recursively

```Java
public class Solution 
{
    public static String removeConsecutiveDuplicates(String s) 
    {
        return s.charAt(0) + helper(s, 1);
    }

    private static String helper(String str, int index)
    {
        if(index >= str.length())
        {
            return "";
        }
        if(str.charAt(index) == str.charAt(index - 1))
        {
            return helper(str, index + 1);
        }
        return str.charAt(index) + helper(str, index + 1);
    }
}
```

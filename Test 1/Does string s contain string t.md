# Does string s contain string t

```Java
/*
 * Time complexity    : O(n)
 * Space complexity    : O(n)
 */
public class Solution 
{
    public static boolean checkSequence(String s, String t) 
    {
        if(t.isEmpty())
        {
            return true;
        }
        if(s.isEmpty())
        {
            return false;
        }
        if(s.charAt(0) == t.charAt(0))
        {
            return checkSequence(s.substring(1), t.substring(1));
        }
        return checkSequence(s.substring(1), t);
    }
}
```

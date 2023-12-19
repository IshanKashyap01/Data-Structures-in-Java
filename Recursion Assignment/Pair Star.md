# Pair Star

```Java
public class solution 
{
    // Return the updated string
    public static String addStars(String str) 
    {
        return str.charAt(0) + helper(str, 1);
    }

    private static String helper(String str, int index)
    {
        if(index == str.length())
        {
            return "";
        }
        if(str.charAt(index) == str.charAt(index - 1))
        {
            return "*" + str.charAt(index) + helper(str, index + 1);
        }
        return str.charAt(index) + helper(str, index + 1);
    }
}
```

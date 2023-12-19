# Check AB

```Java
public class Solution
 {
    public static boolean checkAB(String input) 
    {
        if(input.isEmpty())
        {
            return true;
        }
        if(input.charAt(0) != 'a')
        {
            return false;
        }
        if(input.length() >= 3 && input.substring(0, 3).equals("abb"))
        {
            return checkAB(input.substring(3));
        }
        return checkAB(input)
    }
}
```

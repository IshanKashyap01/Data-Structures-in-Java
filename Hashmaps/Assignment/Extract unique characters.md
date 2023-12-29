# Extract unique characters

```Java
import java.util.HashMap;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static String uniqueChar(String str)
    {
        HashMap<Character, Boolean> map = getCharacters(str);
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < str.length(); i++)
        {
            if(map.get(str.charAt(i)))
            {
                builder.append(str.charAt(i));
                map.put(str.charAt(i), false);
            }
        }
        return builder.toString();
    }

    private static HashMap<Character, Boolean> getCharacters(String str)
    {
        HashMap<Character, Boolean> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++)
        {
            map.put(str.charAt(i), true);
        }
        return map;
    }
}
```

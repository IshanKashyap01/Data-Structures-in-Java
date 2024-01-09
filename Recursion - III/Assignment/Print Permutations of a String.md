# Print Permutations of a String

```Java
import java.util.ArrayList;
/*
 * Time complexity  : O(2^n^3)
 * Space complexity : O(n)
 */
public class solution 
{
    public static void permutations(String input)
    {
        hepler(input, "");
    }

    private static void hepler(String input, String set)
    {
        if(input.isEmpty())
        {
            System.out.println(set);
        }
        else
        {
            for(int i = 0; i < input.length(); i++)
            {
                hepler(remove(input, i), set + input.charAt(i));
            }
        }
    }

    private static String remove(String str, int index)
    {
        return str.substring(0, index) + str.substring(index + 1);
    }
}
```

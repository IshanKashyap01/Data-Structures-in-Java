# Print Keypad - String

```Java
/*
 * Time complexity  : O(l*n)
 * Space complexity : O(n)
 */
public class solution 
{
    public static void printKeypad(int input)
    {
        helper(input, "");
    }

    private static void helper(int input, String combo)
    {
        if(input == 0)
        {
            System.out.println(combo);
        }
        else
        {
            String characters = getString(input % 10);
            for(int i = 0; i < characters.length(); i++)
            {
                helper(input / 10, characters.charAt(i) + combo);
            }
        }
    }

    private static String getString(int number)
    {
        switch(number)
        {
            case 2: return "abc";
            case 3: return "def";
            case 4: return "ghi";
            case 5: return "jkl";
            case 6: return "mno";
            case 7: return "pqrs";
            case 8: return "tuv";
            case 9: return "wxyz";
            default: return "";
        }
    }
}
```

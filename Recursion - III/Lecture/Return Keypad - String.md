# Return Keypad - String

```Java
/*
 * Time complexity  : O(l*n)
 * Space complexity : O(n)
 */
public class solution 
{
    public static String[] keypad(int n)
    {
        if(n == 0)
        {
            return new String[]{""};
        }
        // recursively get the small output
        String[] rest = keypad(n / 10);
        String characters = getString(n % 10);
        String[] ans = new String[characters.length() * rest.length];
        int k = 0;
        // for each character in the last number
        for(int i = 0; i < characters.length(); i++)
        {
            // add it to each string from the small output
            for(int j = 0; j < rest.length; j++)
            {
                // we don't need empty strings
                ans[k++] = rest[j] + characters.charAt(i);
            }
        }
        return ans;
    }

    private static String getString(int n)
    {
        switch(n)
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

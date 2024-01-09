# Return Permutations of a String

```Java
/*
 * Time complexity  : O(2^n^3)
 * Space complexity : O(n)
 */
public class solution 
{    
    public static String[] permutationOfString(String str)
    {
        if(str.isEmpty())
        {
            return new String[]{""};
        }
        // get all permutations without the current index
        String[] exclude = permutationOfString(str.substring(1));
        // now we have to stuff the current index at every position in the string
        String[] ans = new String[str.length() * exclude.length];
        // character to stuff
        char ch = str.charAt(0);
        // index to stuff at
        int index = 0;
        // for each string in exclude
        for(int i = 0; i < exclude.length; i++)
        {
            // stuff ch at each position in the string
            for(int j = 0; j <= exclude[i].length(); j++)
            {
                ans[index++] = stuff(exclude[i], ch, j);
            }
        }
        return ans;
    }

    private static String stuff(String str, char ch, int index)
    {
        return str.substring(0, index) + ch + str.substring(index);
    }
}
```

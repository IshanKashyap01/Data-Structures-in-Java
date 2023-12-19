# Remove X

```Java
public class solution 
{
    // Return the changed string
    public static String removeX(String input)
    {
        if(input.isEmpty())
        {
            return "";
        }
        return (input.charAt(0) == 'x' ? "" : input.charAt(0)) + removeX(input.substring(1));
    }
}
```

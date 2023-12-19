# String to Integer

```Java
public class solution 
{
    public static int convertStringToInt(String input)
    {
        int n = input.length();
        if(n == 0)
        {
            return 0;
        }
        if(n == 1)
        {
            // ASCII value of any number from 0 to 9 is the number plus 48
            return input.charAt(0) - 48;
        }
        return convertStringToInt(input.substring(0, n - 1)) * 10 + input.charAt(n - 1) - 48;
    }
}
```

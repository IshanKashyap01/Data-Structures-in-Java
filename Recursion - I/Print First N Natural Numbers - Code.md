# Print First N Natural Numbers - Code

```Java
public class Solution 
{
    public static void print(int n)
    {
        if(n == 0)
        {
            return;
        }
        print(n - 1);
        System.out.print(n + " ");
    }
}
```

# Count Zeros

```Java
public class solution 
{
    public static int countZerosRec(int input)
    {
        if(input > 0 && input < 10)
        {
            return 0;
        }
        if(input == 0)
        {
            return 1;
        }
        return (input % 10 == 0 ? 1 : 0) + countZerosRec(input / 10);
    }
}
```

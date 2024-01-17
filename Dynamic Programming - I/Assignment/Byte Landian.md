# Byte Landian

```Java
import java.util.HashMap;
/*
 * Time complexity  : O(logn)
 * Space complexity : O(logn)
 */
public class Solution 
{    
    public static long bytelandian(long n, HashMap<Long, Long> memo) 
    {
        // return brute(n);
        // return rdp(n, memo);
        return idp(n, memo);
    }

    private static long brute(long n)
    {
        if(n == 0 || n == 1)
        {
            return n;
        }
        long exchange = brute(n / 2) + brute(n / 3) + brute(n / 4);
        return Math.max(n, exchange);
    }

    private static long rdp(long n, HashMap<Long, Long> map)
    {
        // base case
        if(n == 0 || n == 1)
        {
            return n;
        }
        // put the values in map if they don't already exist
        map.put(n / 2, map.containsKey(n / 2) ? map.get(n / 2) : rdp(n / 2, map));
        map.put(n / 3, map.containsKey(n / 3) ? map.get(n / 3) : rdp(n / 3, map));
        map.put(n / 4, map.containsKey(n / 4) ? map.get(n / 4) : rdp(n / 4, map));
        // get the exchange value for the coin
        long exchange = map.get(n / 2) + map.get(n / 3) + map.get(n / 4);
        // return the maximum amount you can get
        return Math.max(n, exchange);
    }
}
```

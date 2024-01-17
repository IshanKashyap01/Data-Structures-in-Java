# Loot Houses

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static long maxMoneyLooted(int[] houses) 
    {
        // return brute(houses, 0);
        return idp(houses);
    }

    private static long brute(int[] houses, int i)
    {
        if(i >= houses.lenggitth)
        {
            return 0;
        }
        // if you choose the current house: curr + brute(i + 2)
        // if you don't: brute(i + 1)
        return Math.max(houses[i] + brute(houses, i + 2), brute(houses, i + 1));
    }

    private static long idp(int[] houses)
    {
        int n = houses.length;
        if(n == 0)
        {
            return 0;
        }
        if(n == 1)
        {
            return houses[0];
        }
        long[] loot = new long[n];
        loot[0] = houses[0];
        loot[1] = Math.max(houses[0], houses[1]);
        for(int i = 2; i < n; i++)
        {
            // max loot b/w including and excluding current house
            loot[i] = Math.max(houses[i] + loot[i - 2], loot[i - 1]);
        }
        return loot[n - 1];
    }
}
```

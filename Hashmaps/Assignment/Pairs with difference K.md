# Pairs with difference K

```Java
import java.util.HashMap;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int getPairsWithDifferenceK(int arr[], int k) 
    {
        HashMap<Integer, Integer> map = getFrequencyMap(arr);
        int pairs = 0;
        for(int num : map.keySet())
        {
            if(map.containsKey(num + k))
            {
                if(num != num + k)
                {
                    pairs += map.get(num) * map.get(num + k);
                }
                else
                {
                    pairs += map.get(num) * (map.get(num) - 1) / 2;
                }
            }
        }
        return pairs;
    }

    private static HashMap<Integer, Integer> getFrequencyMap(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int key : arr)
        {
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        }
        return map;
    }
}
```

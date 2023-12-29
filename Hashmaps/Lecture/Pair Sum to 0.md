# Pair Sum to 0

```Java
import java.util.*;
public class Solution 
{
    public static int PairSum(int[] arr, int n) 
    {
        HashMap<Integer, Integer> map = getFrequencyMap(arr);
        int k = 0, count = 0;
        for(int i : arr)
        {
            if(map.containsKey(k - i))
            {
                if(i == k - i)
                {
                    count += map.get(i) * (map.get(i) - 1) / 2;
                }
                else
                {
                    count += map.get(i) * map.get(k - i);
                }
                map.remove(i);
                map.remove(k - i);
            }
        }
        return count;
    }

    private static HashMap<Integer, Integer> getFrequencyMap(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
        {
            map.put(i,  map.containsKey(i) ? map.get(i) + 1 : 1);
        }
        return map;
    }
}
```

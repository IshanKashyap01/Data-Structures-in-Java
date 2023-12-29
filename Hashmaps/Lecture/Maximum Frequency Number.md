# Maximum Frequency Number

```Java
import java.util.HashMap;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int maxFrequencyNumber(int[] arr)
    {
        HashMap<Integer, Integer> map = getFrequencyMap(arr);
        int max = 0, num = Integer.MIN_VALUE;
        for(int i : arr)
        {
            if(map.get(i) > max)
            {
                max = map.get(i);
                num = i;
            }
        }
        return num;
    }

    private static HashMap<Integer, Integer> getFrequencyMap(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
        {
            map.put(i, map.containsKey(i) ? 1 + map.get(i) : 1);
        }
        return map;
    }
}
```

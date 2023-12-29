# Print Intersection

```Java
import java.util.HashMap;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void printIntersection(int[] arr1,int[] arr2)
    {
        HashMap<Integer, Integer> map1, map2;
        map1 = getFrequencyMap(arr1);
        map2 = getFrequencyMap(arr2);
        for(int key : arr2)
        {
            if(map1.containsKey(key) && map2.containsKey(key))
            {
                System.out.println(key);
                updateMap(map1, key);
                updateMap(map2, key);
            }
        }
    }

    private static HashMap<Integer, Integer> getFrequencyMap(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
        {
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
        }
        return map;
    }

    private static void updateMap(HashMap<Integer, Integer> map, int key)
    {
        map.put(key, map.get(key) - 1);
        if(map.get(key) == 0)
        {
            map.remove(key);
        }
    }
}
```

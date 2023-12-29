# Longest Consecutive Sequence

```Java
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) 
    {
        if(arr == null || arr.length == 0)
        {
            return new ArrayList<>();
        }
        // numbers and whether they're used in a pair or not
        HashMap<Integer, Boolean> numbers = getMap(arr);
        // all consecutive sequences mapped to their starting number
        HashMap<Integer, Pair> sequences = getSequences(numbers);
        // find the longest pair
        Pair max = new Pair(arr[0], 1);
        for(int i : arr)
        {
            // if the current number has a longer sequence, put it in max
            if(sequences.containsKey(i) && sequences.get(i).len > max.len)
            {
                max = sequences.get(i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(max.start);
        list.add(max.start + max.len - 1);
        return list;
    }

    private static HashMap<Integer, Boolean> getMap(int[] arr)
    {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i : arr)
        {
            map.put(i, true);
        }
        return map;
    }

    private static HashMap<Integer, Pair> getSequences(HashMap<Integer, Boolean> map)
    {
        HashMap<Integer, Pair> sequences = new HashMap<>();
        for(int key : map.keySet())
        {
            // If the number is not part of any existing sequence
            if(map.get(key))
            {
                // put it in the map
                Pair p = getLen(map, key);
                sequences.put(p.start, p);
            }
        }
        return sequences;
    }

    private static Pair getLen(HashMap<Integer, Boolean> map, int start)
    {
        int num = start + 1, len = 1;
        map.put(start, false);
        while(map.containsKey(num) && map.get(num))
        {
            map.put(num++, false);
            len++;
        }
        num = start - 1;
        while(map.containsKey(num) && map.get(num))
        {
            map.put(num--, false);
            len++;
        }
        return new Pair((num == start - 1) ? start : (num + 1), len);
    }
}

class Pair
{
    int start;
    int len;

    public Pair(int start, int len)
    {
        this.start = start;
        this.len = len;
    }
}
```

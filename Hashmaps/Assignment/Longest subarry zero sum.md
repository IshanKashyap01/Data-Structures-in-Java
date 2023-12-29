# Longest subarry zero sum

```Java
import java.util.HashMap;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) 
    {
        // sum : index map
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, max = -1;
        for(int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            if(sum == 0)
            {
                max = i + 1;
            }
            else if(map.containsKey(sum))
            {
                max = Math.max(max, i - map.get(sum));
            }
            else
            {
                map.put(sum, i);
            }
        }
        return max;
    }
}
```

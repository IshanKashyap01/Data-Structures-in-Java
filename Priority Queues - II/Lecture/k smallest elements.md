# k smallest elements

```Java
import java.util.*;
/*
 * Time complexity  : O(nlogk)
 * Space complexity : O(k)
 */
public class Solution 
{
    public static ArrayList<Integer> kSmallest(int n, int[] arr, int k) 
    {
        // create a max priority queue and add first k elements to it
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k; i++)
        {
            queue.add(arr[i]);
        }
        // for each element from k replace the top element with smaller values
        for(int i = k; i < n; i++)
        {
            if(arr[i] < queue.peek())
            {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        return new ArrayList<>(queue);
    }
}
```

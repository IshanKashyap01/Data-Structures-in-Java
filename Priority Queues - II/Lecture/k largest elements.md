# k largest elements

```Java
import java.util.*;
/*
 * Time complexity  : O(nlogk)
 * Space complexity : O(k)
 */
public class Solution 
{
    public static ArrayList<Integer> kLargest(int arr[], int k) 
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // add k elements to the queue
        for(int i = 0; i < k; i++)
        {
            queue.add(arr[i]);
        }
        // for each element from k to the end
        for(int i = k; i < arr.length; i++)
        {
            // if the smallest in the queue is smaller than the current, replace it
            if(arr[i] > queue.peek())
            {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        return new ArrayList<>(queue);
    }
}
```

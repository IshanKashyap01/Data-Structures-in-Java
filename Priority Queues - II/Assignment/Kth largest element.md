# Kth largest element

```Java
import java.util.PriorityQueue;
/*
 * Time complexity  : O(nlogk)
 * Space complexity : O(k)
 */
public class Solution 
{
    public static int kthLargest(int n, int[] arr, int k) 
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < k; i++)
        {
            queue.add(arr[i]);
        }
        for(int i = k; i < arr.length; i++)
        {
            if(arr[i] > queue.peek())
            {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        return queue.poll();
    }
}
```

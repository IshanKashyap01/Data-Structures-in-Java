# Buy the ticket

```Java
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
/*
 * Time complexity  : O(nlogn)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int buyTicket(int arr[], int k) 
    {
        // queue to maintain the order of buyers
        Queue<Integer> queue = new LinkedList<>();
        // priority queue to maintain priorities
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < arr.length; i++)
        {
            queue.add(i);
            pq.add(arr[i]);
        }
        int time = 0;
        while(!queue.isEmpty())
        {
            // if the front's priority is not the highest
            if(arr[queue.peek()] != pq.peek())
            {
                // send it to the last of the queue
                queue.add(queue.poll());
            }
            else
            {
                time++;
                // if this is k
                if(queue.peek() == k)    
                {
                    break;
                }
                // remove it from both queues
                pq.poll();
                queue.poll();
            }
        }
        return time;
    }
}
```

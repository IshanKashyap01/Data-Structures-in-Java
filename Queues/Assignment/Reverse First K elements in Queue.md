# Reverse First K elements in Queue

```Java
import java.util.LinkedList;
import java.util.Queue;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static Queue<Integer> reverseKElements(Queue<Integer> queue, int k) 
    {
        helper(queue, k);
        for(int i = 0; i < queue.size() - k; i++)
        {
            queue.add(queue.poll());
        }
        return queue;
    }

    private static void helper(Queue<Integer> queue, int k)
    {
        if(!queue.isEmpty() && k != 0)
        {
            int temp = queue.poll();
            helper(queue, k - 1);
            queue.add(temp);
        }
    }
}
```

# Reverse Queue

```Java
import java.util.LinkedList;
import java.util.Queue;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void reverseQueue(Queue<Integer> queue) 
    {
        if(!queue.isEmpty())
        {
            int temp = queue.poll();
            reverseQueue(queue);
            queue.add(temp);
        }
    }
}
```

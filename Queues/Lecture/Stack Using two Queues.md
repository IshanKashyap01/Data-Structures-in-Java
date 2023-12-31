# Stack Using two Queues

```Java
import java.util.LinkedList;
import java.util.Queue;
/*
 * Time complexity  : O(1)*
 * Space complexity : O(1)
 */
public class Stack 
{
    //Define the data members
    private Queue<Integer> queue;
    private Queue<Integer> helper;

    public Stack() 
    {
        queue = new LinkedList<>();
        helper = new LinkedList<>();
    }

    /*----------------- Public Functions of Stack -----------------*/

    public int getSize() 
    {
        return queue.size();
    }

    public boolean isEmpty() 
    {
        return queue.isEmpty();
    }

    public void push(int element) 
    {
        queue.add(element);
    }

    // *Time complexity: O(n)
    public int pop() 
    {
        if(isEmpty())
        {
            return -1;
        }
        while(queue.size() != 1)
        {
            helper.add(queue.poll());
        }
        int temp = queue.poll();
        while(!helper.isEmpty())
        {
            queue.add(helper.poll());
        }
        return temp;
    }

    // *Time complexity: O(n)
    public int top() 
    {
         if(isEmpty())
        {
            return -1;
        }
        while(queue.size() != 1)
        {
            helper.add(queue.poll());
        }
        int temp = queue.poll();
        helper.add(temp);
        while(!helper.isEmpty())
        {
            queue.add(helper.poll());
        }
        return temp;
    }
}
```

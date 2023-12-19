# Dequeue

```Java
import java.util.LinkedList;

/*
 * Time complexity  : O(1)
 * Space complexity : O(1)
 */
public class Dequeue 
{
    private LinkedList<Integer> queue;
    private int capacity;

    public Dequeue(int capacity)
    {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public void insertFront(int item)
    {
        if(queue.size() == capacity)
        {
            System.out.println(-1);
        }
        else
        {
            queue.add(0, item);
        }
    }

    public void insertRear(int item)
    {
        if(queue.size() == capacity)
        {
            System.out.println(-1);
        }
        else
        {
            queue.add(item);
        }
    }

    public void deleteFront()
    {
        if(queue.isEmpty())
        {
            System.out.println(-1);
        }
        else
        {
            queue.remove(0);
        }
    }

    public void deleteRear()
    {
        if(queue.isEmpty())
        {
            System.out.println(-1);
        }
        else
        {
            queue.remove(queue.size() - 1);
        }
    }

    public int getFront()
    {
        if(queue.isEmpty())
        {
            return -1;
        }
        else
        {
            return queue.get(0);
        }
    }

    public int getRear()
    {
        if(queue.isEmpty())
        {
            return -1;
        }
        else
        {
            return queue.get(queue.size() - 1);
        }
    }
}
```

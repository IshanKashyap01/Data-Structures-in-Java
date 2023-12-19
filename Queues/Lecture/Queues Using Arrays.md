# Queues Using Arrays

```Java
/*
 * A simple implementation of circular queue using arrays with only integer inputs
 * Time and Space complexity for each operation: O(1)
*/
public class Queue
{
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Queue()
    {
        Queue(20);
    }
    public Queue(int capacity)
    {
        queue = new int[capacity];
        front = rear = -1;
        this.capacity = capacity;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void enqueue(int item)
    {
        if(size == capacity)
        {
            // throw queue full exception
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        front += front == -1 ? 1 : 0;
        size++;
    }

    public int front()
    {
        if(size == 0)
        {
            // throw queue empty exception
        }
        return front;
    }

    public int dequeue()
    {
        if(size == 0)
        {
            // throw queue empty exception
        }
        int temp = queue[front];
        front = (front + 1) % capacity;
        return temp;
        if(size == 0)
        {
            front = rear = -1;
        }
        size--;
    }
}
```

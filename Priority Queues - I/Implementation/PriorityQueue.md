# PriorityQueue

```Java
/*
 * Implementation of Priority Queue using heap
 * In case of equal priority, insertion order will be followed
*/
public class PriorityQueue<T>
{
    private Heap<T> heap;

    public PriorityQueue()
    {
        heap = new Heap<>();
    }

    public PriorityQueue(boolean isMaxPriority)
    {
        heap = new Heap<>(isMaxPriority);
    }

    public int size()
    {
        return heap.size();
    }

    public boolean isEmpty()
    {
        return heap.isEmpty();
    }

    public void add(T value, int priority)
    {
        heap.add(value, priority);
    }

    public T peek()
    {
        return heap.front();
    }

    public T poll()
    {
        T front = heap.front();
        heap.removeFront();
        return front;
    }
}
```

# Heap

```Java
import java.util.ArrayList;
/*
 * Time complexity: O(1)*
*/
public class Heap<T>
{
    private ArrayList<Element<T>> cbt;
    private int size;
    private boolean isMin;

    public Heap()
    {
        cbt = new ArrayList<>();
        isMin = true;
    }

    public Heap(boolean isMax)
    {
        cbt = new ArrayList<>();
        isMin = !isMax;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public boolean isMinimumHeap()
    {
        return isMin;
    }

    // Time complexity: O(logn)
    public void add(T item, int priority)
    {
        cbt.add(new Element<>(item, priority));
        size++;
        heapifyUp(size - 1);
    }

    public T front()
    {
        return cbt.get(0).value();
    }

    // Time complexity: O(logn)
    public void removeFront()
    {
        cbt.set(0, cbt.get(size - 1));
        cbt.remove(size - 1);
        size--;
        heapifyDown(0);
    }

    // Time complexity: O(logn)
    private void heapifyUp(int child)
    {
        int parent = getParent(child);
        while(child > 0 && checkPriority(child, parent))
        {
            swap(child, parent);
            child = parent;
            parent = getParent(child);
        }
    }

    /* 
     * Time complexity  : O(logn)
     * Space complexity : O(logn)
     */
    private void heapifyDown(int parent)
    {
        int left = left(parent);
        int right = right(parent);
        int higher = parent;
        if(left < size && checkPriority(left, higher))
        {
            higher = left;
        }
        if(right < size && checkPriority(right, higher))
        {
            higher = right;
        }
        if(higher != parent)
        {
            swap(parent, higher);
            heapifyDown(higher);
        }        
    }

    private int getParent(int child)
    {
        return (child - 1) / 2;
    }

    private int left(int parent)
    {
        return (2 * parent) + 1;
    }

    private int right(int parent)
    {
        return (2 * parent) + 2;
    }

    /*
     * Checks if the element at i has higher priority than element at j
     */
    private boolean checkPriority(int i, int j)
    {
        if(isMin)
        {
            return cbt.get(i).priority() < cbt.get(j).priority();
        }
        return cbt.get(i).priority() > cbt.get(j).priority();
    }

    private void swap(int i, int j)
    {
        Element<T> temp = cbt.get(i);
        cbt.set(i, cbt.get(j));
        cbt.set(j, temp);
    }
}

class Element<T>
{
    private T value;
    private int priority;

    public Element(T value, int priority)
    {
        this.value = value;
        this.priority = priority;
    }

    public T value()
    {
        return value;
    }

    public int priority()
    {
        return priority;
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }
}
```

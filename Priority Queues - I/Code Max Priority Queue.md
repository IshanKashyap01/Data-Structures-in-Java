# Code Max Priority Queue

```Java
import java.util.ArrayList;
/*
 * Time complexity  : O(1)*
 * Space complexity : O(1)
 */
public class PQ 
{
    // Complete this class
    private ArrayList<Integer> heap;

    public PQ()
    {
        heap = new ArrayList<>();
    }

    boolean isEmpty() 
    {
        return heap.isEmpty();
    }

    int getSize() 
    {
        return heap.size();
    }

    int getMax() 
    {
        return heap.get(0);
    }

    // Time complexity: O(logn)
    void insert(int element) 
    {
        heap.add(element);
        int child = heap.size() - 1, parent;
        while(child > 0)
        {
            parent = (child - 1) / 2;
            if(heap.get(parent) < heap.get(child))
            {
                swap(parent, child);
                child = parent;
            }
            else
            {
                break;
            }
        }
    }

    // Time complexity: O(logn)
    int removeMax() 
    {
        if(isEmpty())
        {
            return Integer.MAX_VALUE;
        }
        int ans = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        
        int left, right, parent, max = 0;
        do
        {
            parent = max;
            left = 2 * parent + 1;
            right = 2 * parent + 2;
            if(left < heap.size() && heap.get(max) < heap.get(left))
            {
                max = left;
            }
            if(right < heap.size() && heap.get(max) < heap.get(right))
            {
                max = right;
            }
            swap(max, parent);
        }while(parent != max);
        
        return ans;
    }

    
    void swap(int i, int j)
    {
        int k = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, k);
    }
}
```

# Code: Remove Min

```Java
import java.util.ArrayList;
public class PQ {

    private ArrayList<Integer> heap;

    public PQ() {
        heap = new ArrayList<Integer>();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int size() {
        return heap.size();
    }

    int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            // Throw an exception
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    // Time complexity: O(logn)
    int removeMin() throws PriorityQueueException
    {
        if(isEmpty())
        {
            throw new PriorityQueueException();
        }
        // replace first with last and remove it
        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int left, right, parent = 0, higher = parent;
        while(true)
        {
            left = 2 * higher + 1;
            right = 2 * higher + 2;
            if(left < heap.size() && heap.get(left) < heap.get(higher))
            {
                higher = left;
            }
            if(right < heap.size() && heap.get(right) < heap.get(higher))
            {
                higher = right;
            }
            if(higher == parent)
            {
                break;
            }
            swap(parent, higher);
            parent = higher;
        }
        return min;
    }

    private void swap(int i, int j)
    {
        int k = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, k);
    }
}

class PriorityQueueException extends Exception {

}
```

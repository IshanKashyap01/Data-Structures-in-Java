# Dequeue

## Problem Statement

You need to implement a class for Dequeue i.e. for double ended queue. In this
queue, elements can be inserted and deleted from both the ends.

You don't need to double the capacity.

You need to implement the following functions:

### Constructor

You need to create the appropriate constructor. Size for the queue passed is
10.

### `insertFront()`

This function takes an element as input and insert the element at the front of
queue. Insert the element only if queue is not full. And if queue is full,
print -1 and return.

### `insertRear()`

This function takes an element as input and insert the element at the end of
queue. Insert the element only if queue is not full. And if queue is full,
print -1 and return.

### `deleteFront()`

This function removes an element from the front of queue. Print -1 if queue is
empty.

### `deleteRear()`

This function removes an element from the end of queue. Print -1 if queue is
empty.

### `getFront()`

Returns the element which is at front of the queue. Return -1 if queue is
empty.

### `getRear()`

Returns the element which is at end of the queue. Return -1 if queue is empty.

## Detailed Explanation

### Input Format

Input is already managed for you. You just have to implement given functions.

### Output Format

Output is already managed for you. You just have to implement given functions.

```ltf
Sample Input 1:
5 1 49 1 64 2 99 5 6 -1
Sample Output 1:
-1
64
99
Explanation:
The first choice code corresponds to getFront. Since the queue is empty, hence
the output is -1. 
1. adds 49 at the top and the resultant queue becomes: 49.
2. adds 64 at the top and the resultant queue becomes: 64 -> 49
3. add 99 at the end and the resultant queue becomes: 64 -> 49 -> 99
4. corresponds to getFront. Hence the output is 64.
5. corresponds to getRear. Hence the output is 99.
```

## Solution

```java
import java.util.ArrayList;

public class Dequeue 
{
    private ArrayList<Integer> list;
    private int size;

    public Dequeue(int size)
    {
        this.list = new ArrayList<>(size);
        this.size = size;
    }

    public void insertFront(int element)
    {
        if(isQueueFull())
        {
            System.out.println(-1);
            return;
        }
        this.list.add(0, element);
    }

    public void insertRear(int element)
    {
        if(isQueueFull())
        {
            System.out.println(-1);
            return;
        }
        this.list.add(element);
    }

    public void deleteFront()
    {
        if(this.list.isEmpty())
        {
            System.out.println(-1);
            return;
        }
        this.list.remove(0);
    }

    public void deleteRear()
    {
        if(this.list.isEmpty())
        {
            System.out.println(-1);
            return;
        }
        this.list.remove(this.list.size() - 1);
    }

    public int getFront()
    {
        return this.list.isEmpty() ? -1 : this.list.get(0);
    }

    public int getRear()
    {
        return this.list.isEmpty() ? -1 : this.list.get(this.list.size() - 1);
    }

    private boolean isQueueFull()
    {
        return this.list.size() == this.size;
    }
}
```

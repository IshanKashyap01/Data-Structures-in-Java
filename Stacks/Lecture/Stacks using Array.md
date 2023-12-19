# Stacks using Array

```Java
/*
 * A very simple stack implementation with fixed capacity that accepts only integers
 */
public class Stack
{
    private int[] stack;
    private int topIndex;
    private int capacity;

    /**
     * creates a stack with a default capacity of 20 elements
     */
    public Stack()
    {
        Stack(20);
    }

    public Stack(int capacity)
    {
        data = new int[capacity];
        topIndex = -1;
        this.capacity = capacity;
    }

    public void push(int data)
    {
        if(topIndex == capacity)
        {
            // throw stack full exception
        }
        stack[++topIndex] = data;
    }

    public int top()
    {
        if(topIndex == -1)
        {
            // throw stack empty exception
        }
        return stack[topIndex];
    }

    public int pop()
    {
        if(topIndex == -1)
        {
            // throw stack empty exception
        }
        return stack[topIndex--];
    }

    public int size()
    {
        return topIndex + 1;
    }

    public boolean isEmpty()
    {
        return topIndex == -1;
    }
}
```

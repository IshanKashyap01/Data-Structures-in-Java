# Stack Using LL

```Java
/*
 * Space complexity : O(1)
 * for all functions
 */
public class Stack 
{

    //Define the data members
    private Node head;
    private Node tail;
    private int topIndex;

    // Time complexity: O(1)
    public Stack() 
    {
        topIndex = -1;
    }
    
    /*----------------- Public Functions of Stack -----------------*/

    // Time complexity: O(1)
    public int getSize() 
    {
        return topIndex + 1;
    }

    // Time complexity: O(1)
    public boolean isEmpty()
    {
        return topIndex == -1;
    }

    // Time complexity: O(1)
    public void push(int element) 
    {
        if(isEmpty())
        {
            head = tail = new Node(element);
        }
        else
        {
           tail.next = new Node(element);
           tail = tail.next;
        }
        topIndex++;
    }

    // Time complexity: O(n)
    public int pop() 
    {
        if(isEmpty())
        {
            return -1;
        }
        int pop = tail.data;
        if(topIndex == 0)
        {
            head = tail = null;
            topIndex--;
        }
        else
        {
            Node newTail = getNode(--topIndex);
            newTail.next = null;
            tail = newTail;
        }
        return pop;
    }

    // Time complexity: O(1)
    public int top() 
    {
        if(isEmpty())
        {
            return -1;
        }
        return tail.data;
    }

    // Time complexity: O(n)
    private Node getNode(int index)
    {
        Node temp = head;
        int i = 0;
        while(temp != null && i != index)
        {
            temp = temp.next;
            i++;
        }
        return temp;
    }
}
```

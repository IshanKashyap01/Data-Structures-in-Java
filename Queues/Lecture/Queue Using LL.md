# Queue Using LL

```Java
/*
 * Time & space complexity : O(1)
 * for all functions
 */
public class Queue 
{    
    //Define the data members
    private Node front;
    private Node rear;
    private int size;

    public Queue()
    {
    }

    /*----------------- Public Functions of Stack -----------------*/

    public int getSize()
    { 
        return size;
    }


    public boolean isEmpty() 
    {
        return size == 0;
    }


    public void enqueue(int data) 
    {
        if(size == 0)
        {
            front = rear = new Node(data);
        }
        else
        {
            rear.next = new Node(data);
            rear = rear.next;
        }
        size++;
    }


    public int dequeue() 
    {
        if(isEmpty())
        {
            return -1;
        }
        int temp = front.data;
        front = front.next;
        size--;
        return temp;
    }


    public int front() 
    {
        return isEmpty() ? -1 : front.data;
    }
}
```

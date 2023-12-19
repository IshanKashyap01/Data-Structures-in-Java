# Append Last N to First

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) 
    {
        int size = getSize(head);
        Node<Integer> tail = getNode(head, size - 1), prev = getNode(head, size - n - 1);
        if(tail != null && prev != null)
        {
            tail.next = head;
            head = prev.next;
            prev.next = null;
        }        
        return head;
    }

    private static Node<Integer> getNode(Node<Integer> head, int index)
    {
        for(int i = 0; i < index && head != null && head.data != -1; i++)
        {
            head = head.next;
        }
        return head;
    }

    private static int getSize(Node<Integer> head)
    {
        int count = 0;
        while(head != null && head.data != -1)
        {
            count++;
            head = head.next;
        }
        return count;
    }
}
```

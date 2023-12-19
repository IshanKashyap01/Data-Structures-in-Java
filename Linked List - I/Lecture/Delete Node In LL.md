# Delete Node In LL

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static Node<Integer> deleteNode( Node<Integer> head, int pos) 
    {
        if(head == null)
        {
            return head;
        }
        if(pos == 0)
        {
            return head.next;
        }
        Node<Integer> prev = head;
        for(int i = 0; i < pos - 1 && prev.data != -1; i++)
        {
            prev = prev.next;
        }
        if(prev.data != -1 && prev.next != null)
        {
            prev.next = prev.next.next;
        }
        return head;
    }
}
```

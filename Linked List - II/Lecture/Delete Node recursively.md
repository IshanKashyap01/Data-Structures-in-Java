# Delete Node recursively

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) 
    {
        if(head == null)
        {
            return head;
        }
        if(pos == 0)
        {
            return head.next;
        }
        head.next = deleteNodeRec(head.next, pos - 1);
        return head;
    }
}
```

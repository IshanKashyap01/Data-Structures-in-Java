# Mid Point Linked List

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static Node<Integer> midPoint(Node<Integer> head) 
    {
        if(head == null)
        {
            return head;
        }
        Node<Integer> slow = head, fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```

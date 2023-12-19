# Reverse LL (Recursive)

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static Node<Integer> reverseRec(Node<Integer> head) 
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        Node<Integer> rev = reverseRec(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }
}
```

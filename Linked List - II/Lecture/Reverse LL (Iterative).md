# Reverse LL (Iterative)

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{

    public static Node<Integer> reverse_I(Node<Integer> head)
    {
       Node<Integer> prev = null, next = null;
       while(head != null)
       {
           next = head.next;
           head.next = prev;
           prev = head;
           head = next;
       }
       return prev;
    }
}
```

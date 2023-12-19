# kReverse

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static Node<Integer> kReverse(Node<Integer> head, int k) 
    {
        // base case
        if(head == null || k == 0)
        {
            return head;
        }
        Node<Integer> firstK = head, tail = head, next;
        // break the first k and get the next head
        for(int i = 1; i < k && tail != null; i++)
        {
            tail = tail.next;
        }
        next = tail != null ? tail.next : null;
        if(tail != null)
        {
            tail.next = null;
        }
        // reverse the first k
        firstK = reverse(firstK);
        // head is now the tail of the reversed list
        head.next = kReverse(next, k);
        return firstK;
    }

    private static Node<Integer> reverse(Node<Integer> head)
    {
        Node<Integer> curr = head, prev = null, next = null;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
```

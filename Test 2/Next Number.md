# Next Number

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) 
    {
        head = reverse(head);
        int carry = 1, sum = 0;
        LinkedListNode<Integer> curr = head, prev = null;
        while(curr != null)
        {
            sum = carry + curr.data;
            curr.data = sum % 10;
            carry = sum / 10;
            prev = curr;
            curr = curr.next;
        }
        if(carry != 0)
        {
            prev.next = new LinkedListNode<>(carry);
        }
        return reverse(head);
    }

    private static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head)
    {
        LinkedListNode<Integer> prev = null, curr = head, next = null;
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

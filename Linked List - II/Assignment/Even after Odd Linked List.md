# Even after Odd Linked List

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static Node<Integer> evenAfterOdd(Node<Integer> head) 
    {
        // base case
        if(head == null || head.next == null)
        {
            return head;
        }
        Node<Integer> oddHead = head;
        Node<Integer> tail = oddHead;
        // move tail to the correct position
        if(tail.data % 2 != 0)
        {
            tail = getOddTail(tail);
        }
        // exit if tail is at the end i.e. there are no even numbers
        if(tail.next == null)
        {
            return head;
        }
        // change the list and return the new head
        return makeSwaps(head, oddHead, tail);
    }

    private static Node<Integer> getOddTail(Node<Integer> tail)
    {
        while(tail.next != null && tail.next.data % 2 != 0)
        {
            tail = tail.next;
        }
        return tail;
    }

    // There are even numbers in the list
    private static Node<Integer> makeSwaps
    (Node<Integer> head, Node<Integer> oddHead, Node<Integer> tail)
    {
        Node<Integer> prev = null, curr = head;
        // if there is a correct oddHead and tail
        if(oddHead.data % 2 != 0)
        {
            // move prev to tail and curr next to tail
            prev = tail;
            curr = tail.next;
        }
        while(curr != null)
        {
            if(curr.data % 2 == 0)
            {
                prev = curr;
                curr = curr.next;
            }
            else
            {
                // break curr off the list
                prev.next = curr.next;
                // if oddHead is correct
                if(oddHead.data % 2 != 0)
                {        
                    // join curr next to the tail
                    curr.next = tail.next;
                    tail.next = curr;
                }
                else
                {
                    // place curr at the head of the list
                    curr.next = oddHead;
                    oddHead = curr;
                }
                // update tail and curr
                tail = curr;
                curr = prev.next;
            }
        }
        return oddHead;
    }
}
```

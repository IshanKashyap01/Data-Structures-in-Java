# Next Number

Given a large number represented in the form of a linked list. Write code to
increment the number by 1 in-place(i.e. without using extra space).

Note: You don't need to print the elements, just update the elements and return
the head of updated LL.

## Detailed Explanation

### Input format

Linked list elements (separated by space and terminated by -1)

### Output Format

Updated linked list elements

### Constraints

$1 <= n <=10^6.$

Where `n` is the length of the linked list

```ltf
Sample Input 1:
3 9 2 5 -1
Sample Output 1:
3 9 2 6
Sample Input 2:
9 9 9 -1
Sample Output 1:
1 0 0 0 
```

## Solution

```java
public class Solution
{
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head)
    {
        head = reverse(head);
        int carry = 1, sum = 0;
        LinkedListNode<Integer> curr = head, prev = null;
        // At the beginning of each iterations, all previous numbers were updated and leftover
        // a carry.
        while(curr != null && carry != 0)
        {
            // add the carry to the digit
            sum = curr.data + carry;
            curr.data = sum % 10;
            // pass on the next carry-over, if valid
            carry = sum / 10;
            // prepare for the next iteration
            prev = curr;
            curr = curr.next;
        }
        // if there was a carry over after the loop, a new node needs to be added
        if(carry != 0)
        {
            prev.next = new LinkedListNode<>(carry);
        }
        return reverse(head);
    }
    /*
    * Time complexity  : O(n)
    * Space complexity : O(1)
    */
    private static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head)
    {
        LinkedListNode<Integer> prev = null, curr = head, next = head;
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

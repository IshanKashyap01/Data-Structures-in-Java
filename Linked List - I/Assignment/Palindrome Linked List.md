# Palindrome Linked List

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static boolean isPalindrome(Node<Integer> head) 
    {
        Node<Integer> mid = getMid(head);
        Node<Integer> revHead = reverse(mid);
        while(revHead != null && head != null)
        {
            if(!revHead.data.equals(head.data))
            {
                return false;
            }
            head = head.next;
            revHead = revHead.next;
        }
        return true;
    }

    private static Node<Integer> getMid(Node<Integer> head)
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

    private static Node<Integer> reverse(Node<Integer> head)
    {
        Node<Integer> prev = null, next = null;
        while(head != null)
        {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        System.out.println();
        return prev;
    }

    private static void printList(Node<Integer> root)
    {
        if(root != null)
        {
            System.out.print(root.data + " ");
            printList(root.next);
        }
    }
}
```

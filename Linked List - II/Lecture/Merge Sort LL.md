# Merge Sort LL

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static Node<Integer> mergeSort(Node<Integer> head) 
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        Node<Integer> mid = getMid(head);
        Node<Integer> left = head;
        Node<Integer> right = mid.next;
        mid.next = null;
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
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

    private static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2)
    {
        if(head1 == null || head2 == null)  
        {
            return head1 == null ? head2 : head1;
        }
        Node<Integer> head = head1.data < head2.data ? head1 : head2;
        Node<Integer> tail = head;
        Node<Integer> t1 = head == head1 ? head1.next : head2.next;
        Node<Integer> t2 = head == head1 ? head2 : head1;

        while(t1 != null && t2 != null)
        {
            tail.next = t1.data < t2.data ? t1 : t2;
            t1 = t1 == tail.next ? t1.next : t1;
            t2 = t2 == tail.next ? t2.next : t2;
            tail = tail.next;
        }
        tail.next = t1 == null ? t2 : t1;

        return head;
    }
}
```

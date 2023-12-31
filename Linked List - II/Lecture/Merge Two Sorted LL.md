# Merge Two Sorted LL

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{    
    public static Node<Integer> mergeTwoSorteds(Node<Integer> head1, Node<Integer> head2) 
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

# Swap Two Nodes of Linked List

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) 
    {
        if(i == j)
        {
            return head;
        }
        if(i > j)
        {
            int temp = i;
            i = j;
            j = temp;
        }
        Node<Integer> first = head, second, prev1, prev2;
        int k = 0;
        for(; k < i - 1; k++)
        {
            first = first.next;
        }
        prev1 = first;
        first = i != 0 ? prev1.next : first;
        if(j - i == 1)
        {
            second = first.next;
            prev1.next = second;
            first.next = second.next;
            second.next = first;
            return head;
        }
        prev2 = prev1;
        for(; k < j - 1; k++)
        {
            prev2 = prev2.next;
        }
        second = prev2.next;
        if(i == 0)
        {
            prev2.next = second.next;
            second.next = first.next;
            first.next = prev2.next;
            prev2.next = first;
            head = second;
        }
        else
        {
            prev1.next = first.next;
            prev2.next = second.next;
            first.next = prev2.next;
            second.next = prev1.next;
            prev1.next = second;
            prev2.next = first;
        }
        return head;        
    }
}
```

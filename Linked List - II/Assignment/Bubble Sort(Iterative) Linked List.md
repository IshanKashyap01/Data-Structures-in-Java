# Bubble Sort(Iterative) Linked List

```Java
/*
 * Time complexity  : O(n^2)
 * Space complexity : O(n)
 */
public class Solution
{
    public static Node<Integer> bubbleSort(Node<Integer> head) 
    {
        Node<Integer> curr = head;
        int n = size(head);
        for(int i = 0; i < n; i++)
        {
            curr = head;
            for(int j = 0; j < n - i; j++)
            {
                if(curr.next != null && curr.data > curr.next.data)
                {
                    swapNext(curr);
                }
                curr = curr.next;
            }
        }
        return head;
    }

    private static int size(Node<Integer> head)
    {
        int i = 0;
        while(head != null)
        {
            head = head.next;
            i++;
        }
        return i;
    }

    private static void swapNext(Node<Integer> node)
    {
        int temp = node.data;
        node.data = node.next.data;
        node.next.data = temp;
    }
}
```

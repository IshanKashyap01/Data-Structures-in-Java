# Eliminate Duplicates

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static Node<Integer> removeDuplicates(Node<Integer> head) 
    {
        Node<Integer> temp = head;
        while(temp != null)
        {
            while(temp.next != null && temp.data.equals(temp.next.data))
            {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}
```

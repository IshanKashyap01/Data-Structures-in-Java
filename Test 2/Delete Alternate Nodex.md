# Delete Alternate Nodex

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static void deleteAlternateNodes(Node<Integer> head) 
    {
        while(head != null && head.next != null)
        {
            head.next = head.next.next;
            head = head.next;
        }
    }
}
```

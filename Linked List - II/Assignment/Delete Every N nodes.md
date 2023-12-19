# Delete Every N nodes

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    
    public static Node<Integer> skipMdeleteN(Node<Integer> head, int m, int n) 
    {
        if(m == 0)
        {
            return null;
        }
        if(n == 0)
        {
            return head;
        }
        Node<Integer> curr = head, prev = curr;
        while(curr != null)
        {
            int i = 1;
            while(curr != null && i != m)
            {
                curr = curr.next; i++;
            }
            if(curr == null)
            {
                break;
            }
            prev = curr;
            curr = curr.next;
            int j = 0;
            while(curr != null && j != n)
            {
                curr = curr.next; j++;
            }
            prev.next = curr;
        }
        return head;
    }
}
```

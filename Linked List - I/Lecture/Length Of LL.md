# Length Of LL

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static int length(Node head)
    {
        int count = 0;
        while(head != null)
        {
            count++;
            head = head.next;
        }
        return count;
    }
}
```

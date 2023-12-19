# Find a Node in LL (recursive)

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int findNodeRec(Node<Integer> head, int n) 
    {
        if(head == null)        
        {
            return -1;
        }
        if(head.data == n)
        {
            return 0;
        }
        int index = findNodeRec(head.next, n);
        return index == -1 ? -1 : 1 + index;
    }
}
```

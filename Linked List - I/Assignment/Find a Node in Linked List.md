# Find a Node in Linked List

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static int findNode(Node<Integer> head, int data) 
    {
        for(int i = 0; head != null; i++)
        {
            if(head.data == data)
            {
                return i;
            }
            head = head.next;
        }
        return -1;
    }
}
```

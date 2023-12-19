# Print ith Node

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static void printIthNode(Node<Integer> head, int i)
    {
        for(int j = 0; j < i && head != null; j++)        
        {
            head = head.next;
        }
        if(head != null)
        {
            System.out.println(head.data);
        }
    }
}
```

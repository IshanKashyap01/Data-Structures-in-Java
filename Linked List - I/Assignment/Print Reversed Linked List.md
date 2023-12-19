# Print Reversed Linked List

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */
public class Solution 
{
    public static void printReverse(Node<Integer> root) 
    {
        if(root != null)
        {
            printReverse(root.next);
            System.out.print(root.data + " ");
        }
    }
}
```

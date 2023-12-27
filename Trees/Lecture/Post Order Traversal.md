# Post Order Traversal

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void printPostOrder(TreeNode<Integer> root)
    {
        if(root != null)
        {
            for(TreeNode<Integer> child : root.children)
            {
                printPostOrder(child);
            }
            System.out.print(root.data + " ");
        }
    }
}
```

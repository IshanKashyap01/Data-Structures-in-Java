# Postorder Binary Tree

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void postOrder(BinaryTreeNode<Integer> root) 
    {
        if(root != null)
        {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
```

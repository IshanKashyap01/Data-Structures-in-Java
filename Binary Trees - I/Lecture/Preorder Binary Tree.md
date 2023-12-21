# Preorder Binary Tree

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void preOrder(BinaryTreeNode<Integer> root) 
    {
        if(root != null)
        {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
```

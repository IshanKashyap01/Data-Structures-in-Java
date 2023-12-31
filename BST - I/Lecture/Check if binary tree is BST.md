# Check if binary tree is BST

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static boolean isBST(BinaryTreeNode<Integer> root) 
    {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean helper(BinaryTreeNode<Integer> root, int min, int max)
    {
        if(root == null)
        {
            return true;
        }
        // current node must be in the range [min, max)
        if(root.data < min || root.data >= max)
        {
            return false;
        }
        return helper(root.left, min, root.data) && helper(root.right, root.data, max);
    }
}
```

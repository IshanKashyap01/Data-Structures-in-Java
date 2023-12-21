# Replace Node with Depth

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void changeToDepthTree(BinaryTreeNode<Integer> root) 
    {
        helper(root, 0);
    }

    private static void helper(BinaryTreeNode<Integer> root, int depth)
    {
        if(root != null)
        {
            root.data = depth;
            helper(root.left, depth + 1);
            helper(root.right, depth + 1);
        }
    }
}
```

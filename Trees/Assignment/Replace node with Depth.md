# Replace node with Depth

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void replaceWithDepthValue(TreeNode<Integer> root)
    {
        helper(root, 0);
    }

    private static void helper(TreeNode<Integer> root, int depth)
    {
        root.data = depth;
        for(TreeNode<Integer> child : root.children)
        {
            helper(child, depth + 1);
        }
    }
}
```

# Find Height

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int getHeight(TreeNode<Integer> root)
    {
        // special case
        if(root == null)
        {
            return 0;
        }
        int height = 1;
        for(TreeNode<Integer> child : root.children)
        {
            height = Math.max(height, 1 + getHeight(child));
        }
        return height;
    }
}
```

# Height of Tree

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int height(BinaryTreeNode<Integer> root) 
    {
        if(root != null)
        {
            return 1 + Math.max(height(root.left), height(root.right));
        }
        return 0;
    }
}
```

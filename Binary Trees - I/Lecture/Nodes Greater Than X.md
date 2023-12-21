# Nodes Greater Than X

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) 
    {
        if(root != null)
        {
            return countNodesGreaterThanX(root.left, x) + countNodesGreaterThanX(root.right, x)
            + (root.data > x ? 1 : 0);
        }
        return 0;
    }
}
```

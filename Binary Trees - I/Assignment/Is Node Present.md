# Is Node Present

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution
{
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) 
    {
        if(root != null)
        {
            if(root.data == x)
            {
                return true;
            }
            return isNodePresent(root.left, x) || isNodePresent(root.right, x);
        }
        return false;
    }
}
```

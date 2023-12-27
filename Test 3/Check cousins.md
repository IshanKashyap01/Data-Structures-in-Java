# Check cousins

```Java
import java.util.ArrayList;
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) 
    {
        return getDepth(root, p) == getDepth(root, q) && !areSiblings(root, p, q);
    }

    private static boolean areSiblings(BinaryTreeNode<Integer> root, int p, int q)
    {
        if(root == null)
        {
            return false;
        }
        if(root.left != null && root.right != null)
        {
            if(root.left.data == p && root.right.data == q)
            {
                return true;
            }
            if(root.left.data == q && root.right.data == p)
            {
                return true;
            }
        }
        return areSiblings(root.left, p, q) || areSiblings(root.right, p, q);
    }

    private static int getDepth(BinaryTreeNode<Integer> root, int target)
    {
        if(root == null)
        {
            return 0;
        }
        if(root.data == target)
        {
            return 1;
        }
        int left = getDepth(root.left, target);
        if(left != 0)
        {
            return 1 + left;
        }
        int right = getDepth(root.right, target);
        if(right != 0)
        {
            return 1 + right;
        }
        return 0;
    }    
}
```

# Largest BST

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) 
    {
        return helper(root).height;
    }

    private static IsBST helper(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return new IsBST(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
        }
        // using the subtrees, check if tree is a BST or not
        return getIsBST(root, helper(root.left), helper(root.right));
        
    }

    private static IsBST getIsBST(BinaryTreeNode<Integer> root, IsBST left, IsBST right)
    {
        IsBST ans = new IsBST();
        ans.min = Math.min(root.data, Math.min(left.min, right.min));
        ans.max = Math.max(root.data, Math.max(left.max, right.max));
        ans.height = Math.max(left.height, right.height);
        ans.isBST = isRootBST(root, left, right);
        if(ans.isBST)
        {
            ans.height++;
        }
        return ans;
    }

    private static boolean isRootBST(BinaryTreeNode<Integer> root, IsBST left, IsBST right)
    {
        if(!left.isBST || !right.isBST)
        {
            return false;
        }
        // no value in left/right subtree should be greater/smaller than root
        if(left.max > root.data || right.min < root.data)
        {
            return false;
        }
        return true;
    }
}

class IsBST
{
    int min;
    int max;
    boolean isBST;
    int height;

    public IsBST(int min, int max, boolean isBST, int height)
    {
        this.min = min;
        this.max = max;
        this.isBST = isBST;
        this.height = height;
    }

    public IsBST()
    {

    }
}
```

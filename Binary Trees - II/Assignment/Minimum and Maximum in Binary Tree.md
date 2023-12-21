# Minimum and Maximum in Binary Tree

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) 
    {
        return new Pair(getMin(root), getMax(root));
    }

    private static int getMin(BinaryTreeNode<Integer> root)    
    {
        if(root != null)
        {
            return Math.min(root.data, Math.min(getMin(root.left), getMin(root.right)));
        }
        return Integer.MAX_VALUE;
    }

    private static int getMax(BinaryTreeNode<Integer> root)    
    {
        if(root != null)
        {
            return Math.max(root.data, Math.max(getMax(root.left), getMax(root.right)));
        }
        return Integer.MIN_VALUE;
    }
}
```

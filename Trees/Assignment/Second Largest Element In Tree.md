# Second Largest Element In Tree

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root)
    {
        int second = getSecondMax(root, getMax(root));
        if(second == Integer.MIN_VALUE)
        {
            return null;
        }
        return new TreeNode<>(second);
    }

    private static int getMax(TreeNode<Integer> root)
    {
        if(root == null)
        {
            return Integer.MIN_VALUE;
        }
        int max = root.data;
        for(TreeNode<Integer> child : root.children)
        {
            max = Math.max(max, getMax(child));
        }
        return max;
    }

    private static int getSecondMax(TreeNode<Integer> root, int max)
    {
        if(root == null)
        {
            return Integer.MIN_VALUE;
        }
        int second = (root.data != max) ? root.data : Integer.MIN_VALUE;
        for(TreeNode<Integer> child : root.children)
        {
            second = Math.max(second, getSecondMax(child, max));
        }
        return second;
    }
}
```

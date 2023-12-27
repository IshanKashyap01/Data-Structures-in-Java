# Next larger element

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n)
    {
        if(root == null)
        {
            return null;
        }
        TreeNode<Integer> max = null, curr;
        if(root.data > n)
        {
            max = root;
        }
        for(TreeNode<Integer> child : root.children)
        {
            curr = findNextLargerNode(child, n);
            if(curr != null)
            {
                if((max != null && curr.data < max.data) || max == null)
                {
                    max = curr;
                }
            }
        }
        return max;
    }    
}
```

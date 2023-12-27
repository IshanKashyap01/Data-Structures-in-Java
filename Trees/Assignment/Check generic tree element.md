# Check generic tree element

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{    
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x)
    {
        // special case
        if(root == null)
        {
            return false;
        }
        // base case
        if(root.data == x)
        {
            return true;
        }
        for(TreeNode<Integer> child : root.children)
        {
            if(checkIfContainsX(child, x))
            {
                return true;
            }
        }
        return false;
    }
}
```

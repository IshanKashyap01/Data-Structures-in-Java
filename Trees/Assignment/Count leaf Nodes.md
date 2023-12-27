# Count leaf Nodes

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{    
    public static int countLeafNodes(TreeNode<Integer> root)
    {
        if(root == null)
        {
            return 0;
        }
        if(root.children.isEmpty())
        {
            return 1;
        }
        int leaves = 0;
        for(TreeNode<Integer> child : root.children)
        {
            leaves += countLeafNodes(child);
        }
        return leaves;
    }
}
```

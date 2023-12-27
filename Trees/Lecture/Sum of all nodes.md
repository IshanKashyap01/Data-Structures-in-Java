# Sum of all nodes

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{    
    public static int sumOfAllNode(TreeNode<Integer> root)
    {
        // special case
        if(root == null)
        {
            return 0;
        }
        int sum = root.data;
        for(TreeNode<Integer> child : root.children)
        {
            sum += sumOfAllNode(child);
        }
        return sum;
    }
}
```

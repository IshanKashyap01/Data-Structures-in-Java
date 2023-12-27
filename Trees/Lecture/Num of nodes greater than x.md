# Num of nodes greater than x

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int numNodeGreater(TreeNode<Integer> root,int x)
    {
        // special case
        if(root == null)
        {
            return 0;
        }
        int count = root.data > x ? 1 :0;
        for(TreeNode<Integer> child : root.children)
        {
            count += numNodeGreater(child, x);
        }
        return count;
    }
}
```

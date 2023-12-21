# Sum of Nodes

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static int getSum(BinaryTreeNode<Integer> root) 
    {
        if(root == null)
        {
            return 0;
        }
        return root.data + getSum(root.left) + getSum(root.right);
    }
}
```

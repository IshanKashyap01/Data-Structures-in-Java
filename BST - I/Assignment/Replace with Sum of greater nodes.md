# Replace with Sum of greater nodes

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) 
    {
        getSum(root, 0);
    }

    public static int getSum(BinaryTreeNode<Integer> root, int sum)
    {
        if(root == null)
        {
            return sum;
        }
        // get the sum of right subtree and add it to the root
        sum = getSum(root.right, sum);
        root.data += sum;
        // return the sum from left subtree
        return getSum(root.left, root.data);
    }
}
```

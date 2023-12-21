# Path Sum Root to Leaf

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) 
    {
        helper(root, k, "");
    }

    private static void helper(BinaryTreeNode<Integer> root, int k, String path)
    {
        if(root != null)
        {
            if(root.data == k)
            {
                if(root.left == null && root.right == null)
                {
                    System.out.println(path + root.data);
                }
            }
            else
            {
                helper(root.left, k - root.data, path + root.data + " ");
                helper(root.right, k - root.data, path + root.data + " ");
            }
        }
    }

    private static boolean isLeaf(BinaryTreeNode<Integer> node)
    {
        return node.left == null && node.right == null;
    }
}
```

# Nodes without sibling

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) 
    {
        if(root != null)
        {
            if(root.left != null && root.right == null)
            {
                System.out.print(root.left.data + " ");
            }
            else if(root.left == null && root.right != null)
            {
                System.out.print(root.right.data + " ");
            }
            printNodesWithoutSibling(root.left);
            printNodesWithoutSibling(root.right);
        }
    }
}
```

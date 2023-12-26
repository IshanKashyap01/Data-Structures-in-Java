# LCA of BST

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    /*
     * if only one node is present, return it
     * if both are absent, return -1
     * all nodes will be unique
     */
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) 
    {
        if(root == null)
        {
            return -1;
        }
        if(root.data < a && root.data < b)
        {
            return getLCA(root.right, a, b);
        }
        if(root.data > a && root.data > b)
        {
            return getLCA(root.left, a, b);
        }
        // if root is in the range [a, b], it must be the LCA
        return root.data;
    }
}
```

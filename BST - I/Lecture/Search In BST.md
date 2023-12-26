# Search In BST

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) 
    {
        if(root != null)
        {
            if(k == root.data)
            {
                return true;
            }
            if(k < root.data)
            {
                return searchInBST(root.left, k);
            }
            return searchInBST(root.right, k);
        }
        return false;
    }
}
```

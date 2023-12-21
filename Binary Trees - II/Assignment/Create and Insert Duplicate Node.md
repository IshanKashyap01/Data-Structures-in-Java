# Create and Insert Duplicate Node

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) 
    {
        if(root != null)
        {
            // Insert the duplicate
            BinaryTreeNode<Integer> left = root.left;
            root.left = new BinaryTreeNode<>(root.data);
            root.left.left = left;
            // repeat for the subtrees
            insertDuplicateNode(left);
            insertDuplicateNode(root.right);
        }
    }
    
}
```

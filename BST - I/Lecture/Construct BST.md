# Construct BST

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n)
    {
        return helper(arr, 0, n - 1);
    }

    private static BinaryTreeNode<Integer> helper(int[] arr, int min, int max)
    {
        // base case
        if(min > max)
        {
            return null;
        }
        int mid = min + (max - min) / 2;
        BinaryTreeNode<Integer> root, left, right;
        // make the middle element the root
        root = new BinaryTreeNode<>(arr[mid]);
        // get the left and right subtrees recursively
        left = helper(arr, min, mid - 1);
        right = helper(arr, mid + 1, max);
        // join the left and right subtrees to the root
        root.left = left;
        root.right = right;
        // return the root
        return root;
    }
}
```

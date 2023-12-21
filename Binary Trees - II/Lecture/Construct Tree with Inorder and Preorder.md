# Construct Tree with Inorder and Preorder

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) 
    {
        return new BuildTree(preOrder, inOrder).getTree();
    }
}

class BuildTree
{
    private int[] preOrder;
    private int[] inOrder;

    public BuildTree(int[] preOrder, int[] inOrder)
    {
        this.preOrder = preOrder;
        this.inOrder = inOrder;
    }

    public BinaryTreeNode<Integer> getTree()
    {
        return buildTree(0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    private BinaryTreeNode<Integer> buildTree(int pstart, int pend, int istart, int iend)
    {
        if(pstart > pend || istart > iend)
        {
            return null;
        }
        // first element of preorder is the root
        BinaryTreeNode<Integer>root = new BinaryTreeNode<>(preOrder[pstart]);
        // find the position of root in inorder
        int index = findRoot(root.data, istart, iend);
        // left subtree starts after root in preorder and is the same size in inorder
        root.left = buildTree(pstart + 1, pstart + (index - istart) , istart, index - 1);
        // right subtree starts just after left in preorder
        root.right = buildTree((pstart + (index - istart)) + 1, pend, index + 1, iend);
        return root;
    }

    private int findRoot(int data, int istart, int iend)    
    {
        for(int i = istart; i <= iend; i++)
        {
            if(inOrder[i] == data)
            {
                return i;
            }
        }
        return -1;
    }
}
```

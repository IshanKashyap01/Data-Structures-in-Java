# Construct Tree with Inorder and Postorder

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) 
    {
        return new BuildTree(postOrder, inOrder).getTree();
    }
}

class BuildTree
{
    private int[] postOrder;
    private int[] inOrder;

    public BuildTree(int[] postOrder, int[] inOrder)
    {
        this.postOrder = postOrder;
        this.inOrder = inOrder;
    }

    public BinaryTreeNode<Integer> getTree()
    {
        return buildTree(0, postOrder.length - 1, 0, inOrder.length - 1);
    }

    private BinaryTreeNode<Integer> buildTree(int pstart, int pend, int istart, int iend)
    {
        if(pstart > pend || istart > iend)
        {
            return null;
        }
        // last element of postorder is the root
        BinaryTreeNode<Integer>root = new BinaryTreeNode<>(postOrder[pend]);
        // find the position of root in inorder
        int index = findRoot(root.data, istart, iend);
        // left subtree in postorder starts from pstart and is the same size in inorder
        root.left = buildTree(pstart, pstart + (index - istart) - 1 , istart, index - 1);
        // right subtree starts just after left in postorder
        root.right = buildTree((pstart + (index - istart)), pend - 1, index + 1, iend);
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

# BST Class

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class BinarySearchTree
{
    private BinaryTreeNode<Integer> root;
    
    public void insert(int data) 
    {
        // if the root itself is changed, then it needs to be returned
        root = insert(root, data);
    }
    
    public void remove(int data)
    {
        // if the root itself is changed, then it needs to be returned
        root = remove(root, data);
    }
    
    public void printTree()
    {
        printTree(root);
    }
    
    public boolean search(int data)
    {
        return search(root, data);
    }
    
    private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data)
    {
        if(root == null)
        {
            return new BinaryTreeNode<>(data);
        }
        if(data > root.data)
        {
            root.right = insert(root.right, data);
        }
        else
        {
            root.left = insert(root.left, data);
        }
        return root;
    }
    
    private static boolean search(BinaryTreeNode<Integer> root, int data)
    {
        if(root == null)
        {
            return false;
        }
        if(root.data == data)
        {
            return true;
        }
        if(data < root.data)
        {
            return search(root.left, data);
        }
        return search(root.right, data);
    }
    
    private static BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root, int data)
    {
        if(root == null)
        {
            return null;
        }
        if(data > root.data)
        {
            root.right = remove(root.right, data);
        }
        else if(data < root.data)
        {
            root.left = remove(root.left, data);
        }
        else
        {
            if(root.left == null || root.right == null)
            {
                return root.left == null ? root.right : root.left;
            }
            // get the minimum from right subtree
            root.data = getMin(root.right);
            root.right = remove(root.right, root.data);
        }
        return root;
    }

    private static void printTree(BinaryTreeNode<Integer> root)
    {
        if(root != null)
        {
            System.out.print(root.data + ":");
            if(root.left != null)
            {
                System.out.print("L:" + root.left.data + ",");
            }
            if(root.right != null)
            {
                System.out.print("R:" + root.right.data);
            }
            System.out.println();
            printTree(root.left);
            printTree(root.right);
        }
    }
    
    private static int getMin(BinaryTreeNode<Integer> root)
    {
        while(root.left != null)
        {
            root = root.left;
        }
        return root.data;
    }
}
```

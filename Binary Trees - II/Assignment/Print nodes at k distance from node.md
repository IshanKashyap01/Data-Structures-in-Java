# Print nodes at k distance from node

```Java
/*
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */
public class Solution 
{
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) 
    {
        distance(root, node, k);
    }

    private static int distance(BinaryTreeNode<Integer> root, int target, int k)
    {
        if(root != null)
        {
            // if root is the target, then check its subtree and return
            if(root.data == target)
            {
                print(root, k);
                return 0;
            }
            // get the distance from target via both subtrees
            int left = 1 + distance(root.left, target, k);
            int right = 1 + distance(root.right, target, k);
            if(left != -1)
            {
                if(left == k)
                {
                    System.out.println(root.data);
                }
                // target could be at the right distance from right subtree
                else
                {
                    print(root.right, k - left - 1);
                }
                return left;
            }
            else if(right != -1)
            {
                if(right == k)
                {
                    System.out.println(root.data);
                }
                // target could be at the right distance from left subtree
                else
                {
                    print(root.left, k - right - 1);
                }
                return right;
            }
        }
        // if the target does not exists in this tree/subtree
        return -2;
    }

    private static void print(BinaryTreeNode<Integer> root, int k)
    {
        if(root != null)
        {
            if(k == 0)
            {
                System.out.println(root.data);
            }
            print(root.left, k - 1);
            print(root.right, k - 1);
        }
    }
}
```
